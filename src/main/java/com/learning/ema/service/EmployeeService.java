package com.learning.ema.service;

import com.learning.ema.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    //EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);



}
