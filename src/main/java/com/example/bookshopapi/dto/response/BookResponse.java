package com.example.bookshopapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;

    private AuthorResponse authorResponse;

    private TypeResponse typeResponse;

    private LanguageResponse languageResponse;

    private PublishingHouseResponse publishingHouseResponse;

    private int page;

    private int stock;

    private double price;

    private int discount;
}
