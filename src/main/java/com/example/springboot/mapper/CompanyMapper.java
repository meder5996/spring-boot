package com.example.springboot.mapper;

import com.example.springboot.dto.CompanyRequest;
import com.example.springboot.dto.CompanyResponse;
import com.example.springboot.exception.NotFoundException;
import com.example.springboot.model.Company;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyMapper {

    public Company mapToEntity(CompanyRequest companyRequest){
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        company.setCreatedAt(LocalDate.now());
        return company;
    }

    public CompanyResponse mapToResponse(Company company){
        CompanyResponse companyResponse = new CompanyResponse();

        if (company.getId() == null){
            throw new NotFoundException(String.format("Company with %d id not found!", company.getId()));
        }

        companyResponse.setId(company.getId());
        companyResponse.setName(company.getName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setCreatedAt(company.getCreatedAt());

        return companyResponse;
    }

    public List<CompanyResponse> mapToResponse(List<Company> companies){
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for(Company company: companies){
            companyResponses.add(mapToResponse(company));
        }
        return companyResponses;
    }
}
