package com.example.currencyexchangerate.external.api.nbp;

import java.math.BigDecimal;

public class FakeNbpExchangeRateConnection implements ExchangeRateConnection {

  @Override
  public NbpApiResponse getApiResponse(String currency) {
    return NbpApiResponseFixtures.getNbpApiResponse(currency, BigDecimal.TEN);
  }
}
