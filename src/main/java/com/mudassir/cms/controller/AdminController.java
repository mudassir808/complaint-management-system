package com.mudassir.cms.controller;

import org.springframework.web.bind.annotation.*;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.service.AssignationService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AssignationService assignationService;

    public AdminController(
            AssignationService assignationService) {

        this.assignationService =
                assignationService;
    }

    @PutMapping(
        "/assign/{complaintId}/{employeeId}")
    public Complaint assignComplaint(
            @PathVariable Long complaintId,
            @PathVariable Long employeeId) {

        return assignationService.assignComplaint(
                complaintId,
                employeeId);
    }
}