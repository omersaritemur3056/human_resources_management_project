package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.entities.JobSeeker;
import kodlamaio.hrms.entities.entities.Photo;
import kodlamaio.hrms.entities.entities.Resume;
import lombok.var;

@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudService cloudService;
	private ResumeService resumeService;
	

	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudService cloudService, ResumeService resumeService) {
		super();
		this.photoDao = photoDao;
		this.cloudService = cloudService;
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(), "Photos listed");
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) {
		
		var result = this.cloudService.uploadPhoto(multipartFile).getData();
		
		photo.setPhotoUrl(result.get("url"));
		
		this.photoDao.save(photo);
		return new SuccessResult("Photo added");
	}


	
}
