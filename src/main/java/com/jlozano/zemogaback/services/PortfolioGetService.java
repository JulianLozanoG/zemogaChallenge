package com.jlozano.zemogaback.services;

import com.jlozano.zemogaback.entities.Portfolio;

import java.util.Optional;

public interface PortfolioGetService {
    Optional<Portfolio> getPortfolio(Integer id);
}
