package pl.medos.employee.service;


import pl.medos.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee>getEmployees();
    List<Employee>getEmployeeByname(String name);

}
