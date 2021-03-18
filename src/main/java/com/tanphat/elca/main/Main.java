package com.tanphat.elca.main;

import com.tanphat.elca.entity.Company;
import com.tanphat.elca.factory.ParserFactory;
import com.tanphat.elca.service.DataParser;
import com.tanphat.elca.service.iml.CSVParser;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // write your code here

//        get File Path
        Path filePath = Paths.get("/File/companies_big_data.csv");
        doTask(filePath);

//        Watch Service: monitor a predefined folder “import” for changes.
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path rootPath = Paths.get("D:\\File");
        rootPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        boolean poll = true;
        while (poll) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY && event.context().equals(filePath.getFileName())) {
                    System.out.println("Re Do Task after update file");
                    doTask(filePath);
                }
            }
            poll = key.reset();
        }


    }

    public static void doTask(Path filePath) {
        //      get Type File
        DataParser dataParser = ParserFactory.getFile(filePath);
//        read File and parse to data object
        dataParser = new CSVParser();
        List<Company> companies = dataParser.readData(filePath);

//       Output to the console the total capital of headquarters located in “CH”
        System.out.println("The total capital of headquarters located in “CH”: ");
        dataParser.totalCapitalOfHeaderQuarterLocatedIn(companies, "CH");
        System.out.println("The name of companies that the country is in “CH”. The list is sorted descending by capital :");
        dataParser.getNameOfCompaniesByCountry(companies, "CH");
    }
}
