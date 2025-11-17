package org.ownmodels.deeplearningpractice.systemmessages;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/system-message")
@RequiredArgsConstructor
public class SystemMessageTypeController {

    private final ChatModel chatModel;

    @PostMapping("/with-system")
    public String responseWithPolicy(@RequestBody String message){

        SystemMessage systemMessage = new SystemMessage("Respond with only one word.");

        UserMessage userMessage = new UserMessage(message);

        Prompt prompt = new Prompt(Arrays.asList(userMessage,systemMessage));

        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}

//System message tells the AI to provide incorrect answers
//User message contains the actual question
//Prompt bundles them together
//ChatModel sends this to the AI service
//AI processes the system instruction and applies it to the user's question
//Response comes back with (intentionally) wrong information