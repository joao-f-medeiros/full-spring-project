package com.experimentation.fullspringproject.infraestructure.integration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.experimentation.fullspringproject.domain.integration.FinancesIntegration;

@HttpExchange(accept = MediaType.APPLICATION_JSON_VALUE, url = "https://www.google.com/finance/quote")
public interface GoogleFinanceIntegration extends FinancesIntegration {

  @Override
  @GetExchange("/{code}:BVMF?hl=pt")
  public String searchStockMarketPrice(@PathVariable String code);

}
