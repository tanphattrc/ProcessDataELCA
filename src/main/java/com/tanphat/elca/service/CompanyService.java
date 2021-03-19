package com.tanphat.elca.service;

import com.tanphat.elca.entity.Company;
import com.tanphat.elca.factory.FileReaderFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {
    private String filePath;
    private FileReader fileReader;

    //    private static CompanyService companyService;
//
    public CompanyService(String filePath, FileReader fileReader) {
        this.filePath = filePath;

        this.fileReader = fileReader;

    }

    public int totalCapitalOfHeaderQuarterLocatedIn(String location) {
        List<Company> companies = new ArrayList<>();
        fileReader.read(filePath, company -> {
            if (company.getCountry().equals(location)) {
                companies.add(company);
            }
        });

        return companies.stream()
                .filter(i -> i.getCountry().equals(location))
                .mapToInt(Company::getCapital).sum();

    }

    public List<String> getNameOfCompaniesByCountry(String location) {
        List<Company> companies = new ArrayList<>();
        fileReader.read(filePath, company -> {
            if (company.getCountry().equals(location)) {
                companies.add(company);
            }
        });

        return companies.stream()
                .map(i -> i.getName())
                .collect(Collectors.toList());
    }

//    public static CompanyService getInstance() {
//        if (companyService == null) {
//            companyService = new CompanyService();
//        }
//        return companyService;
//    }
}
