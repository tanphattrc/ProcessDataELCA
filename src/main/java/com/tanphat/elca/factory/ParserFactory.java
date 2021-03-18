package com.tanphat.elca.factory;

import com.tanphat.elca.service.DataParser;
import com.tanphat.elca.service.iml.CSVParser;

import java.nio.file.Path;

public class ParserFactory {
    private static volatile DataParser dataParser;
    private  ParserFactory()
    {

    }
    public  static synchronized DataParser getFile(Path readerType)
    {
        if(readerType.toString().indexOf(".csv")>0)
        {
            dataParser= new CSVParser();
        }
        return dataParser;
    }
}
