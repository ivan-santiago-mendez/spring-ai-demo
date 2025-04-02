package spring.ai.example.spring_ai_demo

import org.springframework.ai.chat.client.ChatClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringAiDemoApplication {

	static void main(String[] args) {
		SpringApplication.run(SpringAiDemoApplication, args)
	}
	/* Basic configuration to review basic configuration
	@Value('${API_KEY:NO_API_KEY}')
	String API_KEY

	@Bean
	CommandLineRunner getCommandLineRunner(ChatClient.Builder builder) {
    (args) -> {
      ChatClient chatClient = builder.build();
      String response = chatClient.prompt("Tell me a joke").call().content();
      System.out.println(response);
    } as CommandLineRunner;
	}
	*/
}
