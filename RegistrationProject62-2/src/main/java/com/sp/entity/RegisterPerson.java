package com.sp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "register_data")
public class RegisterPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;

	@Column(name = "person_name", nullable = false, length = 100)
	@NotBlank(message = "Name cannot be empty")
	private String personName;

	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Transient // Not stored in DB, calculated based on DOB
	private int personAge;

	@Column(name = "gender", length = 10, nullable = false)
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
	private String personGender;

	@Column(name = "phone_number", nullable = false, length = 15, unique = true)
	@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
	private String personPhoneNo;

	@Column(name = "address", nullable = false, length = 255)
	private String personAddress;

	// Calculate age from DOB
	public int getPersonAge() {
		return (dob != null) ? LocalDate.now().getYear() - dob.getYear() : 0;
	}

	
}
