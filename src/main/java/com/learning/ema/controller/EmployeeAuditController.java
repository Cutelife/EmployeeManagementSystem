package com.learning.ema.controller;

import com.learning.ema.service.EmployeeAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees/audit")
public class EmployeeAuditController {
    @Autowired
    private EmployeeAuditService auditService;

    @GetMapping("/{id}")
    public List<?> getAuditHistory(@PathVariable Long id) {
        return auditService.getEmployeeRevisions(id);
    }
}
