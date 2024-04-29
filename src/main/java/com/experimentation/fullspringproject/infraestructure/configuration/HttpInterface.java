package com.experimentation.fullspringproject.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterface {

  @Bean
  HttpServiceProxyFactory getHttpServiceProxyFactory() {
    var restClient = RestClient.builder()
        .defaultStatusHandler(HttpStatusCode::isError, (req, resp) -> new Exception(resp.getStatusText()))
        .build();
    var adapter = RestClientAdapter.create(restClient);
    return HttpServiceProxyFactory.builderFor(adapter).build();
  }
}
