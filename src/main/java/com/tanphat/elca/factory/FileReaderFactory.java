package com.tanphat.elca.factory;

import com.tanphat.elca.service.FileReader;
import com.tanphat.elca.service.iml.CSVReader;

import java.nio.file.Path;

public class FileReaderFactory {
    FileReader fileReader;


    public FileReader createFileReader(String filePath) {
        if (filePath.toString().indexOf(".csv") > 0) {
            fileReader = new CSVReader();
        }
        return fileReader;
    }
}
