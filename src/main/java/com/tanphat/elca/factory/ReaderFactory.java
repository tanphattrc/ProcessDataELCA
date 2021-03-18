package com.tanphat.elca.factory;

import com.tanphat.elca.service.DataReader;
import com.tanphat.elca.service.iml.CSVReader;

import java.nio.file.Path;

public class ReaderFactory {
    private static DataReader dataReader;

    private ReaderFactory() {

    }

    public static DataReader getFile(Path readerType) {
        if (readerType.toString().indexOf(".csv") > 0) {
            dataReader = new CSVReader();
        }
        return dataReader;
    }
}
