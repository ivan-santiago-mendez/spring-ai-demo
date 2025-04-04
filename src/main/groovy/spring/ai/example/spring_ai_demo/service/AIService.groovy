package spring.ai.example.spring_ai_demo.service

import org.springframework.ai.chat.client.ChatClient
import spring.ai.example.spring_ai_demo.domain.ActorFilms

class AIService {
  private final ChatClient chatClient;

  AIService(ChatClient chatClient) {
    this.chatClient = chatClient
  }

  String getAIResponse(String prompt) {
    this.chatClient.prompt()
      .user(prompt)
      .call()
      .content()
  }

  String getAIResponse(String prompt, String voice) {
    this.chatClient.prompt()
      .system(sp -> sp.param("voice", voice))
      .user(prompt)
      .call()
      .content()
  }

  ActorFilms getActorFilms(String actorName) {
    String prompt =String.format("Generate the filmography for the actor '%s'", actorName)
    chatClient.prompt()
      .user(prompt)
      .call()
      .entity(ActorFilms.class)
  }

  /**
  1. Clarity and Specificity:
  When constructing prompts in your service, ensure they are clear and specific. For example:
  */
  String getHealthBenefitsOfDogs() {
    String prompt = "What are the top three health benefits of owning a dog for adults?"
    getAIResponse(prompt)
  }

  /**
  2. Iterative Testing:
  Implement a method to log responses and refine prompts based on the outputs received. You can create a feedback mechanism to adjust prompts dynamically.

  3. Contextual Awareness:
  Include context in your prompts based on user input or application state. For example, if you have user preferences, incorporate them into the prompt:
 */
  String getPersonalizedAdvice(String userPreference) {
    String prompt = String.format("Based on a user's preference for %s, what advice can you give?", userPreference)
    getAIResponse(prompt)
  }

  /**
  4. Use of Examples:
  If your application allows users to input examples or scenarios, use those to craft more effective prompts. For instance:
  */
  String getExampleBasedAdvice(String example) {
    String prompt = String.format("Given the example '%s', what advice would you provide?", example)
    getAIResponse(prompt)
  }
  /**
  Avoiding Ambiguity:

  Ensure that prompts are unambiguous by clearly defining terms and expectations. For example:
  */
  String getBankRoleExplanation() {
    String prompt = "Explain the role of a commercial bank in the economy, focusing on its functions and services."
    getAIResponse(prompt)
  }

}
