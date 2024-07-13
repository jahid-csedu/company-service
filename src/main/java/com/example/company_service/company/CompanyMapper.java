package com.example.company_service.company;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDto entityToDto(Company company);
    Company dtoToEntity(CompanyDto companyDto);
    List<CompanyDto> entityToDtoList(List<Company> companies);
    @Mapping(target = "id", ignore = true)
    void toUpdatedDto(@MappingTarget Company company, CompanyDto companyDto);

}
