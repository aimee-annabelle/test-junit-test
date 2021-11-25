package com.example.employee.repository;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findAll() {
        List<Employee> employees = employeeRepository.findAll();
        assertTrue(employees.size()==1);
    }

    @Test
    public void deleteById() {
        employeeRepository.deleteById(200);
        assertThat(employeeRepository.count()).isEqualTo(0);
    }

    @Test
    public void save(){
        employeeRepository.save(new Employee(12,"Ernest","Tzarina","0785566432",34.6f,"Male",new Date(2004-05-07)));
        assertThat(employeeRepository.count()).isEqualTo(2);
    }

    @Test
    public void finById(){
        Optional<Employee> employee = employeeRepository.findById(200);
        assertTrue(employee.get().getId()==200);
    }

    @Test
    public void update(){
        employeeRepository.save(new Employee(200,"Waze","Common","0785566432",34.6f,"Male",new Date(2004-05-07)));
        assertThat(employeeRepository.count()).isEqualTo(1);
    }
}
