package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import com.example.employee.utls.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int Id){
        Employee employee = employeeService.getById(Id);
        if(employee!=null){
            return ResponseEntity.ok().body(employee);
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("Employee not found", false));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeDTO employeeDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                employeeService.save(employeeDTO)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.updateEmployee(employeeDTO);
        if(employee!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("Employee not found",false));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int Id){
        boolean employeeDeleted = employeeService.deleteEmployee(Id);
        if(employeeDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Employee deleted successfully",true));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("Employee not found",false));
    }
}
