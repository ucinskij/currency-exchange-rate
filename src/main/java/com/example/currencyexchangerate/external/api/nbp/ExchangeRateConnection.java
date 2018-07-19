package com.example.currencyexchangerate.external.api.nbp;

public interface ExchangeRateConnection {

  NbpApiResponse getApiResponse(String currency);
}
