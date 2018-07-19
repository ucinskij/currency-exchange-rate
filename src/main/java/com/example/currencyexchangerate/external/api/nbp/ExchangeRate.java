package com.example.currencyexchangerate.external.api.nbp;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;

public class ExchangeRate {

  private BigDecimal value;
  private String currencyCode;

  ExchangeRate(BigDecimal value, String currencyCode) {
    requireNonNull(value);
    requireNonNull(currencyCode);
    this.value = value;
    this.currencyCode = currencyCode.toUpperCase();
  }

  public BigDecimal getValue() {
    return value;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }
}
