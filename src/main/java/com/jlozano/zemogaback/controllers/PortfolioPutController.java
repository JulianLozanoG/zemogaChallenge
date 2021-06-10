package com.jlozano.zemogaback.controllers;

import com.jlozano.zemogaback.controllers.domain.PortfolioResponse;
import com.jlozano.zemogaback.entities.Portfolio;
import com.jlozano.zemogaback.exception.PortfolioNotFoundException;
import com.jlozano.zemogaback.services.PortfolioGetService;
import com.jlozano.zemogaback.services.PortfolioPutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Portfolio"})
@CrossOrigin(origins = {"http://localhost:4200"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/portfolio")
public class PortfolioPutController {

    private final PortfolioGetService portfolioGetService;
    private final PortfolioPutService portfolioPutService;

    @PutMapping(value = "/{portfolioId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PortfolioResponse> updatePortfolio(
            //@RequestParam("image")MultipartFile image
            @ApiParam(value = "ID for the Portfolio.", required = true)
            @Pattern(regexp = "^[0-9]{2}", message = "The Portfolio ID should contain only numeric characters and its length si not mayor than 2.")
            @PathVariable Integer portfolioId,

            @RequestBody
            @Valid Portfolio portfolioUpdateRequest){

        Optional<Portfolio> portfolio = portfolioGetService.getPortfolio(portfolioId);
        if (isNull(portfolio))
            throw new PortfolioNotFoundException("User not found");

        portfolioPutService.updatePortfolio(portfolioUpdateRequest, portfolioId);

        return ok(new PortfolioResponse(portfolioUpdateRequest));

    }
}
