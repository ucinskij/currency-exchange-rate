package com.example.currencyexchangerate.unit.exchangerate;

import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGateway;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class FailureOnCallingExchangeRateGateway implements ExchangeRateGateway {

  @Override
  public Future<ExchangeRate> getExchangeRate(String currency) {
    return CompletableFuture.failedFuture(new ExecutionException(null));
  }
}
