package com.ravi.spring_boot_101.rest;

import com.ravi.spring_boot_101.entity.Employee;
import com.ravi.spring_boot_101.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.zip.GZIPInputStream;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper){
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> fetchAllStudents(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable long employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PostMapping("/test")
    public String checkCompressedFlow(HttpServletRequest request) {
        try {
            String contentEncoding = request.getHeader("Content-Encoding");

            String jsonString;
            if (contentEncoding != null && contentEncoding.toLowerCase().contains("gzip")) {
                // Read raw bytes from request input stream
                try (GZIPInputStream gzipInputStream = new GZIPInputStream(request.getInputStream());
                     BufferedReader reader = new BufferedReader(new InputStreamReader(gzipInputStream, "UTF-8"))) {

                    StringBuilder out = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        out.append(line);
                    }
                    jsonString = out.toString();
                } catch (Exception ex) {
                    System.out.println("Error decompressing gzip body: " + ex.getMessage());
                    throw ex;
                }
            } else {
                // Read regular body
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))) {
                    StringBuilder out = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        out.append(line);
                    }
                    jsonString = out.toString();
                }
            }

            System.out.println("Decompressed Body: " + jsonString);
            Map<String, Object> map = objectMapper.readValue(jsonString, Map.class);
            System.out.println("Map: " + map);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
        return "Success!!!";
    }
}