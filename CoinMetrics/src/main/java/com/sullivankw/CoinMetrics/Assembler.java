package com.sullivankw.CoinMetrics;

import com.sullivankw.CoinMetrics.domain.Coins.CoinHistoryById;
import com.sullivankw.CoinMetrics.dto.gecko.MarketChart;
import com.sullivankw.CoinMetrics.dto.MarketChartResponseDTO;
import com.sullivankw.CoinMetrics.dto.MarketChartResponseWrapperDTO;
import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.dto.CoinMarketResponseDTO;
import com.sullivankw.CoinMetrics.dto.MarketHistoryResponseDTO;
import com.sullivankw.CoinMetrics.entity.CoinMarketEntity;
import com.sullivankw.CoinMetrics.entity.MarketChartEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Assembler {

    @Autowired
    private ModelMapper modelMapper;

    public MarketHistoryResponseDTO toMarketHistoryResponseDTO(CoinHistoryById history, String date) {
        MarketHistoryResponseDTO dto = modelMapper.map(history, MarketHistoryResponseDTO.class);
        dto.setCurrentPrice(history.getMarketData().getCurrentPrice().get("usd"));
        dto.setDate(date);
        return dto;
    }

    public List<CoinMarketResponseDTO> toCoinMarketResponseDTO(List<CoinMarketEntity> coinMarketEntities) {
        return coinMarketEntities.stream()
                .map(this::toCoinMarketResponseDTO)
                .collect(Collectors.toList());
    }

    public MarketChartResponseWrapperDTO toMarketChartResponseWrapperDTO(String coinGeckoId,
                                                                         MarketChart marketChart) {
        List<MarketChartResponseDTO> marketChartResponseDTOs = new ArrayList<>();
        // final item in array is current
        //should i reverse it?
        for (int i = 0; i < marketChart.getPrices().size(); i ++) {
            MarketChartResponseDTO responseDTO = new MarketChartResponseDTO();
            setTimestamps(marketChart, i, responseDTO);
            responseDTO.setPrice(Double.valueOf(marketChart.getPrices().get(i).get(1)));
            responseDTO.setMarketCap(Double.valueOf(marketChart.getMarketCaps().get(i).get(1)));
            marketChartResponseDTOs.add(responseDTO);
        }
        MarketChartResponseWrapperDTO wrapperDTO = new MarketChartResponseWrapperDTO();
        wrapperDTO.setCoinGeckoId(coinGeckoId);
        Collections.reverse(marketChartResponseDTOs);
        wrapperDTO.setMarketData(marketChartResponseDTOs); //make most recent

        return wrapperDTO;
    }

    public List<CoinMarketEntity> toCoinMarketEntityList(List<CoinMarkets> coinMarkets) {
        return coinMarkets.stream()
                .map(this::toCoinMarketEntity)
                .collect(Collectors.toList());
    }

    public List<MarketChartEntity> toMarketChartEntityList(MarketChartResponseWrapperDTO wrapperDTO) {
        return wrapperDTO.getMarketData().stream()
                .map(item -> toMarketChartEntity(wrapperDTO.getCoinGeckoId(), item))
                .collect(Collectors.toList());
    }

    private MarketChartEntity toMarketChartEntity(String coinGeckoId, MarketChartResponseDTO item) {
        MarketChartEntity entity = modelMapper.map(item, MarketChartEntity.class);
        entity.setCoinGeckoId(coinGeckoId);
        return entity;
    }

    private CoinMarketEntity toCoinMarketEntity(CoinMarkets coin) {
        return modelMapper.map(coin, CoinMarketEntity.class);
    }

    private CoinMarketResponseDTO toCoinMarketResponseDTO(CoinMarketEntity entity) {
        return modelMapper.map(entity, CoinMarketResponseDTO.class);
    }

    private void setTimestamps(MarketChart marketChart, int position, MarketChartResponseDTO responseDTO) {
        long unix = Long.valueOf(marketChart.getPrices().get(position).get(0));
        responseDTO.setUnix(unix);
        responseDTO.setDate(DateUtils.fromUnix(unix));
    }
}
