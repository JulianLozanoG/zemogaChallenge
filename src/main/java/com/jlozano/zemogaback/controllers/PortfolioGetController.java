package com.jlozano.zemogaback.controllers;

import com.jlozano.zemogaback.controllers.domain.PortfolioResponse;
import com.jlozano.zemogaback.entities.Portfolio;
import com.jlozano.zemogaback.exception.PortfolioNotFoundException;
import com.jlozano.zemogaback.services.PortfolioGetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Portfolio"})
@CrossOrigin(origins = {"http://localhost:4200"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/portfolio")
public class PortfolioGetController {

    private  final PortfolioGetService portfolioGetService;

    @GetMapping(value = "/{portfolioId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PortfolioResponse> getPortfolio(
            @ApiParam(value = "ID for the Portfolio.", required = true)
            @Pattern(regexp = "^[0-9]{2}", message = "The Portfolio ID should contain only numeric characters and its length si not mayor than 2.")
            @PathVariable Integer portfolioId){

        Optional<Portfolio> portfolio = portfolioGetService.getPortfolio(portfolioId);
        if(!portfolio.isPresent())
            throw new PortfolioNotFoundException("User not found");

        return ok(new PortfolioResponse(portfolio.get()));
    }
}
