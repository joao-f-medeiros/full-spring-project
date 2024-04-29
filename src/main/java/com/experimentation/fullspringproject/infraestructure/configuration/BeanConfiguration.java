package com.experimentation.fullspringproject.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.experimentation.fullspringproject.domain.service.StockService;
import com.experimentation.fullspringproject.domain.service.impl.DomainStockService;
import com.experimentation.fullspringproject.infraestructure.integration.GoogleFinanceIntegration;
import com.experimentation.fullspringproject.infraestructure.integration.RestClientGoogleFinanceIntegration;

@Configuration
public class BeanConfiguration {

  /*
   * Can switch between RestClientGoogleFinanceIntegration and
   * GoogleFinanceIntegration to implement the request to client.
   */
  @Bean
  StockService getStockService(RestClientGoogleFinanceIntegration restClientGoogleFinanceIntegration) {
    return new DomainStockService(restClientGoogleFinanceIntegration);
  }

  @Bean
  GoogleFinanceIntegration getGoogleFinanceIntegration(HttpServiceProxyFactory httpServiceProxyFactory) {
    return httpServiceProxyFactory.createClient(GoogleFinanceIntegration.class);
  }

  @Bean
  RestClient financialClient() {
    return RestClient.create("https://www.google.com/finance/quote");
  }

}
