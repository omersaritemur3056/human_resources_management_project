package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.Language;

public interface LanguageService {

	DataResult<List<Language>> getAll();
	Result add(Language language);
	
	
}
