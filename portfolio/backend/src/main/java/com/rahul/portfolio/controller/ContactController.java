package com.rahul.portfolio.controller;

import com.rahul.portfolio.dto.*;
import com.rahul.portfolio.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService service;

    public ContactController(ContactService service) { this.service = service; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public ContactResponse submit(@Valid @RequestBody ContactRequest req, HttpServletRequest http) {
        String fwd = http.getHeader("X-Forwarded-For");
        String ip = fwd != null && !fwd.isBlank() ? fwd.split(",")[0].trim() : http.getRemoteAddr();
        return service.submit(req, ip);
    }
}
