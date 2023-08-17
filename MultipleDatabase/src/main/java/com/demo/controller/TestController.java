package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.primary.Employee;
import com.demo.primary.EmployeeRepository;
import com.demo.secondary.Manager;
import com.demo.secondary.ManagerRepository;
import com.demo.student.Student;
import com.demo.student.StudentRepository;


@RestController
public class TestController {

	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@RequestMapping(value="/primary", method=RequestMethod.GET)
	public List<Employee> getPrimaryDatabaseData() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/secondary", method=RequestMethod.GET)
	public List<Manager> getSecondaryDatabaseData() {
		List<Manager> list = managerRepository.findAll();
		return list;
	}
	
	@GetMapping(value="/student")
	public List<Student> getStudentData(){
		List<Student> list = studentRepository.findAll();
		return list;
	}
	
	
	
	
	@RequestMapping(value="/addemployee",method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee empResponse  = employeeRepository.save(employee);
		return empResponse;	
	}
	
	@PostMapping(value="/addmanager")
	public Manager addManager(@RequestBody Manager manager) {
		Manager managerResponse = managerRepository.save(manager);
		return managerResponse;
	}
	
	@PostMapping(value="/addStudent")
	public Student addStudent(@RequestBody Student student) {
		Student studentResponse = studentRepository.save(student);
		  return studentResponse;
	}
}
