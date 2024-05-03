package com.experimentation.fullspringproject.domain.service.impl;

import java.math.BigDecimal;

import com.experimentation.fullspringproject.domain.integration.FinancesIntegration;
import com.experimentation.fullspringproject.domain.service.StockService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DomainStockService implements StockService {

  private final FinancesIntegration financesIntegration;

  @Override
  public BigDecimal getStockValue(String code) {
    String stockPage = financesIntegration.searchStockMarketPrice(code);
    int stockIndex = stockPage.indexOf(code + "</div>");
    if (stockIndex == -1) {
      return BigDecimal.ZERO;
    }
    int dollarsIndex = stockPage.lastIndexOf("$", stockPage.indexOf(",", stockIndex));
    if (dollarsIndex == -1) {
      return BigDecimal.ZERO;
    }
    String price = stockPage.substring(dollarsIndex + 1, stockPage.indexOf(",", stockIndex) + 3)
        .replace(",", ".")
        .replace("\u00a0", "");
    return new BigDecimal(price);
  }

}
