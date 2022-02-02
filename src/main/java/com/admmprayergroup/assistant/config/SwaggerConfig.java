package com.admmprayergroup.assistant.config;


import com.admmprayergroup.assistant.vo.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.Properties;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.desc}")
    private String appDescription;

    @Value("${company.name}")
    private String companyName;

    @Value("${company.website}")
    private String companyWebsite;

    @Value("${company.email}")
    private String companyEmail;

    @Bean
    public BuildProperties buildProperties() {
        return new BuildProperties(
                new Properties()
        );
    }

    @Bean
    public Docket swaggerConfiguration() {
        // Return a prepared docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.admmprayergroup.assistant"))
                .build()
                .apiInfo(this.swaggerAPIDetails());
    }

    private ApiInfo swaggerAPIDetails() {
        final String SERVICE_NAME = this.appName;
        final String DESCRIPTION = this.appDescription;
        final String VERSION = buildProperties().getVersion();
        final String TERMS = "All Rights Reserved 2022 - ".concat(this.companyName);
        final Contact CONTACT = new Contact(this.companyName, this.companyWebsite, this.companyEmail);
        final String LICENSE = "The Apache Software License, Version 2.0";
        final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.txt";
        return new ApiInfo(SERVICE_NAME, DESCRIPTION, VERSION, TERMS, CONTACT, LICENSE, LICENSE_URL, Collections.emptyList());
    }

}
