package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.HumanResourcer;

public interface HumanResourcerService {

	DataResult<List<HumanResourcer>> getAll();
	Result add(HumanResourcer humanResourcer);
}
