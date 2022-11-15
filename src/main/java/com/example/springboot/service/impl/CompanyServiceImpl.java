package com.example.springboot.service.impl;

import com.example.springboot.dto.CompanyRequest;
import com.example.springboot.dto.CompanyResponse;
import com.example.springboot.exception.NotFoundException;
import com.example.springboot.mapper.CompanyMapper;
import com.example.springboot.model.Company;
import com.example.springboot.repository.CompanyRepository;
import com.example.springboot.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse save(CompanyRequest companyRequest) {
        return companyMapper.mapToResponse(
                companyRepository.save(
                        companyMapper.mapToEntity(companyRequest)
                )
        );
    }

    @Override
    public CompanyResponse findById(Long id) {
        return companyMapper.mapToResponse(
                getCompany(id)
        );
    }

    @Override
    public List<CompanyResponse> findAll() {
        return companyMapper.mapToResponse(
                companyRepository.findAll()
        );
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company company = getCompany(id);

        company.setName(companyRequest.getName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        companyRepository.save(company);

        return companyMapper.mapToResponse(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    private Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        String.format("Company with %d id not found!", id)
                ));
    }
}
