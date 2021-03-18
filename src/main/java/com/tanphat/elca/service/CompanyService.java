package com.tanphat.elca.service;

import com.tanphat.elca.entity.Company;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {

    private static CompanyService companyService;

    private CompanyService() {

    }

    public int totalCapitalOfHeaderQuarterLocatedIn(List<Company> companies, String location) {

        return companies.stream()
                .filter(i -> i.getCountry().equals(location))
                .mapToInt(Company::getCapital).sum();

    }

    public List<String> getNameOfCompaniesByCountry(List<Company> companies, String location) {
        return companies.stream().filter(i -> i.getCountry().equals(location)).
                sorted((a, b) -> b.getCapital().compareTo(a.getCapital()))
                .map(Company::getName).collect(Collectors.toList());
    }

    public static CompanyService getInstance() {
        if (companyService == null) {
            companyService = new CompanyService();
        }
        return companyService;
    }
}
