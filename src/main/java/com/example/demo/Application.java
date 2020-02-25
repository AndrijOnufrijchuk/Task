package com.example.demo;
import com.example.demo.repository.CategoryDao;
import com.example.demo.repository.InventoryListDAO;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner {



    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryDao employeeRepository;
    @Autowired
    private InventoryListDAO inventoryListRepo;

    @Override
    public void run(String... args) throws Exception {
//Couple of tests
      //  logger.info("Inserting -> {}", employeeRepository.insert(new Category("Andruxzxcsha")));
       // logger.info("Inserting -> {}", inventoryListRepo.insert(new InventoryList("newProd","meat")));
       // logger.info("Employee id 10011 -> {}", employeeRepository.findById(1));
      // logger.info("All users -> {}", employeeRepository.findAll());
        //logger.info("All users -> {}", inventoryListRepo.deleteById(1));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
