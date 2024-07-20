package com.example.company_service.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private String location;
    private Integer numberOfEmployees;
    private Double review;
}
