package com.sullivankw.CoinMetrics.Controllers;

import com.sullivankw.CoinMetrics.domain.Coins.CoinMarkets;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/currentMarket")
public class CoinMarketController {

    @Autowired
    private CoinGeckoApiClientImpl client;

    @ApiOperation(value = "Use this to get all latest market info for coins 200-400 in coin gecko")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CoinMarkets> getCoinMarkets() {
        List<CoinMarkets> coinMarkets =  client.getCoinMarkets("usd");
        return coinMarkets;
    }
}
