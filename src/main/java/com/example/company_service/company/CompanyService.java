package com.example.company_service.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public Long create(CompanyDto companyDto) {
        log.debug("Company to be created: {}", companyDto);
        Company savedCompany = companyRepository.save(companyMapper.dtoToEntity(companyDto));
        return savedCompany.getId();
    }

    public CompanyDto update(Long id, CompanyDto companyDto) {
        log.debug("Updating company with ID: {}", id);
        Company oldCompany = companyRepository.findById(id).orElse(null);
        if(oldCompany != null) {
            companyMapper.toUpdatedDto(oldCompany, companyDto);
            Company newCompany = companyRepository.save(oldCompany);
            return companyMapper.entityToDto(newCompany);
        }

        return null;
    }

    public void delete(Long id) {
        log.debug("Deleting company by ID: {}", id);
        Company company = companyRepository.findById(id).orElse(null);
        if(company != null) {
            companyRepository.deleteById(id);
        }
    }

    public CompanyDto findById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(companyMapper::entityToDto).orElse(null);
    }

    public List<CompanyDto> findAll() {
        return companyMapper.entityToDtoList(companyRepository.findAll());
    }
}
