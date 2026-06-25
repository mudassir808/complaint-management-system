package com.mudassir.cms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.entity.User;
import com.mudassir.cms.enums.ComplaintStatus;
import com.mudassir.cms.repository.UserRepository;
import com.mudassir.cms.service.ComplaintService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final ComplaintService complaintService;
    private final UserRepository userRepository;

    public EmployeeController(
            ComplaintService complaintService,
            UserRepository userRepository) {

        this.complaintService = complaintService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{employeeId}/complaints")
    public List<Complaint> getEmployeeComplaints(
            @PathVariable Long employeeId) {

        User employee = userRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found"));

        return complaintService
                .getComplaintsByEmployee(employee);
    }

    @PutMapping("/{complaintId}")
    public Complaint updateStatus(
            @PathVariable Long complaintId,
            @RequestParam ComplaintStatus status,
            @RequestParam String remarks) {

        return complaintService
                .updateComplaintStatus(
                        complaintId,
                        status,
                        remarks);
    }
}