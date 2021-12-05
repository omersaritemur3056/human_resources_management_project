package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.Resume;

public interface ResumeService {

	DataResult<List<Resume>> getAll();
	
	Result add(Resume resume);
	
	DataResult<List<Resume>> getById(int id);
}
