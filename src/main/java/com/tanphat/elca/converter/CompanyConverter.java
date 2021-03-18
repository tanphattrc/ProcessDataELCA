package com.tanphat.elca.converter;

import com.tanphat.elca.entity.Company;

public class CompanyConverter {
    public static Company toEntity(String[] metadata) {
        Integer id =Integer.parseInt( metadata[0]);
        String name = metadata[1];
        String foundationDate= metadata[2];
        Integer capital = Integer.parseInt(metadata[3]);
        String country = metadata[4];
        Boolean isHeadQuarter;
        if(metadata.length==5)
        {
            isHeadQuarter=false;
        }
        else
        {
            isHeadQuarter= Boolean.parseBoolean(metadata[5]);
        }



        return  new Company(id,name,foundationDate,capital,country,isHeadQuarter);


    }
}
