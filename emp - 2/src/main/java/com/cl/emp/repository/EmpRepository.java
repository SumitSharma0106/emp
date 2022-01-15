package com.cl.emp.repository;

import com.cl.emp.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Long> {

    public Emp findByEmpId(Long audId);

    @Query(nativeQuery = true,value = "SELECT MAX(EMP_ID) FROM Emp")
    public Long findMaxEmpId();
}
