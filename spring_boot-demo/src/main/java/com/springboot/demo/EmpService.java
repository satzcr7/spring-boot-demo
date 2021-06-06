package com.springboot.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired 
	private EmpRepository empRepository;

	public String getEmpName(int id) {
		if( empRepository.findById(id).isPresent()) {
			return empRepository.findById(id).get().getName();
		} else {
			return "Employee Record is not Present";
		}
	}
	 
	public void addEmp(EmpModel emp) {
		empRepository.save(emp);
	}
	
	public void updateEmp(int id,EmpModel emp) {
		empRepository.save(emp);
	}
	
	public List<EmpModel> getAllEmp() {
		ArrayList<EmpModel> allEmp = new ArrayList<EmpModel>();
		empRepository.findAll().forEach(allEmp::add);
		return allEmp;
	}
	
	public void deleteEmp(int id) {
		empRepository.deleteById(id);
	}

	
}
