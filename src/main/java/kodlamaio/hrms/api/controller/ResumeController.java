package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.Resume;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/resumes")
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	
	@GetMapping(value = "/getall")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	
	@GetMapping("/getById")
	public DataResult<List<Resume>> getById(@RequestParam("id") int id){
		return this.resumeService.getById(id);
	}
}
