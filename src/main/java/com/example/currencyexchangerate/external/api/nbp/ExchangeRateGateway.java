package com.example.currencyexchangerate.external.api.nbp;

import java.util.concurrent.Future;

public interface ExchangeRateGateway {

  Future<ExchangeRate> getExchangeRate(String currency);
}
