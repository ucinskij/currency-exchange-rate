package com.example.currencyexchangerate.external.api.nbp;

import org.springframework.web.client.RestOperations;

class NbpExchangeRateConnection implements ExchangeRateConnection {

  private static final String DEFAULT_FORMAT = "json";
  private static final String NBP_URL = "http://api.nbp.pl/api/exchangerates/rates/a/{currency}/?format={format}";
  private final RestOperations restOperations;

  NbpExchangeRateConnection(RestOperations restOperations) {
    this.restOperations = restOperations;
  }

  @Override
  public NbpApiResponse getApiResponse(String currency) {
    return restOperations
        .getForEntity(NBP_URL, NbpApiResponse.class, currency, DEFAULT_FORMAT)
        .getBody();
  }
}
