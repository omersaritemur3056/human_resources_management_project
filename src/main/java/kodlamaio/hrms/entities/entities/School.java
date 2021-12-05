package kodlamaio.hrms.entities.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "education_degree") 
	private String educationDegree;         //lise, üniversite derecesi falan demeye çalıştım... :)
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "education_start_date")
	private LocalDate educationStartDate;
	
	@Column(name = "is_graduate")
	private boolean isGraduate;
	
	@Column(name = "graduate_date")
	private LocalDate graduateDate;
	
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
