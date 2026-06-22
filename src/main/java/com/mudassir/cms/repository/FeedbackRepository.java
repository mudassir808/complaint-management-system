package com.mudassir.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudassir.cms.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}