package com.mudassir.cms.service;

import java.util.List;

import com.mudassir.cms.entity.Complaint;

public interface ComplaintService {

    Complaint addComplaint(Complaint complaint);
    
    Complaint getComplaintById(Long complaintId);
    List<Complaint> getAllComplaints();

    Complaint updateComplaint(Long complaintId, Complaint complaint);

    void deleteComplaint(Long complaintId);
}