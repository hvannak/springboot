package com.myboot.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myboot.springboot.model.Employee;
import com.myboot.springboot.service.EmployeeService;

@RestController
//@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	@Value("${app.name}")
	private String appName;
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetail() {
		return appName + "-" + appVersion;
	}
	
	//localhost:8080/employee
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		return eService.getEmployee();
	}
	
	//localhost:8080/employee/12
	@GetMapping("/employee/{id}")
	public String getEmployeeById(@PathVariable("id") Long id) {
		return "This is employee id:" + id;
	}
	
	@PostMapping("/employee")
	public String postEmployee(@RequestBody Employee employee) {
		return "This is post employee" + employee;
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		System.out.print("This is put employee" + id);
		return employee;
	}
	
	//localhost:8080/employee?id=34
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam Long id) {
		return "This is delete employee param:" + id;
	}
}
