package com.springboot.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="/", produces = { "application/JSON"})
	@ResponseBody
	public List<EmpModel> getAllEmp() {
		return empService.getAllEmp();
	}
	
	@GetMapping("/{id}")
	public String helloEmp(@PathVariable int id) {
		return empService.getEmpName(id);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public EmpModel updateEmp(@RequestBody EmpModel emp,@PathVariable int id) {
		 empService.updateEmp(id,emp);
		 return emp;
	}
	
	@PostMapping("/")
	@ResponseBody
	public EmpModel addEmp(@RequestBody EmpModel emp) {
		 empService.addEmp(emp);
		 return emp;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deleteEmp(@PathVariable int id) {
		 empService.deleteEmp(id);
		 return "Deleted Emp-id " + id;
	}

}
