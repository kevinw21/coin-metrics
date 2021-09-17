package com.sullivankw.CoinMetrics.service;

import com.sullivankw.CoinMetrics.Assembler;
import com.sullivankw.CoinMetrics.dto.gecko.MarketChart;
import com.sullivankw.CoinMetrics.dto.MarketChartResponseWrapperDTO;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import com.sullivankw.CoinMetrics.repo.CoinMarketRepo;
import com.sullivankw.CoinMetrics.repo.MarketChartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketHistoryService {

    @Autowired
    private CoinGeckoApiClientImpl client;

    @Autowired
    private Assembler assembler;

    @Autowired
    private CoinMarketRepo coinMarketRepo;

    @Autowired
    private MarketChartRepo marketChartRepo;

//    public List<MarketChartResponseWrapperDTO> getCoinHistory(String coinGeckoId, int days) {
//        List<String> coinGeckoIds = coinMarketRepo.findAllByMarketCapBetweenMinAndMax(390l, 400l); //need to make these constants as a mpa
//        List<MarketChart> charts = new ArrayList<>(); //todo.md should be list of maps to i can stick the coinid
//        List<MarketChartResponseWrapperDTO> reponseWrapper = new ArrayList<>();
//        for (String id : coinGeckoIds) { // todo.md should i pass em in
//            //50 calls per min max
//            MarketChart marketChart = client
//                    .getCoinMarketChartById(id, "usd", days, "daily");
//            reponseWrapper.add(assembler.toMarketChartResponseWrapperDTO(id, marketChart));
//            //charts.add(marketChart);
//        }
//        return reponseWrapper;
////        MarketChart marketChart = client
////                .getCoinMarketChartById(coinGeckoId, "usd", days, "daily");
//    }


    public MarketChartResponseWrapperDTO getCoinHistory(String coinGeckoId, int days) {
        MarketChart marketChart = client
                .getCoinMarketChartById(coinGeckoId, "usd", days, "daily");
        MarketChartResponseWrapperDTO wrapperDTO = assembler
                .toMarketChartResponseWrapperDTO(coinGeckoId, marketChart);
        marketChartRepo.save(assembler.toMarketChartParentEntity(wrapperDTO));
        return wrapperDTO;

        //todo.md new idea, i could collect this data for the past 360 days for the top 400 coins today
        //i get the market cap but not the rank, i could simply calculate the ranking,
        //big processing tho and we are rate limited...

    }
}
