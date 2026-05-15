package com.techorg.dao;

import com.techorg.dto.EmployeeDTO;
import com.techorg.queries.CommonSQLQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<EmployeeDTO> getAllEmployees() {
        String sqlQuery = CommonSQLQueries.GET_EMPLOYEE_LIST;
        List<Object[]> resultList = entityManager.createNativeQuery(sqlQuery).getResultList();
        return resultList.stream()
                .map(result -> {
                    EmployeeDTO dto = new EmployeeDTO();
                    dto.setEmployeeId(result[0] != null ? Integer.valueOf(result[0].toString()) : null);
                    dto.setName(result[1] != null ? result[1].toString() : "NA");
                    dto.setEmail(result[2] != null ? result[2].toString() : "NA");
                    dto.setDesignation(result[3] != null ? result[3].toString() : "NA");
                    dto.setDepartmentName(result[4] != null ? result[4].toString() : "NA");
                    return dto;
                })
                .toList();
    }

    // New method to update employee
    public int updateEmployeeById(Integer employeeId, Integer departmentId) {
        String sqlQuery = CommonSQLQueries.UPDATE_EMPLOYEE_BY_ID;
        Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, departmentId);
        query.setParameter(2, employeeId);
        return query.executeUpdate(); // returns number of rows updated
    }

    @SuppressWarnings("unchecked")
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        String sqlQuery = CommonSQLQueries.GET_EMPLOYEE_BY_ID;
        Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, employeeId);
        List<Object[]> resultList = query.getResultList();
        return resultList.stream()
                .map(result -> {
                    EmployeeDTO dto = new EmployeeDTO();
                    dto.setEmployeeId(result[0] != null ? Integer.valueOf(result[0].toString()) : null);
                    dto.setName(result[1] != null ? result[1].toString() : "NA");
                    dto.setEmail(result[2] != null ? result[2].toString() : "NA");
                    dto.setDesignation(result[3] != null ? result[3].toString() : "NA");
                    dto.setDepartmentName(result[4] != null ? result[4].toString() : "NA");
                    return dto;
                })
                .toList().get(0);
    }
}
