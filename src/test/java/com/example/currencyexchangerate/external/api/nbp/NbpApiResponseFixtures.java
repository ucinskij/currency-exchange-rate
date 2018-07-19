package com.example.currencyexchangerate.external.api.nbp;

import static java.util.Arrays.asList;

import com.example.currencyexchangerate.external.api.nbp.NbpApiResponse.NbpRate;
import java.math.BigDecimal;

public class NbpApiResponseFixtures {

  public static NbpApiResponse getNbpApiResponse(String code, BigDecimal amount) {
    return new NbpApiResponse(code, asList(new NbpRate(amount)));
  }
}
