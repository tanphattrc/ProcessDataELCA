package com.tanphat.elca.service.iml;

import com.tanphat.elca.converter.CompanyConverter;
import com.tanphat.elca.entity.Company;
import com.tanphat.elca.service.FileReader;
import com.tanphat.elca.service.LineProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVReader implements FileReader {


    @Override
    public void read(String filePath, LineProcessor lineProcessor) {

        String line;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID") && line.contains("Name") && line.contains("Capital")) {

                } else {
                    //separate all csv fields into string array
                    String[] lineVariables = line.split(",");
                    Company company = CompanyConverter.toEntity(lineVariables);
                    lineProcessor.process(company);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
