package org.ownmodels.deeplearningpractice.systemmessages;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.List;


@RestController
@RequestMapping("/api/v1/with-history")
@RequiredArgsConstructor
public class AssistantMessageTypeController {

    private final ChatModel chatModel;

   private final List<Message> convoHistory = new ArrayList<>();

    @PostMapping("/convo-history")
    public String getResponseWithChatHistory(@RequestBody String currentMessage){
        if(convoHistory.isEmpty()){
            SystemMessage systemMessage = new SystemMessage("Act like you are a fool");
            convoHistory.add(systemMessage);
        }
        convoHistory.add(new UserMessage(currentMessage));
        Prompt prompt = new Prompt(convoHistory);
        String assistantMessage = chatModel.call(prompt).getResult().getOutput().getContent();
        convoHistory.add(new AssistantMessage(assistantMessage));
        return assistantMessage;
    }
}
