package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

	Job findByTitles(String titles);
}
