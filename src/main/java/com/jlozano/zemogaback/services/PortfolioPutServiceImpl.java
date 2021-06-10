package com.jlozano.zemogaback.services;

import com.jlozano.zemogaback.entities.Portfolio;
import com.jlozano.zemogaback.exception.PortfolioNotFoundException;
import com.jlozano.zemogaback.repository.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PortfolioPutServiceImpl implements PortfolioPutService{

    private final PortfolioRepository portfolioRepository;

    @Override
    public Portfolio updatePortfolio(Portfolio portfolio, Integer id) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(id);
        if (!portfolioOptional.isPresent())
            throw new PortfolioNotFoundException("Portfolio not found");

        portfolio.setId(id);
        portfolioRepository.save(portfolio);
        return portfolio;
    }
}
