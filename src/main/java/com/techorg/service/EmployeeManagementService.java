package com.techorg.service;

import com.techorg.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeManagementService {

    List<EmployeeDTO> getAllEmployees();

    void updateEmployeeById(Integer employeeId, Integer departmentId) throws Exception;

}
