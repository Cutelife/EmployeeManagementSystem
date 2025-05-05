package com.learning.ema.service.impl;

import com.learning.ema.dto.EmployeeDto;
import com.learning.ema.mapper.EmployeeMapper;
import com.learning.ema.model.Employee;
import com.learning.ema.repository.EmployeeRepository;
import com.learning.ema.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee((employeeDto));
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
