package kodlamaio.hrms.entities.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="job_seeker_id", referencedColumnName = "id")

public class JobSeeker extends User {
	
	@NotBlank
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@NotNull
	@Size(min = 11, max = 11)
	@Column(name="nationality_id")
	private String nationalityId;
	
	@NotBlank
	@NotNull
	@Size(min = 4, max = 4)
	@Column(name="birth_of_year")
	private String birthOfYear;
	

//	@OneToMany(mappedBy = "jobSeeker")
//	private List<Resume> resumes;
}
