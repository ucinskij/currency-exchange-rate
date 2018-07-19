package com.example.currencyexchangerate.exchangerate;

import com.example.currencyexchangerate.external.api.nbp.ExchangeRate;

public interface ExchangeRateService {

  ExchangeRate getCurrentExchangeRate(String currency);
}
