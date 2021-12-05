package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.Skill;

public interface SkillService {

	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
	
	
}
