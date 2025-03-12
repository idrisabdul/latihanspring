package com.local.latihan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ContactResponse {

    private String id;

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

}
