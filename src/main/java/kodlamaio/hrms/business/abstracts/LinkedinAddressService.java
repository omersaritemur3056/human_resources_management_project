package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.LinkedinAddress;

public interface LinkedinAddressService {

	DataResult<List<LinkedinAddress>> getAll();
	Result add(LinkedinAddress linkedinAddress);
	
	
}
