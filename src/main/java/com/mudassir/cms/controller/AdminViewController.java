package com.mudassir.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mudassir.cms.service.AssignationService;
import com.mudassir.cms.service.ComplaintService;

@Controller
public class AdminViewController {

    private final ComplaintService complaintService;
    private final AssignationService assignationService;

    public AdminViewController(
            ComplaintService complaintService,
            AssignationService assignationService) {

        this.complaintService = complaintService;
        this.assignationService = assignationService;
    }

    @GetMapping("/assign-complaint")
    public String showAssignPage(Model model) {

        model.addAttribute(
                "complaints",
                complaintService.getAllComplaints());

        model.addAttribute(
                "employees",
                assignationService.getAvailableEmployees());

        return "assign-complaint";
    }

    @PostMapping("/assign-complaint")
    public String assignComplaint(
            @RequestParam Long complaintId,
            @RequestParam Long employeeId) {

        assignationService.assignComplaint(
                complaintId,
                employeeId);

        return "redirect:/view-complaints";
    }
}