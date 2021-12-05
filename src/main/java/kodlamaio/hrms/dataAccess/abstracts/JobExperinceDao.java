package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.JobExperince;

public interface JobExperinceDao extends JpaRepository<JobExperince, Integer> {
	
	List<JobExperince> findAllByResume_IdOrderByDateOfEnd(int resumeId);
	
	List<JobExperince> findAllByResume_IdOrderByDateOfEndDesc(int resumeId);
}
