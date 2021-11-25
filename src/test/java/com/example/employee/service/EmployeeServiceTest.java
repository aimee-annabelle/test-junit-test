package com.example.employee.service;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void getAllEmployee_withSomeElement(){
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(
                new Employee(2,"ella","kim","0785566444",348.6f,"female",new Date(2003-07-07)),
                new Employee(2,"ella","kim","0785566444",348.6f,"female",new Date(2003-07-07))));

        assertEquals(2,employeeService.getAll().size());
    }

    @Test
    public void saveEmployee_withSomeElement(){
        Employee employee = new Employee (2,"ella","kim","0785566444",348.6f,"female",new Date(2003-07-07));
        EmployeeDTO employeeDTO = new EmployeeDTO (2,"ella","kim","0785566444",348.6f,"female",new Date(2003-07-07));

        when(employeeRepository.save(employee)).thenReturn(employee);

        assertEquals(null,employeeService.save(employeeDTO));
    }

}
