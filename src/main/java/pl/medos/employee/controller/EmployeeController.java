package pl.medos.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.medos.employee.model.Employee;
import pl.medos.employee.service.EmployeeService;

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

    @GetMapping()
    public String getListOfEmployees(Model model) {
        LOGGER.info("getAllOfEmployees");
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "list-info";
    }

    @GetMapping("/search")
    public String searchEmployeeByName(
            @RequestParam(value = "employeeName") String query,
//            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
            Model model){
        LOGGER.info("searchUriByName()");
//        int pagesize =10;

        List<Employee> employeeByName = employeeService.getEmployeeByname(query);
//        Page<Employee> employeeByName = employeeService.findEmployeeByName(pageNo, pagesize, query);
        LOGGER.info("findEmployeeByName() + " + employeeByName);
        model.addAttribute("employees", employeeByName);
//        model.addAttribute("currentPage", pageNo);
        return "list-info.html";
    }
}
