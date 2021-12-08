package kodlamaio.hrms.entities.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_id")
	private int id;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	
//	@JsonIgnore
//	@NotNull // bu anotasyon nedense one to one kısmında çalışmasında etkili oldu.
//	@OneToOne
//	@JoinColumn(name = "job_seeker_id")
//	private JobSeeker jobSeeker;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<School> schools;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobExperince> jobExperinces;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Photo> photos;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<GithubAddress> githubAddresses;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<LinkedinAddress> linkedinAddresses;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Skill> skills;
}
