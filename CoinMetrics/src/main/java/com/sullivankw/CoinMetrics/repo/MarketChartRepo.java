package com.sullivankw.CoinMetrics.repo;

import com.sullivankw.CoinMetrics.entity.MarketChartEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarketChartRepo extends PagingAndSortingRepository<MarketChartEntity, UUID> {


}
