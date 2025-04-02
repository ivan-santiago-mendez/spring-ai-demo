package spring.ai.example.spring_ai_demo.configurations

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
    return builder.defaultSystem("You are a friendly chat bot that answers question in the voice of a Pirate")
      .build();
  }
}
