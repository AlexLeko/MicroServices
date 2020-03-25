package com.alexleko.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchageValue retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to ) {

        ExchageValue exchageValue = repository.findByFromAndTo(from, to);
        exchageValue.setPort( Integer.parseInt(
                                environment.getProperty("local.server.port")) );

        return exchageValue;

    }

}
