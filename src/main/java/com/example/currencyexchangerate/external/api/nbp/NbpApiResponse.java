package com.example.currencyexchangerate.external.api.nbp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

class NbpApiResponse {

  private String code;
  private List<NbpRate> rates;

  @JsonCreator
  NbpApiResponse(@JsonProperty("code") String code, @JsonProperty("rates") List<NbpRate> rates) {
    this.code = code;
    this.rates = rates;
  }

  String getCode() {
    return code;
  }

  List<NbpRate> getRates() {
    return rates;
  }

  static class NbpRate {
    private BigDecimal mid;

    @JsonCreator
    NbpRate(@JsonProperty("mid") BigDecimal mid) {
      this.mid = mid;
    }

    BigDecimal getMid() {
      return mid;
    }
  }
}
