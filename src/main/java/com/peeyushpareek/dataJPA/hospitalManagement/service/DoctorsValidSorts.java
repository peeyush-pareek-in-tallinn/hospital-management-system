package com.peeyushpareek.dataJPA.hospitalManagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class DoctorsValidSorts {

    private static final Logger log = LoggerFactory.getLogger(DoctorsValidSorts.class);

    private static final List<String> ALLOWED_SORT_FIELDS = List.of(
            "id",
            "name",
            "specialization",
            "experience",
            "department"
    );

    public static Sort validateSort(Sort sort) {

        List<Sort.Order> validOrders = new ArrayList<>();

        for (Sort.Order order : sort) {
            if(ALLOWED_SORT_FIELDS.contains(order.getProperty())) {
                validOrders.add(order);
            } else {
                log.warn("Invalid sort field: {}", order.getProperty());
            }
        }
        if (validOrders.isEmpty()){
            return Sort.by("id").ascending();
        }

        return Sort.by(validOrders);
    }
}
