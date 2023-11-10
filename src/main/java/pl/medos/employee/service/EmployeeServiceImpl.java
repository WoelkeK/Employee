package pl.medos.employee.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.medos.employee.controller.EmployeeController;
import pl.medos.employee.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());

    @Value("${external.server.url}")
    String externalServerURL;
    public List<Employee> getEmployees() {
        LOGGER.info("getEmployeesApi");
        String employeesUri = externalServerURL+"/employees";
        RestTemplate restTemplate = new RestTemplate();
        Employee[] employees = restTemplate.getForObject(employeesUri, Employee[].class);
        return Arrays.asList(employees);
    }

}
