package kodlamaio.hrms.core.utilities.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.JobSeeker;

public interface MernisCheckService {

	Result checkIfRealPerson(JobSeeker jobSeeker) throws Exception;
}
