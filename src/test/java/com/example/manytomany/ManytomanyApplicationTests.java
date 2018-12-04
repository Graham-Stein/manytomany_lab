package com.example.manytomany;

import com.example.manytomany.models.Department;
import com.example.manytomany.models.Employee;
import com.example.manytomany.models.Project;
import com.example.manytomany.repositories.DepartmentRepository;
import com.example.manytomany.repositories.EmployeeRepository;
import com.example.manytomany.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManytomanyApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createDepartmentandEmployee(){
		Department department = new Department("Narcos");
		departmentRepository.save(department);

		Employee employee = new Employee("Pablo","Escobar",1,department );
		employeeRepository.save(employee);
	}

	@Test
	public void createJoinTable(){
		Department department = new Department("Narcos");
		departmentRepository.save(department);

		Employee employee = new Employee("Pablo","Escobar",1,department );
		employeeRepository.save(employee);

		Project project = new Project("Coco",2);
		projectRepository.save(project);

		project.getEmployees().add(employee);
		projectRepository.save(project);

	}

}
