package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
