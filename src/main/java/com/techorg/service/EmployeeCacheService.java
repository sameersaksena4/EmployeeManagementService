package com.techorg.service;

import com.techorg.dao.EmployeeDao;
import com.techorg.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class EmployeeCacheService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeCacheService(RedisTemplate<String, Object> redisTemplate, EmployeeDao employeeDao) {
        this.redisTemplate = redisTemplate;
        this.employeeDao = employeeDao;
    }

    public EmployeeDTO getEmployee(Integer employeeId) throws Exception {
        String key = "employee:" + employeeId;

        // Try Redis first
        EmployeeDTO employeeDTO = (EmployeeDTO) redisTemplate.opsForValue().get(key);
        if (employeeDTO != null) {
            return employeeDTO;
        }
        // Fallback to DB
        employeeDTO = employeeDao.getEmployeeById(employeeId);
        // Store in Redis
        if (employeeDTO != null) {
            redisTemplate.opsForValue().set(key, employeeDTO, Duration.ofMinutes(10));
        }
        return employeeDTO;
    }
}
