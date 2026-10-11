package com.rahul.portfolio.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import com.rahul.portfolio.dto.ContactRequest;
import com.rahul.portfolio.exception.TooManyRequestsException;
import com.rahul.portfolio.repository.ContactMessageRepository;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private final ContactMessageRepository repo = mock(ContactMessageRepository.class);
    private final ContactService service = new ContactService(repo, 5);

    private ContactRequest req(String website) {
        return new ContactRequest("Asha", "asha@example.com", "Hello there", "I would like to talk.", website);
    }

    @Test void savesValidMessage() {
        assertTrue(service.submit(req(""), "1.1.1.1").success());
        verify(repo).save(any());
    }

    @Test void honeypotIsNotStored() {
        assertTrue(service.submit(req("http://spam"), "1.1.1.1").success());
        verify(repo, never()).save(any());
    }

    @Test void rateLimitBlocks() {
        when(repo.countByIpAddressAndCreatedAtAfter(eq("1.1.1.1"), any())).thenReturn(5L);
        assertThrows(TooManyRequestsException.class, () -> service.submit(req(""), "1.1.1.1"));
    }
}
