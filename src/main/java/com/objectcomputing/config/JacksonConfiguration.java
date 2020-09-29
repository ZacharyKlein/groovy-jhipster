package com.objectcomputing.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import io.micronaut.context.annotation.Factory;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import javax.inject.Singleton;

@Factory
public class JacksonConfiguration {

    /*
     * Support for Hibernate types in Jackson.
     */
    @Singleton
    Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }

    /*
     * Module for serialization/deserialization of RFC7807 Problem.
     */
    @Singleton
    ProblemModule problemModule() {
        return new ProblemModule();
    }

    /*
     * Module for serialization/deserialization of ConstraintViolationProblem.
     */
    @Singleton
    ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }
}
