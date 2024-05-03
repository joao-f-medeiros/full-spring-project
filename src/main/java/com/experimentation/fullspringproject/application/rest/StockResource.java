package com.experimentation.fullspringproject.application.rest;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experimentation.fullspringproject.domain.service.StockService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stocks")
public class StockResource {

  private final StockService stockService;

  @GetMapping("/{code}")
  public StockResponse getStockValue(@PathVariable String code) {
    return new StockResponse(code, stockService.getStockValue(code));
  }

  record StockResponse(String code, BigDecimal value) {
  }
}
