package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
