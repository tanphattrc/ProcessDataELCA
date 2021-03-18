package com.tanphat.elca.service.iml;

import com.tanphat.elca.converter.CompanyConverter;
import com.tanphat.elca.entity.Company;
import com.tanphat.elca.service.DataParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public  class CSVParser extends DataParser {


    @Override
    public List<Company> readData(Path filePath) {
        List < Company > companies =  new ArrayList<>();  // Default to empty list.
        try
        {
            List data= Files.readAllLines(filePath);
            data.remove(0);

            for(Object line:data) {

                String[] attributes = line.toString().split(",");
                Company company = CompanyConverter.toEntity(attributes);
                companies.add(company);
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return companies;
    }
}
