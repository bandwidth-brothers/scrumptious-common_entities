package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADMIN")
@Builder
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BINARY(16)", name = "id", updatable = false)
	private UUID id;


	@NotBlank
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotBlank
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotBlank
	@Column(name = "phone", nullable = false)
	private String phone;

	@NotBlank
	@Column(name = "email", nullable = false)
	private String email;

}
