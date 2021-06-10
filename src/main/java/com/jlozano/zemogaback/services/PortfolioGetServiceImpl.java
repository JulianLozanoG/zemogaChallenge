package com.jlozano.zemogaback.services;

import com.jlozano.zemogaback.entities.Portfolio;
import com.jlozano.zemogaback.exception.PortfolioNotFoundException;
import com.jlozano.zemogaback.repository.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PortfolioGetServiceImpl implements PortfolioGetService{

    private final PortfolioRepository portfolioRepository;

    @Override
    public Optional<Portfolio> getPortfolio(Integer id) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(id);
        if (!portfolioOptional.isPresent())
            throw new PortfolioNotFoundException("Portfolio not found");

        return portfolioOptional;
    }
}
