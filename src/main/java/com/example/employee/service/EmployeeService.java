package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getById(int Id){
        Optional<Employee> employee = employeeRepository.findById(Id);
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }

    public boolean employeeExists(int Id){
        Optional<Employee> employee = employeeRepository.findById(Id);
        if(employee.isPresent()){
            return true;
        }
        return false;
    }

    public Employee save(EmployeeDTO employeeDTO){
        Employee employee = new Employee();

        employee.setBirthdate(employeeDTO.getBirthdate());
        employee.setFistName(employeeDTO.getFistName());
        employee.setGender(employeeDTO.getGender());
        employee.setId(employeeDTO.getId());
        employee.setPhone(employeeDTO.getPhone());
        employee.setSalary(employeeDTO.getSalary());
        employee.setLastName(employeeDTO.getLastName());

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO){
        Optional<Employee> employeeFromDb = employeeRepository.findById(employeeDTO.getId());
        if(employeeFromDb.isPresent()){
            Employee employee = employeeFromDb.get();

            employee.setPhone(employeeDTO.getPhone());
            employee.setBirthdate(employeeDTO.getBirthdate());
            employee.setFistName(employeeDTO.getFistName());
            employee.setGender(employeeDTO.getGender());
            employee.setSalary(employeeDTO.getSalary());
            employee.setLastName(employeeDTO.getLastName());

            return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean deleteEmployee(int Id){
        if(employeeExists(Id)){
            employeeRepository.deleteById(Id);
            return  true;
        }
        return false;
    }
}
