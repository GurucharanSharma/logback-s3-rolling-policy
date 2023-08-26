package com.gurucharan.logbacks3rollingpolicy.controller;

import static com.gurucharan.logbacks3rollingpolicy.constants.ApplicationConstants.FILE_WRITE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gurucharan.logbacks3rollingpolicy.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/logger")
@RestController
@RequiredArgsConstructor
public class LogController {

  final Logger logger = LogManager.getLogger();

  @PostMapping("/send")
  public Mono<String> send(@RequestBody RequestDto requestDto) throws JsonProcessingException {
    return Mono.just(requestDto)
        .doOnNext(request -> logger.log(FILE_WRITE, "Request received: " + request))
        .map(RequestDto::getTransactionId);
  }
}
