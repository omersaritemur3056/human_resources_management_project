package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;


@Component
public class CloudManager implements CloudService {

	private final Cloudinary cloudinary;

	
	public CloudManager() {  //Parametresiz constructor olduğuna dikkat et
		
		
		Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","dsfebmcdy" );
        valuesMap.put("api_key", "889147229764614" );
        valuesMap.put("api_secret","EP8_6KWo4PJYnZUoPKDZvfqjf7M" );
        cloudinary = new Cloudinary(valuesMap);
        
	}

	
	
	@Override
	public DataResult<Map<String, String>> uploadPhoto(MultipartFile multipartFile) {
		
		File file;
		
		try {
			file = convert(multipartFile);
			
			
			@SuppressWarnings("unchecked")
			Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			
			return new SuccessDataResult<>(result);
		} catch (IOException e) {
			
			e.printStackTrace();
			
			return new ErrorDataResult<>("File can't upload"); //error sonucunu cathch bloğuna çektik yukarıda zaten return olduğundan kızmadı.
		}
		
		
		
	}
	
	
	
	private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
