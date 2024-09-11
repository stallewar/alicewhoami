package zurnix.plermax.driv.alicewhoami.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zurnix.plermax.driv.alicewhoami.service.PhraseService;

@RestController
@RequestMapping("/webhook")
public class AliceController {

    @Autowired
    private PhraseService phraseService;

    @PostMapping
    public Map<String, Object> handleRequest(@RequestBody Map<String, Object> request) {
        Map<String, Object> requestBody = (Map<String, Object>) request.get("request");
        String command = (String) requestBody.get("command");

        String responseText;
        if ("кто я сегодня".equalsIgnoreCase(command)) {
            responseText = phraseService.getRandomPhrase();
        } else {
            responseText = "Извините, я вас не понял.";
        }

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("text", responseText);
        responseMap.put("end_session", false);
        response.put("version", request.get("version"));
        response.put("session", request.get("session"));
        response.put("response", responseMap);

        return response;
    }
}
