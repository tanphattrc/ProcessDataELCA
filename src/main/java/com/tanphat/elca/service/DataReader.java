package com.tanphat.elca.service;

import com.tanphat.elca.entity.Company;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

 public interface DataReader {
    public abstract List<Company> readData(Path filePath);


}
