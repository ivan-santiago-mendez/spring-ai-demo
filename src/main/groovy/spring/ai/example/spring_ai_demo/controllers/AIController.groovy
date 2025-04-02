package spring.ai.example.spring_ai_demo.controllers

import org.springframework.ai.chat.client.ChatClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AIController {

  private final ChatClient chatClient;

  AIController(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  @GetMapping("/ai")
  Map<String, String> completion(@RequestParam(name = "message", defaultValue = "Tell me a joke") String message,@RequestParam(name = "voice", defaultValue = "") String voice) {
    return Map.of("completion",
      this.chatClient.prompt()
        .system(sp -> sp.param("voice", voice))
        .user(message)
        .call()
        .content());
  }
}
