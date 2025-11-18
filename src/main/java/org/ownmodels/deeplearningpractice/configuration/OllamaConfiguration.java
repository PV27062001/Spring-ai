package org.ownmodels.deeplearningpractice.configuration;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfiguration {

    @Value("${spring.ai.ollama.chat.model}")
    private String model;

    @Value("${spring.ai.ollama.chat.options.temperature}")
    private Double temperature;

    @Value("${spring.ai.ollama.chat.options.top-p}")
    private Double topP;

    @Bean
    public ChatModel chatModel(OllamaApi ollamaApi){
        return OllamaChatModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(OllamaOptions.builder()
                        .model(model)
                        .temperature(temperature)
                        .topP(topP)
                        .build())
                .build();
    }
}
