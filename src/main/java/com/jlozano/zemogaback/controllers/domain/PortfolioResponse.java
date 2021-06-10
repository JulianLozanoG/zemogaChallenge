package com.jlozano.zemogaback.controllers.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jlozano.zemogaback.entities.Portfolio;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PortfolioResponse {
    @JsonProperty(value = "portfolio")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private final Portfolio portfolio;
}
