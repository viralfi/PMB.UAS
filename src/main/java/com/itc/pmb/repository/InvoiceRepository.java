package com.itc.pmb.repository;

import com.itc.pmb.domain.Invoice;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>, ListCrudRepository<Invoice, Long> {
}
