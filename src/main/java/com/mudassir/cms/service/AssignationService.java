package com.mudassir.cms.service;

import java.util.List;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.entity.User;

public interface AssignationService {

    List<User> getAvailableEmployees();

    Complaint assignComplaint(
            Long complaintId,
            Long employeeId);
}