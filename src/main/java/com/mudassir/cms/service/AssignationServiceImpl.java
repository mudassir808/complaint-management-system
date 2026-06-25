package com.mudassir.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.entity.User;
import com.mudassir.cms.enums.ComplaintStatus;
import com.mudassir.cms.enums.Role;
import com.mudassir.cms.repository.ComplaintRepository;
import com.mudassir.cms.repository.UserRepository;

@Service
public class AssignationServiceImpl
        implements AssignationService {

    private final UserRepository userRepository;
    private final ComplaintRepository complaintRepository;

    public AssignationServiceImpl(
            UserRepository userRepository,
            ComplaintRepository complaintRepository) {

        this.userRepository = userRepository;
        this.complaintRepository = complaintRepository;
    }

    @Override
    public List<User> getAvailableEmployees() {

        return userRepository.findByRole(Role.EMPLOYEE);
    }

    @Override
    public Complaint assignComplaint(
            Long complaintId,
            Long employeeId) {

        Complaint complaint =
                complaintRepository.findById(complaintId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Complaint not found"));

        User employee =
                userRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found"));

        complaint.setAssignedEmployee(employee);

        complaint.setStatus(
                ComplaintStatus.ASSIGNED);

        return complaintRepository.save(complaint);
    }
}