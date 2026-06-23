package com.mudassir.cms.entity;

import com.mudassir.cms.enums.Role;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotBlank(message = "Name is required")
	private String name	;
	
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank
	@Size(min = 6, message = "password must contain at leas 6 charectors")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@NotBlank
	@Pattern(
			regexp = "^[0-9]{10}$", 
			message = "Phone number must contain exactly 10 digits"
	)
	private String phone;
}
