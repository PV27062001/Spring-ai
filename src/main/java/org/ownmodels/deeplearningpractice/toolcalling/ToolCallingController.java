package org.ownmodels.deeplearningpractice.toolcalling;


import lombok.RequiredArgsConstructor;
import org.ownmodels.deeplearningpractice.externalapi.weather.CityInfo;
import org.ownmodels.deeplearningpractice.weather.WeatherService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/v1/toolcalling")
@RequiredArgsConstructor
public class ToolCallingController {

    private final WeatherService weatherService;
    private final ChatModel chatModel;

    @PostMapping(value = "/getWeather-entity",params = "cityName")
    public List<CityInfo> getWeatherInfoByCity(@RequestParam String cityName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("templates/tool-calling-City-info.txt");
        String text = StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
        SystemMessage systemMessage = new SystemMessage(text);
        Prompt prompt = new Prompt(systemMessage,new UserMessage("get me the current weather info for " + cityName));
        return ChatClient.create(chatModel)
                .prompt(prompt)
                .tools(weatherService)
                .call()
                .entity(new ParameterizedTypeReference<List<CityInfo>>() {});
    }

    @PostMapping(value = "/getWeather",params = "cityName")
    public String getWeatherInfoByCityInResponse(@RequestParam String cityName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("templates/tool-calling-weather-info.txt");
        String text = StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
        SystemMessage systemMessage = new SystemMessage(text);
        Prompt prompt = new Prompt(systemMessage,new UserMessage("get me the current weather info for " + cityName));
        return ChatClient.create(chatModel)
                .prompt(prompt)
                .tools(weatherService)
                .call().content();
    }

}
