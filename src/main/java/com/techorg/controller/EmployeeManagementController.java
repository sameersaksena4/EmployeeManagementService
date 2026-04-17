package com.techorg.controller;

import com.techorg.dto.EmployeeDTO;
import com.techorg.dto.EmployeeUpdateDTO;
import com.techorg.dto.ErrorDTO;
import com.techorg.service.EmployeeManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Employee", description = "Employee management APIs")
@RequestMapping("/api/employee")  // Base URL for this controller
public class EmployeeManagementController {

    @Autowired
    private EmployeeManagementService employeeManagementService;

    @GetMapping("/details")
    @Operation(summary = "Get all employees", description = "Fetches employee details")
    public List<EmployeeDTO> getEmployeeDetails() {
        return employeeManagementService.getAllEmployees();
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "Update employee", description = "Updates employee info based on it's id")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        try {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeManagementService.updateEmployeeById(id, employeeUpdateDTO.getDepartmentId());
            return ResponseEntity.ok().body(employeeDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDTO("Failed to update employee", e.getMessage()));
        }
    }

}
