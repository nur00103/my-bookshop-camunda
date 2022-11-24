package com.example.bookshopapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private String name;

    private AuthorRequest author;

    private TypeRequest type;

    private LanguageRequest language;

    private PublishingHouseRequest pubHouse;

    private int page;

    private int stock;

    private double price;

    private int discount;
}
