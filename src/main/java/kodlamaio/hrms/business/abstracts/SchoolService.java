package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.School;

public interface SchoolService {

	DataResult<List<School>> getAll();
	Result add(School school);
	
	DataResult<List<School>> findAllByResume_IdOrderByGraduateDate(int resumeId);
	
	DataResult<List<School>> findAllByResume_IdOrderByGraduateDateDesc(int resumeId, Direction direction);
}
