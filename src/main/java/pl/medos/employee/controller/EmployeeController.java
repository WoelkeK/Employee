package pl.medos.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import pl.medos.employee.model.Employee;
import pl.medos.employee.service.EmployeeService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getListOfEmployees(Model model) {

        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "list-info";
    }
}
