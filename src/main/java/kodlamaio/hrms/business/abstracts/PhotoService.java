package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.JobSeeker;
import kodlamaio.hrms.entities.entities.Photo;

public interface PhotoService {

	DataResult<List<Photo>> getAll();
	
	Result add(Photo photo,MultipartFile multipartFile);
	
	
}
