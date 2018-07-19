package com.example.currencyexchangerate.unit.exchangerate;

import static com.example.currencyexchangerate.external.api.nbp.ExchangeRateFixtures.createExchangeRate;

import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;
import com.example.currencyexchangerate.external.api.nbp.ExchangeRateGateway;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

class FakeExchangeRateGateway implements ExchangeRateGateway {

  private final static Map<String, ExchangeRate> database = new HashMap<>();

  static {
    database.put("USD", createExchangeRate(new BigDecimal("3.4315"), "USD"));
    database.put("chf", createExchangeRate(new BigDecimal("3.5620"), "CHF"));
  }

  @Override
  public Future<ExchangeRate> getExchangeRate(String currency) {
    return CompletableFuture.completedFuture(searchInDatabase(currency));
  }

  private ExchangeRate searchInDatabase(String currency) {
    return database.entrySet().stream()
        .filter(p -> p.getKey().equalsIgnoreCase(currency))
        .findFirst()
        .map(p -> p.getValue())
        .orElse(createExchangeRate(BigDecimal.ZERO, currency.toUpperCase()));
  }
}
