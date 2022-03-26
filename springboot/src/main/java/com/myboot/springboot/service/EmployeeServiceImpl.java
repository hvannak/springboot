package com.myboot.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myboot.springboot.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static List<Employee> list = new ArrayList<>();
	
	static {
		Employee e = new Employee();
		e.setName("vannak");
		e.setAge(36L);
		e.setLocation("Kandal");
		e.setDepartment("IT");
		list.add(e);
	}

	@Override
	public List<Employee> getEmployee() {
		return list;
	}

}
