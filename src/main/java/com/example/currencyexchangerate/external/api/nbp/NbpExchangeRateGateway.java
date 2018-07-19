package com.example.currencyexchangerate.external.api.nbp;

import static com.example.currencyexchangerate.external.api.nbp.ExchangeRateFactory.createFrom;
import static com.example.currencyexchangerate.external.api.nbp.ExchangeRateFactory.createWithZeroAmount;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

class NbpExchangeRateGateway implements ExchangeRateGateway {

  private final ExchangeRateConnection connection;

  NbpExchangeRateGateway(ExchangeRateConnection connection) {
    this.connection = connection;
  }

  @Override
  public Future<ExchangeRate> getExchangeRate(String currency) {
    return CompletableFuture
        .supplyAsync(() -> getNbpApiResponse(currency))
        .thenApply(nbpApiResponse -> createFrom(nbpApiResponse))
        .exceptionally(throwable -> createWithZeroAmount(currency));
  }

  private NbpApiResponse getNbpApiResponse(String currency) {
    return connection.getApiResponse(currency);
  }
}
