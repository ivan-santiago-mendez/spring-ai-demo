package spring.ai.example.spring_ai_demo.configurations

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spring.ai.example.spring_ai_demo.service.AIService

@Configuration
class AIConfiguration {

  @Autowired
  ChatModel myChatModel

  @Bean
  ChatClient.Builder getChatClientBuilder(){
    ChatClient.builder(myChatModel);
  }

  @Bean
  ChatClient chatClient(ChatClient.Builder builder) {
    builder.defaultSystem("You are a friendly chat bot that answers question in the voice of a Pirate")
      .build();
  }

  @Bean
  AIService getAiService(ChatClient chatClient){
    new AIService(chatClient)
  }

}
