package com.mudassir.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.service.ComplaintService;

@Controller
public class ComplaintViewController {

    private final ComplaintService complaintService;

    public ComplaintViewController(
            ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/view-complaints")
    public String viewComplaints(Model model) {

        model.addAttribute(
                "complaints",
                complaintService.getAllComplaints());

        return "complaints";
    }
    
    @GetMapping("/add-complaint")
    public String showAddComplaintPage(
            Model model) {

        model.addAttribute(
                "complaint",
                new Complaint());

        return "add-complaint";
    }
    
    @PostMapping("/save-complaint")
    public String saveComplaint(
            @ModelAttribute Complaint complaint) {

        complaintService.addComplaint(complaint);

        return "redirect:/view-complaints";
    }
    
    @GetMapping("/edit-complaint/{id}")
    public String showEditComplaintPage(
            @PathVariable Long id,
            Model model) {

        Complaint complaint =
                complaintService.getComplaintById(id);

        model.addAttribute("complaint", complaint);

        return "edit-complaint";
    }
    
    @PostMapping("/update-complaint")
    public String updateComplaint(
            @ModelAttribute Complaint complaint) {

        complaintService.updateComplaint(
                complaint.getComplaintId(),
                complaint);

        return "redirect:/view-complaints";
    }
    
    @GetMapping("/delete-complaint/{id}")
    public String deleteComplaint(
            @PathVariable Long id) {

        complaintService.deleteComplaint(id);

        return "redirect:/view-complaints";
    }
}