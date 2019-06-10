package com.ejserver.apps.ej.service;

import java.util.List;

import com.ejserver.apps.ej.bean.Customer;


public interface ICustomerService {

    List<Customer> findAll();
}