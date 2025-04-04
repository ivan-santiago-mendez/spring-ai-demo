package spring.ai.example.spring_ai_demo.controllers


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import spring.ai.example.spring_ai_demo.domain.ActorFilms
import spring.ai.example.spring_ai_demo.service.AIService

@RestController
@RequestMapping("ai")
class AIController {

  private final AIService aiService

  AIController(AIService aiService) {
    this.aiService = aiService
  }

  @GetMapping("/")
  Map<String, String> completion(@RequestParam(name = "message", defaultValue = "Tell me a joke") String message,@RequestParam(name = "voice", defaultValue = "") String voice) {
    return Map.of("completion",
      this.aiService.getAIResponse(message, voice))
  }

  @GetMapping("/actorFilms")
  ActorFilms getActorFilms(@RequestParam(name = "actorName", defaultValue = "") String actorName) {
    this.aiService.getActorFilms(actorName)
  }

  @GetMapping("/health-benefits")
  String getHealthBenefits() {
    return aiService.getHealthBenefitsOfDogs();
  }

  @GetMapping("/personalized-advice")
  String getPersonalizedAdvice(@RequestParam String preference) {
    return aiService.getPersonalizedAdvice(preference);
  }

  @GetMapping("/example-based-advice")
  String getExampleBasedAdvice(@RequestParam String example) {
    return aiService.getExampleBasedAdvice(example);
  }

  @GetMapping("/bank-role-explanation")
  String getBankRoleExplanation() {
    return aiService.getBankRoleExplanation();
  }
}
