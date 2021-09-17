package com.sullivankw.CoinMetrics.Controllers;

import com.sullivankw.CoinMetrics.Assembler;
import com.sullivankw.CoinMetrics.domain.Coins.CoinHistoryById;
import com.sullivankw.CoinMetrics.dto.MarketChartResponseWrapperDTO;
import com.sullivankw.CoinMetrics.dto.MarketHistoryResponseDTO;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import com.sullivankw.CoinMetrics.service.MarketHistoryService;
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

    @Autowired
    private MarketHistoryService marketHistoryService;

    @GetMapping("/givenDay")
    @ApiOperation(value = "Get price info for given day and token")
    @ResponseStatus(HttpStatus.OK)
    public MarketHistoryResponseDTO getCoinHistoryOnGivenDay(@ApiParam("date format = 01-09-2021") @RequestParam String date,
                                                             @RequestParam String cryptoId) {
        CoinHistoryById history =  client
                .getCoinHistoryById(cryptoId, date, false);
        return assembler.toMarketHistoryResponseDTO(history, date);
    }

    @GetMapping
    @ApiOperation(value = "Get the market cap and price for given token over some given number of days in the past")
    @ResponseStatus(HttpStatus.OK)
    public MarketChartResponseWrapperDTO getCoinHistoryForPastGivenDays(@RequestParam String cryptoId, int totalDays) {
        return marketHistoryService.getCoinHistory(cryptoId, totalDays);
    }

}
