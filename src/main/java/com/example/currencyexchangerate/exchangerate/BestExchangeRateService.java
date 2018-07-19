package com.example.currencyexchangerate.exchangerate;

import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateFactory;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGateway;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class BestExchangeRateService implements ExchangeRateService {

  private final ExchangeRateGateway exchangeRateGateway;

  BestExchangeRateService(ExchangeRateGateway exchangeRateGateway) {
    this.exchangeRateGateway = exchangeRateGateway;
  }

  @Override
  public ExchangeRate getCurrentExchangeRate(String currency) {
    Future<ExchangeRate> exchangeRateFuture = exchangeRateGateway.getExchangeRate(currency);

    try {
      return exchangeRateFuture.get();
    } catch (InterruptedException | ExecutionException e) {
      return ExchangeRateFactory.createWithZeroAmount(currency);
    }
  }
}
