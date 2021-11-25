package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getAllEmployee_success() throws Exception {
        when(employeeService.getAll())
                .thenReturn(Arrays.asList(new Employee(10,"Anna","Belle","0783456723", 400.5f,"female",new Date(2009-03-06))));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/employee")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("[{\"fistName\":\"Anna\",\"lastName\":\"Belle\",\"phone\":\"0783456723\",\"salary\":400.5,\"gender\":\"female\",\"birthdate\":\"1970-01-01T00:00:02.000+00:00\",\"id\":10}]"))
                .andReturn();
    }

    @Test
    public void getEmployeeById_success() throws Exception {
        when(employeeService.getById(1))
                .thenReturn(new Employee(1,"Anna","Belle","0783456723", 300.4f,"female",new Date(2009-03-06)));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/employee/1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("{\"fistName\":\"Anna\",\"lastName\":\"Belle\",\"phone\":\"0783456723\",\"salary\":300.4,\"gender\":\"female\",\"birthdate\":\"1970-01-01T00:00:02.000+00:00\",\"id\":1}"))
                .andReturn();

    }

    @Test
    public void getEmployeeById_failure() throws Exception {
        when(employeeService.getById(1))
                .thenReturn(null);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/employee/1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addEmployee_success() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(12,"Ernest","Tzarina","0785566432",34.6f,"Male",new Date(2004-05-07));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeDTO));

        mockMvc.perform(requestBuilder).andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void updateEmployee_success() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(2,"Ernest","Tzarina","0785566432",34.6f,"Male",new Date(2004-05-07));
        when(employeeService.updateEmployee(employeeDTO))
                .thenReturn(new Employee(2,"Ernest","Tzarina","0785566432",34.6f,"Male",new Date(2004-05-07)));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/employee/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeDTO));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void updateEmployee_failure() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(1,"Ernest","Tzarina","0785566432",34.6f,"Male",new Date(2004-05-07));

        when(employeeService.updateEmployee(employeeDTO))
                .thenReturn(null);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/employee/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeDTO));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andReturn();
    }

   @Test
   public void removeEmployee_success(){

   }
    }

