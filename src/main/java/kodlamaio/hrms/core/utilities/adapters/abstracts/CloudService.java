package kodlamaio.hrms.core.utilities.adapters.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudService {

	DataResult<Map<String, String>> uploadPhoto(MultipartFile multipartFile);
	
	//delete metotunu da bir ara öğrenip yaz
}
