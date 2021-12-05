package kodlamaio.hrms.entities.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisments"})
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private int id;
	
	@Column(name="titles", unique = true)
	private String titles;
	
	

	@JsonIgnore
	@OneToMany(mappedBy = "job", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobAdvertisment> jobAdvertisments;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<JobExperince> jobExperinces;
}
