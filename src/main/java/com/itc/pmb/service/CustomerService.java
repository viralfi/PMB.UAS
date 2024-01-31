package com.vialfinaz.sisteminforklinik.service;

import com.vialfinaz.sisteminforklinik.domain.Invoice;
import com.vialfinaz.sisteminforklinik.domain.Stats;
import org.springframework.data.domain.Page;
import com.vialfinaz.sisteminforklinik.domain.Customer;

public interface CustomerService {
    // Customer functions
    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Page<Customer> getCustomers(int page, int size);

    Iterable<Customer> getCustomers();

    Customer getCustomer(Long id);

    Page<Customer> searchCustomers(String name, int page, int size);

    // Invoice functions
    Invoice createInvoice(Invoice invoice);

    Page<Invoice> getInvoices(int page, int size);

    void addInvoiceToCustomer(Long id, Invoice invoice);

    Invoice getInvoice(Long id);

    Stats getState();
}
