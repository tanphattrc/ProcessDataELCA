package com.tanphat.elca.main;

import com.tanphat.elca.entity.Company;
import com.tanphat.elca.factory.FileReaderFactory;
import com.tanphat.elca.service.CompanyService;
import com.tanphat.elca.service.FileReader;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {
    private String filePath = "/File/company.csv";
    private FileReaderFactory fileReaderFactory = new FileReaderFactory();
    private FileReader fileReader = fileReaderFactory.createFileReader(filePath);
    private CompanyService companyService = new CompanyService(filePath, fileReader);

    public static void main(String[] args) throws IOException, InterruptedException {
        // write your code here
        Main main = new Main();
//        get File Path
        main.doTask();
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path rootPath = Paths.get("D:\\File");
        rootPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        boolean poll = true;
        while (poll) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                Path filePath = Paths.get(main.filePath);
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY && event.context().equals(filePath.getFileName())) {
                    System.out.println("Re Do Task after update file");
                    main.doTask();
                }
            }
            poll = key.reset();
        }


    }

    public void doTask() {
        //      get Type File

//       Output to the console the total capital of headquarters located in “CH”
        System.out.println("The total capital of headquarters located in “CH”: ");
        System.out.println(companyService.totalCapitalOfHeaderQuarterLocatedIn("CH"));
        System.out.println("The name of companies that the country is in “CH”. The list is sorted descending by capital :");
        companyService.getNameOfCompaniesByCountry("CH").forEach(System.out::println);
    }
}
