package spring.ai.example.spring_ai_demo.service

import org.springframework.ai.chat.client.ChatClient
import spring.ai.example.spring_ai_demo.domain.ActorFilms

class AIService {
  private final ChatClient chatClient;

  AIService(ChatClient chatClient) {
    this.chatClient = chatClient
  }

  String getAIResponse(String prompt, String voice) {
    this.chatClient.prompt()
      .system(sp -> sp.param("voice", voice))
      .user(prompt)
      .call()
      .content()
  }

  ActorFilms getActorFilms(String actorName) {
    String prompt = "Generate the filmography for the actor ${actorName}"
    chatClient.prompt()
      .user(prompt)
      .call()
      .entity(ActorFilms.class)
  }


}
