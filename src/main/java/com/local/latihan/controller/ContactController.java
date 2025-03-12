package com.local.latihan.controller;

import com.local.latihan.dto.ContactResponse;
import com.local.latihan.dto.CreateContactRequest;
import com.local.latihan.dto.WebResponse;
import com.local.latihan.entity.User;
import com.local.latihan.service.ContactService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {


    private final ContactService contactService;
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(path = "/api/contacts",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.create(user, request);
        return WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build();
    }

    @GetMapping(path = "/api/contact/{contactId}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ContactResponse> get(User user, @PathVariable("contactId") String contactId){
        ContactResponse contactResponse = contactService.get(user, contactId);

        return WebResponse.<ContactResponse>builder()
                .data(contactResponse)
                .build();

    }
}
