package com.libraryManagementSystem.Staff.Service;

import com.libraryManagementSystem.Staff.Model.Staff;
import com.libraryManagementSystem.Staff.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff createStaff(Staff staff){
        return staffRepository.save(staff);
    }

    public Staff editStaffDetails(Staff staff){return staffRepository.save(staff);}

    public Staff deleteStaff(Integer id){
        Optional<Staff> staff = staffRepository.findById(id);

        if(staff.isPresent()) {
            staffRepository.deleteById(id);
            return staff.get();
        }
        return null;

    }

    public Staff findStaffById(Integer id){
        Optional<Staff> staff = staffRepository.findById(id);

        if(staff.isPresent()) {
            return staff.get();
        }
        return null;
    }

    public List<Staff> fetchAllStaffs(){
        List<Staff> staffs = staffRepository.findAll();

        if(staffs.isEmpty()){
            return null;
        }
        return  staffs;
    }
}
