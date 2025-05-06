package com.learning.ema.service.impl;

import com.learning.ema.dto.EmployeeDto;
import com.learning.ema.exception.ResourceNotFoundException;
import com.learning.ema.mapper.EmployeeMapper;
import com.learning.ema.model.Employee;
import com.learning.ema.repository.EmployeeRepository;
import com.learning.ema.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee((employeeDto));
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                new ResourceNotFoundException("Employee is not exists with given id: "+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
