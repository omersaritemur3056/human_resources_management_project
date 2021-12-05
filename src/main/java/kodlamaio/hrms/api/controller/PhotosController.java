package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.JobSeeker;
import kodlamaio.hrms.entities.entities.Photo;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/photos")
public class PhotosController {

	private PhotoService photoService;

	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Photo>> getAll(){
		return this.photoService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Photo photo, MultipartFile multipartFile) {
		return this.photoService.add(photo, multipartFile);
	}
	
	
	
}
