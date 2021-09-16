package com.sullivankw.CoinMetrics.Controllers;

import com.sullivankw.CoinMetrics.Assembler;
import com.sullivankw.CoinMetrics.dto.CoinMarketResponseDTO;
import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import com.sullivankw.CoinMetrics.service.CoinMarketService;
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

    @Autowired
    private Assembler assembler;

    @Autowired
    private CoinMarketService coinMarketService;

    @ApiOperation(value = "Use this to get all latest market info for the top 400 in coin gecko")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CoinMarkets> getCoinMarkets() {
        return coinMarketService.getBasicCoinMarketData();
    }

    @ApiOperation(value = "Use this to get all latest market info for the top 400 in coin gecko. THIS WILL ALSO PERSIST THE DATA")
    @GetMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public List<CoinMarketResponseDTO> getAndSaveCoinMarkets() {
        return coinMarketService.getAndSaveCoinMarketData();
    }
}
