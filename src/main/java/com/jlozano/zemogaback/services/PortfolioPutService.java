package com.jlozano.zemogaback.services;

import com.jlozano.zemogaback.entities.Portfolio;

public interface PortfolioPutService {
    Portfolio updatePortfolio(Portfolio portfolio, Integer id);
}
