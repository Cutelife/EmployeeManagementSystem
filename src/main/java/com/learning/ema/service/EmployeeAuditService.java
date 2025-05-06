package com.learning.ema.service;

import com.learning.ema.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeAuditService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<?> getEmployeeRevisions(Long employeeId) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        return auditReader.createQuery()
                .forRevisionsOfEntity(Employee.class, false, true)
                .add(AuditEntity.id().eq(employeeId))
                .getResultList();
    }
}
