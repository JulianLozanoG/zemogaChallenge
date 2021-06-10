package com.jlozano.zemogaback.repository;

import com.jlozano.zemogaback.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
