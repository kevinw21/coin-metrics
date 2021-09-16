package com.sullivankw.CoinMetrics.repo;

import com.sullivankw.CoinMetrics.entity.CoinMarketEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoinMarketRepo extends PagingAndSortingRepository<CoinMarketEntity, UUID> {

    CoinMarketEntity findBySymbol(String symbol);

    CoinMarketEntity findByName(String name);

    default List<String> findAllByMarketCapBetweenMinAndMax(long min, long max) {
        return findTop400ByMarketCapOnDate("13-09%", min, max);
    }

    @Query("select b.coinGeckoId from CoinMarketEntity b where b.date like :dateQuery " +
            "and b.marketCapRank <= :max " +
            "and b.marketCapRank > :min")
    List<String> findTop400ByMarketCapOnDate(@Param("dateQuery") String dateQuery,
                                             @Param("min") long min,
                                             @Param("max") long max);
}
