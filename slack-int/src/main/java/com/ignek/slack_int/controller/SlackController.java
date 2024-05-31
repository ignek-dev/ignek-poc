package com.ignek.slack_int.controller;

import com.ignek.slack_int.service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Slack controller.
 */
@RestController
public class SlackController {
  private final SlackService slackService;

  /**
   * Instantiates a new Slack controller.
   *
   * @param slackService the slack service
   */
  @Autowired
  public SlackController(SlackService slackService) {
    this.slackService = slackService;
  }

  /**
   * Send slack message string.
   *
   * @param message the message
   * @return the string
   */
  @GetMapping("/sendSlackMessage")
  public String sendSlackMessage(@RequestParam String message) {
    slackService.sendMessage(message);
    return "Message sent!";
  }

}
