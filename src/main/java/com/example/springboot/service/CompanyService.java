package com.example.springboot.service;

import com.example.springboot.dto.CompanyRequest;
import com.example.springboot.dto.CompanyResponse;

import java.util.List;

public interface CompanyService {

    CompanyResponse save(CompanyRequest companyRequest);

    CompanyResponse findById(Long id);

    List<CompanyResponse> findAll();

    CompanyResponse update(Long id, CompanyRequest companyRequest);

    void delete(Long id);
}
