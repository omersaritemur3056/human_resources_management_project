package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

	//List<Photo> findAllByResume_Id(int resumeId);  şimdilik kalsın...
}
