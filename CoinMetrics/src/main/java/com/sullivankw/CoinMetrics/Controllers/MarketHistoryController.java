package com.sullivankw.CoinMetrics.Controllers;

import com.sullivankw.CoinMetrics.Assembler;
import com.sullivankw.CoinMetrics.domain.Coins.CoinHistoryById;
import com.sullivankw.CoinMetrics.dto.MarketHistoryResponseDTO;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/history")
public class MarketHistoryController {

    @Autowired
    private CoinGeckoApiClientImpl client;

    @Autowired
    private Assembler assembler;

    @GetMapping
    @ApiOperation(value = "....")
    @ResponseStatus(HttpStatus.OK)

    public MarketHistoryResponseDTO getCoinHistoryById(@ApiParam("date format = 01-09-2021") @RequestParam String date,
                                                       @RequestParam String cryptoId) {
        CoinHistoryById history =  client
                .getCoinHistoryById(cryptoId, date, false);
        return assembler.toMarketHistoryResponseDTO(history, date);
    }
}
