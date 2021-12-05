package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.entities.Skill;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/skills")
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping(value = "/getall")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	
	
	
}
