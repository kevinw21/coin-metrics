package com.sullivankw.CoinMetrics.controller;

import com.sullivankw.CoinMetrics.CoinMetricsApplication;
import com.sullivankw.CoinMetrics.dto.gecko.CoinMarkets;
import com.sullivankw.CoinMetrics.impl.CoinGeckoApiClientImpl;
import com.sullivankw.CoinMetrics.repo.CoinMarketRepo;
import io.restassured.RestAssured;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringJUnitConfig
@SpringBootTest(
		classes = CoinMetricsApplication.class,
		webEnvironment = RANDOM_PORT,
		properties = "spring.main.banner.mode=off"
)
public class CoinMarketControllerIntegrationTest {

	@MockBean
	private CoinGeckoApiClientImpl mockApiClient;

	@Autowired
	private CoinMarketRepo coinMarketRepo;

	@LocalServerPort
	private int serverPort;

	private static final String PATH = "/coinMetrics/currentMarket";

	@BeforeEach
	public void setup() {
		RestAssured.port = serverPort;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		mockApiCalls();
	}

	@AfterEach
	public void tearDown() {
		coinMarketRepo.deleteAll();
	}

	@Nested
	class getCurrentCoinMarketDataTests {
		@Test
		public void testGetCurrentCoinMarketData_withSaveDataOmitted_happyPath() {
			with().contentType(JSON)
					.expect().statusCode(200)
					.and().body("content", hasSize(equalTo(400)))
					.when().get(PATH);

			assertEquals(0, coinMarketRepo.findAll().spliterator().getExactSizeIfKnown());
		}

		@Test
		public void testGetCurrentCoinMarketData_withSaveDataFalse_happyPath() {
			with().contentType(JSON)
					.queryParam("saveData", false)
					.expect().statusCode(200)
					.and().body("content", hasSize(equalTo(400)))
					.when().get(PATH);

			assertEquals(0, coinMarketRepo.findAll().spliterator().getExactSizeIfKnown());
		}

		@Test
		public void testGetCurrentCoinMarketData_withSaveDataTrue_happyPath() {
			with().contentType(JSON)
					.queryParam("saveData", true)
					.expect().statusCode(200)
					.and().body("content", hasSize(equalTo(400)))
					.when().get(PATH);

			assertEquals(400, coinMarketRepo.findAll().spliterator().getExactSizeIfKnown());
		}
	}

	private void mockApiCalls() {
		List<CoinMarkets> first200 = createCoinMarketResponse(1, 200);
		List<CoinMarkets> next200 = createCoinMarketResponse(201, 400);

		doReturn(first200).when(mockApiClient).getCoinMarkets(200, 1);
		doReturn(next200).when(mockApiClient).getCoinMarkets(200, 2);
	}

	private List<CoinMarkets> createCoinMarketResponse(int start, int end) {
		List<CoinMarkets> markets = new ArrayList<>();
		long marketCap = end;
		for (int i = start; i <= end; i++) {
			CoinMarkets market = new CoinMarkets();
			market.setId(UUID.randomUUID().toString());
			market.setCurrentPrice(9.99d);
			market.setMarketCap(99);
			market.setMarketCapRank(i);
			market.setName("name " + i);
			market.setSymbol("symbol " + i);
			marketCap = marketCap - 1;
			markets.add(market);
		}
		return markets;
	}
}
