package com.example.bookshopapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesRequest {

    @NotBlank
    @NotNull
    @NotEmpty
    private Long customer;
    @NotBlank
    @NotNull
    @NotEmpty
    private Long book;
    @NotBlank
    @NotNull
    @NotEmpty
    private int quantity;
    @NotBlank
    @NotNull
    @NotEmpty
    private double amount;

}
