package com.tanphat.elca.service;

import com.tanphat.elca.entity.Company;

@FunctionalInterface
public interface LineProcessor {
    public  void process(Company company);
}
