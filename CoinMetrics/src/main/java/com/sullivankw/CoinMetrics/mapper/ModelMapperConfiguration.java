package com.sullivankw.CoinMetrics.mapper;

import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.entity.CoinMarketEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true);

        modelMapper.createTypeMap(CoinMarkets.class, CoinMarketEntity.class)
                .setPostConverter(new CoinMarketsToCoinMarketEntityConverter());

        return modelMapper;
    }
}
