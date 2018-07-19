package com.example.currencyexchangerate.external.api.nbp;

public class ExchangeRateGatewayFactory {

  public ExchangeRateGateway createNbpExchangeRateGateway(ExchangeRateConnection connection) {
    return new NbpExchangeRateGateway(connection);
  }
}
