package org.ownmodels.deeplearningpractice.structuredoutput;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/v1/structured-output")
@RequiredArgsConstructor
public class StructuredOutputChatController {

    private final ChatModel chatModel;

    @PostMapping("/structured")
    public List<Animal> getAnimalSuggestion(@RequestBody String message) throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("templates/structured-output.txt");
        String text =  StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
        SystemMessage systemMessage = new SystemMessage(text);

        UserMessage userMessage = new UserMessage(message);
        Prompt  prompt = new Prompt(systemMessage,userMessage);

        return ChatClient.create(chatModel)
                .prompt(prompt)
                .call()
                .entity(new ParameterizedTypeReference<List<Animal>>() {});
    }

}
