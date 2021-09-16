package com.sullivankw.CoinMetrics.service;

import com.sullivankw.CoinMetrics.Assembler;
import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.dto.CoinMarketResponseDTO;
import com.sullivankw.CoinMetrics.entity.CoinMarketEntity;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import com.sullivankw.CoinMetrics.repo.CoinMarketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CoinMarketService {

    @Autowired
    private CoinGeckoApiClientImpl client;

    @Autowired
    private Assembler assembler;

    @Autowired
    private CoinMarketRepo coinMarketRepo;

    public List<CoinMarketResponseDTO> getAndSaveCoinMarketData() {
        List<CoinMarkets> coinMarkets =  getBasicCoinMarketData();
        List<CoinMarketEntity> entities = assembler.toCoinMarketEntityList(coinMarkets);
        coinMarketRepo.saveAll(entities);
        return assembler.toCoinMarketResponseDTO(entities);
    }

    public List<CoinMarkets> getBasicCoinMarketData() {
        List<CoinMarkets> first200 = client.getCoinMarkets(200, 1);
        List<CoinMarkets> next200 = client.getCoinMarkets(200, 2);
        return Stream.concat(first200.stream(), next200.stream())
                .collect(Collectors.toList());
    }
}
