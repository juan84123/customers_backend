package com.localhost.customersAPI.daos;

import com.localhost.customersAPI.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO personal_data (first_name, last_name, document_number, document_type) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getDocumentNumber(),
                customer.getDocumentType());
    }
}
