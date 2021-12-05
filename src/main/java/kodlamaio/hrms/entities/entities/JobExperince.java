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
@Table(name = "job_experinces")
public class JobExperince {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_experince_id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;        //burayı Employer ile bağlardım da oralar çok karışık...
	
	@Column(name = "job_position")
	private String jobPosition;
	
	@Column(name = "date_of_start")
	private LocalDate dateOfStart;
	
	@Column(name = "is_leave")
	private boolean isLeave;
	
	@Column(name = "date_of_end")
	private LocalDate dateOfEnd;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
