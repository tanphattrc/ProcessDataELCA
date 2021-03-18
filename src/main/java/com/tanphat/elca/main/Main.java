package com.tanphat.elca.main;

import com.tanphat.elca.entity.Company;
import com.tanphat.elca.factory.ParserFactory;
import com.tanphat.elca.service.DataParser;
import com.tanphat.elca.service.iml.CSVParser;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

//        get File Path
        Path filePath = Paths.get("/File/company.csv");
//      get Type File
        DataParser dataParser= ParserFactory.getFile(filePath);
//        read File and parse to data object
        dataParser= new CSVParser();
        List<Company> companies = dataParser.readData(filePath);

//       Output to the console the total capital of headquarters located in “CH”
        System.out.println("The total capital of headquarters located in “CH”: ");
        dataParser.totalCapitalOfHeaderQuarterLocatedIn(companies,"CH");
        System.out.println("The name of companies that the country is in “CH”. The list is sorted descending by capital :");
        dataParser.getNameOfCompaniesByCountry(companies,"CH");


    }
}
