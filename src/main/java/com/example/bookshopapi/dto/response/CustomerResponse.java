package com.example.bookshopapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

}
