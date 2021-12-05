package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.GithubAddress;

public interface GithubAddressService {

	DataResult<List<GithubAddress>> getAll();
	Result add(GithubAddress githubAddress);
	
	
}
