package com.sullivankw.CoinMetrics.mapper;

import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.entity.CoinMarketEntity;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class CoinMarketsToCoinMarketEntityConverter implements Converter<CoinMarkets, CoinMarketEntity> {

    @Override
    public CoinMarketEntity convert(MappingContext<CoinMarkets, CoinMarketEntity> mappingContext) {
        CoinMarkets source = mappingContext.getSource();
        CoinMarketEntity destination = mappingContext.getDestination();
        destination.setCoinGeckoId(source.getId());
        return destination;
    }
}
