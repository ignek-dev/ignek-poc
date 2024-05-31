package com.ignek.slack_int.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * The type Slack service.
 */
@Service
@Slf4j
public class SlackService {

  private final WebClient webClient;
  @Value("${slack.channel}")
  private String slackChannel;

  /**
   * Instantiates a new Slack service.
   *
   * @param webClientBuilder the web client builder
   */
  public SlackService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://hooks.slack.com").build();
  }

  /**
   * Send message.
   *
   * @param message the message
   */
  public void sendMessage(String message) {
    String url = "/services/T075R8UDD4K/B076FK9H856/1JuoxDifz8oeHQzeNJER7ceH";

    String json = "{ \"channel\": \"" + slackChannel + "\", \"text\": \"" + message + "\" }";

    webClient.post().uri(url).header("Content-Type", String.valueOf(MediaType.APPLICATION_JSON))
        .bodyValue(json).retrieve().bodyToMono(String.class).subscribe(
            response -> log.info("Message sent to Slack channel {} successfully!", slackChannel),
            error -> log.error("Error sending message to Slack", error));
  }
}
