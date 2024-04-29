package com.experimentation.fullspringproject.application.rest;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experimentation.fullspringproject.domain.service.StockService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/stocks")
public class StockResource {

  private StockService stockService;

  @GetMapping("/{code}")
  public StockDTO getStock(@PathVariable String code) {
    return new StockDTO(code, stockService.getStockValue(code));
  }

  record StockDTO(String code, BigDecimal value) {
  }
}
