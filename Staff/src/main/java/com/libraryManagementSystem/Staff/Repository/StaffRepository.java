package com.libraryManagementSystem.Staff.Repository;

import com.libraryManagementSystem.Staff.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
