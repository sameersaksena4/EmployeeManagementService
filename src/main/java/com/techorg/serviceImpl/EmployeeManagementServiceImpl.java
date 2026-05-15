package com.techorg.serviceImpl;

import com.techorg.dao.EmployeeDao;
import com.techorg.dto.EmployeeDTO;
import com.techorg.service.EmployeeCacheService;
import com.techorg.service.EmployeeManagementService;
import com.techorg.service.EmployeeManagementTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeCacheService employeeCacheService;

    @Autowired
    private EmployeeManagementTransactionService employeeManagementTxnService;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public void updateEmployeeById(Integer employeeId, Integer departmentId) throws Exception {
        EmployeeDTO employeeDTO = employeeCacheService.getEmployee(employeeId);
        if(employeeDTO == null) {
            throw new Exception("Employee not found for id : " + employeeId);
        }
        int updateCount = employeeManagementTxnService.updateEmployeeById(employeeId, departmentId);
        if(updateCount == 0) {
            throw new Exception("Failed to update employee info for id : " + employeeId);
        }
    }
}
