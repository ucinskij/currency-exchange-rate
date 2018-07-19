package com.example.currencyexchangerate.external.api.nbp;

import java.math.BigDecimal;

public class ExchangeRateFixtures {

  public static ExchangeRate createExchangeRate(BigDecimal amount, String currency) {
    return new ExchangeRate(amount, currency.toUpperCase());
  }
}
