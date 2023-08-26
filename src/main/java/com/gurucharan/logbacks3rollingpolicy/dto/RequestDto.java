package com.gurucharan.logbacks3rollingpolicy.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestDto {

  @JsonProperty("transaction_id")
  @JsonAlias("transactionId")
  private String transactionId;

  @JsonProperty("transaction_source")
  @JsonAlias("transactionSource")
  private String transactionSource;

  @JsonProperty("user_id")
  @JsonAlias("userId")
  private String userId;
}
