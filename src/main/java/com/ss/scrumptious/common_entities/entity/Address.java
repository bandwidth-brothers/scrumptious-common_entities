package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
    private Long id;

	@NotBlank
	@Column(name="line1")
	private String line1;

	@Nullable
	@Column(name="line2")
	private String line2;

	@NotBlank
	private String city;

	@NotBlank(message = "State is mandatory")
	@Size(min = 2, max = 2, message = "State must consist of only 2 characters.")
	private String state;

	@NotBlank
	private String zip;
}
