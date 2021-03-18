package com.tanphat.elca.service;

import com.tanphat.elca.entity.Company;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

abstract public class DataParser {
   public abstract  List<Company> readData(Path filePath);
    public  void totalCapitalOfHeaderQuarterLocatedIn(List<Company> companies, String location){

       System.out.println( companies.stream().filter(i->i.getCountry().equals(location)).mapToInt(i->i.getCapital()).sum());

    }
    public  void getNameOfCompaniesByCountry(List<Company> companies,String location){
        companies.stream().filter(i->i.getCountry().equals(location)).sorted((a,b)->b.getCapital().compareTo(a.getCapital())).map(i->i.getName()).collect(Collectors.toList()).forEach(System.out::println);
    }
}
