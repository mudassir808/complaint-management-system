package com.mudassir.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint addComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint getComplaintById(Long complaintId) {
        return complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    @Override
    public Complaint updateComplaint(Long complaintId, Complaint complaint) {

        Complaint existingComplaint = getComplaintById(complaintId);

        existingComplaint.setTitle(complaint.getTitle());
        existingComplaint.setDescription(complaint.getDescription());
        existingComplaint.setStatus(complaint.getStatus());
        existingComplaint.setRemarks(complaint.getRemarks());

        return complaintRepository.save(existingComplaint);
    }

    @Override
    public void deleteComplaint(Long complaintId) {

        Complaint complaint = getComplaintById(complaintId);

        complaintRepository.delete(complaint);
    }
}

