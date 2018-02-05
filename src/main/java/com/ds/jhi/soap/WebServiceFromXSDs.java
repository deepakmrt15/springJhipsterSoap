package com.ds.jhi.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

/**
 * Created by ds on 07/22/2017.
 */
@EnableWs
@Configuration
public class WebServiceFromXSDs extends WsConfigurerAdapter {
    @Bean(name = "employeeServlet")
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soap/service/*");
    }

    @Bean(name = "employee")
    public DefaultWsdl11Definition defaultWsdl11Definition( XsdSchemaCollection employeeXSDs ) {
        DefaultWsdl11Definition empWsdlDef = new DefaultWsdl11Definition();
       // wsdl11Definition
        empWsdlDef.setPortTypeName("EmployeePort");
        empWsdlDef.setLocationUri("/soap/service");
        //http://localhost:8080/api/service/empService/employee.wsdl
        empWsdlDef.setSchemaCollection(employeeXSDs);
           return empWsdlDef;
    }
//employee xsd has a reference to address xsd
@Bean(name = "employeeXSDs")
public XsdSchemaCollection empSchemaCollection() {
    CommonsXsdSchemaCollection empXsds = new CommonsXsdSchemaCollection(
        new ClassPathResource("/schema/employee.xsd"));//,new ClassPathResource("/schema/address.xsd")
    empXsds.setInline(true);//if it is true then all the nested/referenced XDSs get included in the main xsd else need to provide it in collection
      return  empXsds;

     }

   }

