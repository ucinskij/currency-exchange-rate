package com.example.currencyexchangerate.external.api.nbp;

import org.springframework.web.client.RestOperations;

public class ExchangeRateConnectionFactory {

  public ExchangeRateConnection createNbpConnection(RestOperations restOperations) {
    return new NbpExchangeRateConnection(restOperations);
  }
}
