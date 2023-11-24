package com.inc.excelexport.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inc.excelexport.dto.Emp;

@Repository
public interface Emp_Repo extends JpaRepository<Emp, Integer> {

}
