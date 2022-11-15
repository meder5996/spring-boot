package com.example.springboot.controller;

import com.example.springboot.dto.CompanyRequest;
import com.example.springboot.dto.CompanyResponse;
import com.example.springboot.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest){
        return companyService.save(companyRequest);
    }

    @GetMapping
    public List<CompanyResponse> findAll(){
        return companyService.findAll();
    }

    @GetMapping("{id}")
    public CompanyResponse findById(@PathVariable Long id){
        return companyService.findById(id);
    }

    @PutMapping("{id}")
    public CompanyResponse update(@PathVariable Long id, @RequestBody CompanyRequest companyRequest){
        return companyService.update(id, companyRequest);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        companyService.delete(id);
        return String.format("Company with %d id successfully deleted!", id);
    }
}
