package com.mudassir.cms.service;

import java.util.List;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.entity.User;
import com.mudassir.cms.enums.ComplaintStatus;

public interface ComplaintService {

    Complaint addComplaint(Complaint complaint);
    
    Complaint getComplaintById(Long complaintId);
    List<Complaint> getAllComplaints();

    Complaint updateComplaint(Long complaintId, Complaint complaint);

    void deleteComplaint(Long complaintId);
    
    List<Complaint> getComplaintsByEmployee(User employee);

    Complaint updateComplaintStatus(
            Long complaintId,
            ComplaintStatus status,
            String remarks);
}

