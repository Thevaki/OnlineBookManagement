package com.libraryManagementSystem.Staff.Controller;

import com.libraryManagementSystem.Staff.Model.Staff;
import com.libraryManagementSystem.Staff.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/Staff")
@XmlRootElement
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "/createStaff" , method = RequestMethod.POST)
    public Staff createStaff(@RequestBody Staff staff){
        return staffService.createStaff(staff);
    }

    @RequestMapping(value = "/editStaff",method = RequestMethod.PUT)
    public Staff editStaff(@RequestBody Staff staff){return staffService.editStaffDetails(staff);}

    @RequestMapping(value = "/deleteStaff/{id}",method = RequestMethod.DELETE)
    public Staff deleteStaff(@PathVariable("id") Integer id){return staffService.deleteStaff(id);}

    @RequestMapping(value="/findStaff/{id}",method = RequestMethod.GET)
    public Staff findStaff(@PathVariable("id") Integer id){
        return staffService.findStaffById(id);
    }

    @RequestMapping(value="/fetchAllStaffs",method = RequestMethod.GET)
    public List<Staff> fetchAllStaffs(){
        return staffService.fetchAllStaffs();
    }

}
