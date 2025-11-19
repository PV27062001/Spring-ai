package org.ownmodels.deeplearningpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeepLearningPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeepLearningPracticeApplication.class, args);
    }

    @Bean
    public RestTemplate newResTemplate(){
        return new RestTemplate();
    }

}