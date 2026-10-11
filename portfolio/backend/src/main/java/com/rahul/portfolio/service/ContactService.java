package com.rahul.portfolio.service;

import com.rahul.portfolio.dto.*;
import com.rahul.portfolio.entity.ContactMessage;
import com.rahul.portfolio.exception.TooManyRequestsException;
import com.rahul.portfolio.repository.ContactMessageRepository;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    private final ContactMessageRepository repo;
    private final int maxPerHour;

    public ContactService(ContactMessageRepository repo,
                          @Value("${app.contact.max-per-hour-per-ip:5}") int maxPerHour) {
        this.repo = repo;
        this.maxPerHour = maxPerHour;
    }

    public ContactResponse submit(ContactRequest req, String ip) {
        // Honeypot: bots fill the hidden field. Pretend success, store nothing.
        if (req.website() != null && !req.website().isBlank()) {
            log.warn("Honeypot triggered from {}", ip);
            return new ContactResponse(true, "Thank you! Your message has been received.");
        }
        if (repo.countByIpAddressAndCreatedAtAfter(ip, LocalDateTime.now().minusHours(1)) >= maxPerHour) {
            throw new TooManyRequestsException("Too many messages. Please try again later.");
        }
        ContactMessage m = new ContactMessage();
        m.setName(req.name().trim());
        m.setEmail(req.email().trim());
        m.setSubject(req.subject().trim());
        m.setMessage(req.message().trim());
        m.setIpAddress(ip);
        repo.save(m);
        log.info("Contact message saved id={}", m.getId());
        return new ContactResponse(true, "Thank you! Your message has been received.");
    }
}
