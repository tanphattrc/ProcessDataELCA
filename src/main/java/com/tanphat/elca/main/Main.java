package com.tanphat.elca.main;

import com.tanphat.elca.entity.Company;
import com.tanphat.elca.factory.ReaderFactory;
import com.tanphat.elca.service.CompanyService;
import com.tanphat.elca.service.DataReader;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {
    CompanyService companyService = CompanyService.getInstance();

    public static void main(String[] args) throws IOException, InterruptedException {
        // write your code here
            Main main = new Main();
//        get File Path
        Path filePath = Paths.get("/File/company.csv");
        main.doTask(filePath);

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
                    main.doTask(filePath);
                }
            }
            poll = key.reset();
        }


    }

    public void doTask(Path filePath) {
        //      get Type File
        DataReader dataReader = ReaderFactory.getFile(filePath);
//        read File and parse to data object

        List<Company> companies = dataReader.readData(filePath);
//        companies.forEach(System.out::println);

//       Output to the console the total capital of headquarters located in “CH”
        System.out.println("The total capital of headquarters located in “CH”: ");
      System.out.println(  companyService.totalCapitalOfHeaderQuarterLocatedIn(companies, "CH"));
        System.out.println("The name of companies that the country is in “CH”. The list is sorted descending by capital :");
     companyService.getNameOfCompaniesByCountry(companies, "CH").forEach(System.out::println);
    }
}
