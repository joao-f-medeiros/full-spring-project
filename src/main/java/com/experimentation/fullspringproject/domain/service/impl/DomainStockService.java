package com.experimentation.fullspringproject.domain.service.impl;

import java.math.BigDecimal;

import com.experimentation.fullspringproject.domain.integration.FinancesIntegration;
import com.experimentation.fullspringproject.domain.service.StockService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DomainStockService implements StockService {

  private FinancesIntegration financesIntegration;

  @Override
  public BigDecimal getStockValue(String code) {
    String stockPage = financesIntegration.searchStockMarketPrice(code);
    if (stockPage.contains(code + "</div>")) {
      int target = stockPage.indexOf(code + "</div>");
      int deci = stockPage.indexOf(",", target);
      int start = deci;
      while (stockPage.charAt(start) != '$') {
        start--;
      }
      String price = stockPage.substring(start + 1, deci + 3);
      return new BigDecimal(price.replace(",", ".").replace("\u00a0", ""));
    }
    return BigDecimal.ZERO;
  }

}
