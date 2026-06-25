package com.mudassir.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.entity.User;
import com.mudassir.cms.enums.ComplaintStatus;
import com.mudassir.cms.repository.UserRepository;
import com.mudassir.cms.service.ComplaintService;

@Controller
public class EmployeeViewController {

    private final ComplaintService complaintService;
    private final UserRepository userRepository;

    public EmployeeViewController(
            ComplaintService complaintService,
            UserRepository userRepository) {

        this.complaintService = complaintService;
        this.userRepository = userRepository;
    }

    @GetMapping("/my-complaints/{employeeId}")
    public String myComplaints(
            @PathVariable Long employeeId,
            Model model) {

        User employee = userRepository
                .findById(employeeId)
                .orElseThrow();

        model.addAttribute(
                "complaints",
                complaintService
                        .getComplaintsByEmployee(employee));

        return "employee-complaints";
    }

    @GetMapping("/update-status/{complaintId}")
    public String showUpdatePage(
            @PathVariable Long complaintId,
            Model model) {

        Complaint complaint =
                complaintService
                        .getComplaintById(complaintId);

        model.addAttribute(
                "complaint",
                complaint);

        model.addAttribute(
                "statuses",
                ComplaintStatus.values());

        return "update-status";
    }

    @PostMapping("/update-status")
    public String updateComplaintStatus(

            @RequestParam Long complaintId,

            @RequestParam ComplaintStatus status,

            @RequestParam String remarks) {

        complaintService.updateComplaintStatus(
                complaintId,
                status,
                remarks);

        return "redirect:/dashboard";
    }
}