package com.sullivankw.CoinMetrics;

import com.sullivankw.CoinMetrics.domain.Coins.CoinHistoryById;
import com.sullivankw.CoinMetrics.dto.MarketHistoryResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Assembler {

    private ModelMapper modelMapper = new ModelMapper();

    public MarketHistoryResponseDTO toMarketHistoryResponseDTO(CoinHistoryById history, String date) {
        MarketHistoryResponseDTO dto = modelMapper.map(history, MarketHistoryResponseDTO.class);
        dto.setCurrentPrice(history.getMarketData().getCurrentPrice().get("usd"));
        dto.setDate(date);
        return dto;
    }
}
