package com.example.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@Component
public class CompanyResponse {

    private Long id;
    private String name;
    private String locatedCountry;
    private LocalDate createdAt;
}
