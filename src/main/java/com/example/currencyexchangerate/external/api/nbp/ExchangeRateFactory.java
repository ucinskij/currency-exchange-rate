package com.example.currencyexchangerate.external.api.nbp;

import java.math.BigDecimal;

public class ExchangeRateFactory {

  public static ExchangeRate createWithZeroAmount(String currency) {
    return new ExchangeRate(BigDecimal.ZERO, currency.toUpperCase());
  }

  static ExchangeRate createFrom(NbpApiResponse nbpApiResponse) {
    return new ExchangeRate(nbpApiResponse.getRates().get(0).getMid(), nbpApiResponse.getCode());
  }
}
