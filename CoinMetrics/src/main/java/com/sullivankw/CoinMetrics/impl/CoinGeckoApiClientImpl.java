package com.sullivankw.CoinMetrics.impl;

import com.sullivankw.CoinMetrics.CoinGeckoApi;
import com.sullivankw.CoinMetrics.CoinGeckoApiClient;
import com.sullivankw.CoinMetrics.CoinGeckoApiService;
import com.sullivankw.CoinMetrics.domain.Coins.*;
import com.sullivankw.CoinMetrics.domain.Events.EventCountries;
import com.sullivankw.CoinMetrics.domain.Events.EventTypes;
import com.sullivankw.CoinMetrics.domain.Events.Events;
import com.sullivankw.CoinMetrics.domain.ExchangeRates.ExchangeRates;
import com.sullivankw.CoinMetrics.domain.Exchanges.ExchangeById;
import com.sullivankw.CoinMetrics.domain.Exchanges.Exchanges;
import com.sullivankw.CoinMetrics.domain.Exchanges.ExchangesList;
import com.sullivankw.CoinMetrics.domain.Exchanges.ExchangesTickersById;
import com.sullivankw.CoinMetrics.domain.Global.Global;
import com.sullivankw.CoinMetrics.domain.Ping;
import com.sullivankw.CoinMetrics.domain.Status.StatusUpdates;
import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.dto.gecko.MarketChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoinGeckoApiClientImpl implements CoinGeckoApiClient{

    @Autowired
    private CoinGeckoApiService coinGeckoApiService;

    @Autowired
    private CoinGeckoApi coinGeckoApi;


    @Override
    public Ping ping(){
        return coinGeckoApi.executeSync(coinGeckoApiService.ping());
    }

    @Override
    public Map<String, Map<String, Double>> getPrice(String ids, String vsCurrencies){
        return getPrice(ids, vsCurrencies, false, false, false,  false);
    }

    @Override
    public Map<String, Map<String, Double>> getPrice(String ids, String vsCurrencies, boolean includeMarketCap, boolean include24hrVol, boolean include24hrChange, boolean includeLastUpdatedAt) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getPrice(ids, vsCurrencies,includeMarketCap, include24hrVol, include24hrChange, includeLastUpdatedAt));
    }

    @Override
    public Map<String, Map<String, Double>> getTokenPrice(String id, String contractAddress, String vsCurrencies) {
        return getTokenPrice(id,contractAddress,vsCurrencies,false,false,false,false);
    }

    @Override
    public Map<String, Map<String, Double>> getTokenPrice(String id, String contractAddress, String vsCurrencies, boolean includeMarketCap, boolean include24hrVol, boolean include24hrChange, boolean includeLastUpdatedAt) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getTokenPrice(id,contractAddress,vsCurrencies,includeMarketCap,include24hrVol,include24hrChange,includeLastUpdatedAt));
    }

    @Override
    public List<String> getSupportedVsCurrencies(){
        return coinGeckoApi.executeSync(coinGeckoApiService.getSupportedVsCurrencies());
    }

    @Override
    public List<CoinList> getCoinList() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinList());
    }

    @Override
    public List<CoinMarkets> getCoinMarkets(String vsCurrency) {
        return getCoinMarkets(vsCurrency,null,null,200,1,false,null);
    }

    @Override
    public List<CoinMarkets> getCoinMarkets(int items, int startingPage) {
        return getCoinMarkets("usd",null,null, items, startingPage,false,null);
    }

    @Override
    public List<CoinMarkets> getCoinMarkets(String vsCurrency, String ids, String order, Integer perPage, Integer page, boolean sparkline, String priceChangePercentage) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinMarkets(vsCurrency,ids,order,perPage,page,sparkline,priceChangePercentage));
    }

    @Override
    public CoinFullData getCoinById(String id) {
        return getCoinById(id,true,true,true,true,true,false);
    }

    @Override
    public CoinFullData getCoinById(String id, boolean localization, boolean tickers, boolean marketData, boolean communityData, boolean developerData, boolean sparkline) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinById(id,localization,tickers,marketData,communityData,developerData,sparkline));
    }

    @Override
    public CoinTickerById getCoinTickerById(String id) {
        return getCoinTickerById(id,null,null,null);
    }

    @Override
    public CoinTickerById getCoinTickerById(String id, String exchangeIds, Integer page, String order) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinTickerById(id,exchangeIds,page,order));
    }

    @Override
    public CoinHistoryById getCoinHistoryById(String id, String date) {
        return getCoinHistoryById(id,date,true);
    }

    @Override
    public CoinHistoryById getCoinHistoryById(String id, String data, boolean localization) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinHistoryById(id,data,localization));
    }

    @Override
    public MarketChart getCoinMarketChartById(String id, String vsCurrency, Integer days, String interval) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinMarketChartById(id, vsCurrency, days, interval));
    }

    @Override
    public MarketChart getCoinMarketChartRangeById(String id, String vsCurrency, String from, String to) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinMarketChartRangeById(id,vsCurrency,from,to));
    }

    @Override
    public StatusUpdates getCoinStatusUpdateById(String id) {
        return getCoinStatusUpdateById(id,null,null);
    }

    @Override
    public StatusUpdates getCoinStatusUpdateById(String id, Integer perPage, Integer page) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinStatusUpdateById(id,perPage,page));
    }

    @Override
    public CoinFullData getCoinInfoByContractAddress(String id, String contractAddress) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getCoinInfoByContractAddress(id,contractAddress));
    }

    @Override
    public List<Exchanges> getExchanges() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchanges());
    }

    @Override
    public List<ExchangesList> getExchangesList() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchangesList());
    }

    @Override
    public ExchangeById getExchangesById(String id) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchangesById(id));
    }

    @Override
    public ExchangesTickersById getExchangesTickersById(String id) {
        return getExchangesTickersById(id,null,null,null);
    }

    @Override
    public ExchangesTickersById getExchangesTickersById(String id, String coinIds, Integer page, String order) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchangesTickersById(id,coinIds,page,order));
    }

    @Override
    public StatusUpdates getExchangesStatusUpdatesById(String id) {
        return getExchangesStatusUpdatesById(id,null,null);
    }

    @Override
    public StatusUpdates getExchangesStatusUpdatesById(String id, Integer perPage, Integer page) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchangesStatusUpdatesById(id,perPage,page));
    }

    @Override
    public List<List<String>> getExchangesVolumeChart(String id, Integer days) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchangesVolumeChart(id,days));
    }

    @Override
    public StatusUpdates getStatusUpdates() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getStatusUpdates());
    }

    @Override
    public StatusUpdates getStatusUpdates(String category, String projectType, Integer perPage, Integer page) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getStatusUpdates(category, projectType,perPage,page));
    }

    @Override
    public Events getEvents() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getEvents());
    }

    @Override
    public Events getEvents(String countryCode, String type, Integer page, boolean upcomingEventsOnly, String fromDate, String toDate) {
        return coinGeckoApi.executeSync(coinGeckoApiService.getEvents(countryCode,type,page,upcomingEventsOnly,fromDate,toDate));
    }

    @Override
    public EventCountries getEventsCountries() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getEventsCountries());
    }

    @Override
    public EventTypes getEventsTypes() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getEventsTypes());
    }

    @Override
    public ExchangeRates getExchangeRates() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getExchangeRates());
    }

    @Override
    public Global getGlobal() {
        return coinGeckoApi.executeSync(coinGeckoApiService.getGlobal());
    }
}
