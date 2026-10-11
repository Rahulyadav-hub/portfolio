package com.rahul.portfolio.repository;

import com.rahul.portfolio.entity.ContactMessage;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    long countByIpAddressAndCreatedAtAfter(String ipAddress, LocalDateTime after);
}
