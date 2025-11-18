package org.ownmodels.deeplearningpractice.prompttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/prompt-template")
@RequiredArgsConstructor
public class ReusableTemplate {

    private final ChatModel chatModel;

    @PostMapping("/template")
    public String askWithPromptTemplate(@RequestBody ChatRequestSplit request) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("templates/prompt.txt");
        String template = StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
        PromptTemplate promptTemplate = new PromptTemplate(template);

        Prompt prompt = promptTemplate.create(
                Map.of(
                        "language", request.getLanguage(),
                        "text", request.getText()
                )
        );
        return chatModel.call(prompt).getResult().getOutput().getText();
    }

}



