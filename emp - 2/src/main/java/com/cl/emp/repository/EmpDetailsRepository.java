package com.cl.emp.repository;

import com.cl.emp.model.EmpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDetailsRepository extends JpaRepository<EmpDetails,Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM Emp_Details where emp_Id= ?")
    public EmpDetails findByEmpId(@Param("empId") Long empId);
}
