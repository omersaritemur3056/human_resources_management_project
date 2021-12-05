package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.School;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping(value = "/getallbyresumeidgraduatedate")
	public DataResult<List<School>> findAllByResume_IdOrderByGraduateDate(@RequestParam int resumeId){
		return this.schoolService.findAllByResume_IdOrderByGraduateDate(resumeId);
	}
	
	@GetMapping(value = "/getallbyresumeidgraduatedatedesc")
	public DataResult<List<School>> findAllByResume_IdOrderByGraduateDateDesc(@RequestParam int resumeId, @RequestParam Direction direction){
		return this.schoolService.findAllByResume_IdOrderByGraduateDateDesc(resumeId, direction);
	}
	
}
