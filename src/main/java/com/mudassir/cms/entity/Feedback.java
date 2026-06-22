package com.mudassir.cms.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;
	
	private Integer rating;
	private String comments;
	
	@OneToOne
	@JoinColumn(name = "complaint_id")
	private Complaint complaint;
}
