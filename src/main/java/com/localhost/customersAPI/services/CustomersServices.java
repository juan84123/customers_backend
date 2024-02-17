package com.localhost.customersAPI.services;

import com.localhost.customersAPI.beans.Customer;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CustomersServices {
    public Customer transformAndValidateCustomer(String jsonInput) {
        // Parse the JSON input
        JSONObject jsonObject = new JSONObject(jsonInput);

        // Create a Customer object and map values
        Customer customer = new Customer();
        customer.setFirstName(capitalizeFirstLetter(jsonObject.getString("firstName")));
        customer.setLastName(capitalizeFirstLetter(jsonObject.getString("lastName")));
        // Validate document number for symbols other than numbers
        String documentNumber = jsonObject.getString("documentNumber");
        customer.setDocumentNumber(documentNumber);

        if (!isValidDocumentNumber(documentNumber)) {
            customer.setDocumentType(2);
        } else {
            customer.setDocumentType(1);
        }

        return customer;
    }

    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    private boolean isValidDocumentNumber(String documentNumber) {
        // Validate if the document number contains only numbers
        return documentNumber.matches("\\d+");
    }
}
