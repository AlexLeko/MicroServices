package com.alexleko.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchageValue, Long> {

    ExchageValue findByFromAndTo(String from, String to);

}
