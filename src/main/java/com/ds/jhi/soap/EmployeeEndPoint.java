package com.ds.jhi.soap;


import com.sample.ds.Address;
import com.sample.ds.Employee;
import com.sample.ds.EmployeeRequest;
import com.sample.ds.EmployeeResponse;

import org.springframework.ws.server.endpoint.annotation.*;



/**
 * Created by ds on 07/22/2017.
 */
@Endpoint

public class EmployeeEndPoint {


    private static final String NAMESPACE_URI = "http://ds.sample.com";

    @PayloadRoot(namespace = "http://ds.sample.com", localPart = "employeeRequest")
    @ResponsePayload
    public EmployeeResponse employee(@RequestPayload EmployeeRequest requestType) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        System.out.println("ID: "+requestType.getId());

        //hard coding for the Sample-response. Ideally should be prepared from DB via dto
         Employee emp = new Employee();

        Address adr = new Address();
        adr.setStreet("Stadmite");
        adr.setCity("Stutgart");
        adr.setCountry("GER");
        adr.setState("BAV");
        adr.setZIP("94107");
        emp.setAddress(adr);

        emp.setId(requestType.getId());
        emp.setFirstname("Merc");
        emp.setLastname("Benz");
        emp.setEmail("merc@dstech.com");
        employeeResponse.setEmployee(emp);


      return  employeeResponse;
    }

}
