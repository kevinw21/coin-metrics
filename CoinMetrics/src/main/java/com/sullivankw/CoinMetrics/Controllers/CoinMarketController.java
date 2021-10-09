package com.sullivankw.CoinMetrics.Controllers;

import com.sullivankw.CoinMetrics.dto.CoinMarketResponseDTO;
import com.sullivankw.CoinMetrics.service.CoinMarketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/currentMarket")
public class CoinMarketController {

    @Autowired
    private CoinMarketService coinMarketService;

    @ApiOperation(value = "Use this to get all latest market info for the top 400 in coin gecko. Optionally, the data can be persisted through param saveData")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CoinMarketResponseDTO> getCurrentCoinMarketData(@RequestParam(required = false) boolean saveData) {
        return coinMarketService.getCoinMarketData(saveData);
    }
}
