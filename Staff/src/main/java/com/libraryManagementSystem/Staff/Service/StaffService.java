package com.libraryManagementSystem.Staff.Service;

import com.libraryManagementSystem.Staff.Model.Staff;

import java.util.List;

public interface StaffService {
    Staff createStaff(Staff book);

    Staff editStaffDetails(Staff book);

    Staff deleteStaff(Integer id);

    Staff findStaffById(Integer id);

    List<Staff> fetchAllStaffs();
}
