package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.User;

public interface UserService { //playground için yazıldı

	DataResult<List<User>> getAll();
	Result add(User user);
}
