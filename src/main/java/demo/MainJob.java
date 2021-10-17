package demo;

import demo.selenium.*;
import demo.Model.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import java.io.*;

@SpringBootApplication
public class MainJob {
    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(MainJob.class, args);

    }

}

