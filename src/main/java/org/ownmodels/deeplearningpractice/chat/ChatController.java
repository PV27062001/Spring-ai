package org.ownmodels.deeplearningpractice.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatModel chatModel;

    @PostMapping("/chat")
    public String chat(@RequestBody String userInput) {
        return chatModel.call(userInput);
    }

}