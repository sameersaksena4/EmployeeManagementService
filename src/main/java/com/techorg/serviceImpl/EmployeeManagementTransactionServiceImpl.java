package com.techorg.serviceImpl;

import com.techorg.dao.EmployeeDao;
import com.techorg.service.EmployeeManagementTransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagementTransactionServiceImpl implements EmployeeManagementTransactionService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public int updateEmployeeById(Integer employeeId, Integer departmentId) {
        return employeeDao.updateEmployeeById(employeeId, departmentId);
    }
}
