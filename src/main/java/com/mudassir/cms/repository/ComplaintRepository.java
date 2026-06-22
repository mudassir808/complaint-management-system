package com.mudassir.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudassir.cms.entity.Complaint;
import com.mudassir.cms.enums.ComplaintStatus;
import com.mudassir.cms.entity.User;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByCustomer(User customer);

    List<Complaint> findByAssignedEmployee(User employee);

    List<Complaint> findByStatus(ComplaintStatus status);

}