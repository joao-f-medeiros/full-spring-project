package com.experimentation.fullspringproject.infraestructure.integration;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.experimentation.fullspringproject.domain.integration.FinancesIntegration;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestClientGoogleFinanceIntegration implements FinancesIntegration {

  private final RestClient restClient;

  @Override
  public String searchStockMarketPrice(String code) {
    return restClient.get()
        .uri("/{code}:BVMF?hl=pt", code)
        // .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .onStatus(HttpStatusCode::is5xxServerError, (req, resp) -> {
          throw new IllegalArgumentException("Request Error");
        })
        .body(String.class);
  }

}
