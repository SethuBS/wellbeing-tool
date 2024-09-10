package com.dashboard.wellbeingtool;

import com.dashboard.wellbeingtool.controllers.EmployeeController;
import com.dashboard.wellbeingtool.dtos.EmployeeDTO;
import com.dashboard.wellbeingtool.exceptions.EmployeeFoundException;
import com.dashboard.wellbeingtool.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private EmployeeDTO employee1;
    private EmployeeDTO employee2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create dummy employees
        employee1 = EmployeeDTO.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .department("HR")
                .role("Manager")
                .build();

        employee2 = EmployeeDTO.builder()
                .id(2L)
                .name("Jane Smith")
                .email("jane.smith@example.com")
                .department("IT")
                .role("Developer")
                .build();
    }

    @Test
    public void testGetAllEmployees() {
        // Mocking the service method
        List<EmployeeDTO> employees = Arrays.asList(employee1, employee2);
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // Call the method
        ResponseEntity<List<EmployeeDTO>> response = employeeController.getAllEmployees();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());

        // Verify that service method was called
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void testSaveEmployee() throws EmployeeFoundException {
        // Mock the service method
        when(employeeService.saveEmployee(employee1)).thenReturn(employee1);

        // Call the method
        ResponseEntity<EmployeeDTO> response = employeeController.saveEmployee(employee1);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody().getName());
        assertEquals("john.doe@example.com", response.getBody().getEmail());

        // Verify that the service method was called
        verify(employeeService, times(1)).saveEmployee(employee1);
    }

    @Test
    public void testSaveEmployeeThrowsException() throws EmployeeFoundException {
        // Mock the service method to throw an exception
        when(employeeService.saveEmployee(employee1)).thenThrow(new EmployeeFoundException("Employee already exists"));

        // Assertions for exception handling
        assertThrows(EmployeeFoundException.class, () -> {
            employeeController.saveEmployee(employee1);
        });

        // Verify that the service method was called
        verify(employeeService, times(1)).saveEmployee(employee1);
    }

    @Test
    public void testGetEmployeeById() throws EmployeeFoundException {
        // Mock the service method
        when(employeeService.getEmployeeById(1L)).thenReturn(employee1);

        // Call the method
        ResponseEntity<EmployeeDTO> response = employeeController.getEmployeeById(1L);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody().getName());

        // Verify that the service method was called
        verify(employeeService, times(1)).getEmployeeById(1L);
    }

    @Test
    public void testGetEmployeeByIdThrowsException() throws EmployeeFoundException {
        // Mock the service method to throw an exception
        when(employeeService.getEmployeeById(1L)).thenThrow(new EmployeeFoundException("Employee not found"));

        // Assertions for exception handling
        assertThrows(EmployeeFoundException.class, () -> {
            employeeController.getEmployeeById(1L);
        });

        // Verify that the service method was called
        verify(employeeService, times(1)).getEmployeeById(1L);
    }
}
