package com.techorg.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeManagementTransactionService {

    int updateEmployeeById(Integer employeeId, Integer departmentId);
}
