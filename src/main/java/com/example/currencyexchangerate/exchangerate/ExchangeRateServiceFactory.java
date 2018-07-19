package com.example.currencyexchangerate.exchangerate;

import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGateway;

public class ExchangeRateServiceFactory {

  public ExchangeRateService createBestExchangeRateService(ExchangeRateGateway exchangeRateGateway) {
    return new BestExchangeRateService(exchangeRateGateway);
  }
}
