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

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
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

	@BeforeEach
	public void setup() {
		RestAssured.port = serverPort;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@AfterEach
	public void tearDown() {
		coinMarketRepo.deleteAll();
	}

	@Nested
	class getTests {
		@Test
		public void testGetCurrentCoinMarketData_withSaveDataOmitted_happyPath() {
			with().contentType(JSON)
					.expect().statusCode(200)
					.and().body("error", is(equalTo("value")))
					.when().get("/currentMarket");
		}

		@Test
		public void testGetCurrentCoinMarketData_withSaveDataFalse_happyPath() {
			mockApiCalls();

			with().contentType(JSON)
					.queryParam("saveData", false)
					.expect().statusCode(200)
					.and().body("error", is(equalTo("value")))
					.when().get("/currentMarket");
		}

		@Test
		public void testGetCurrentCoinMarketData_withSaveDataTrue_happyPath() {
			with().contentType(JSON)
					.queryParam("saveData", true)
					.expect().statusCode(200)
					.and().body("error", is(equalTo("value")))
					.when().get("/currentMarket");
		}
	}

	private void mockApiCalls() {
		List<CoinMarkets> first200 = new ArrayList<>();
		List<CoinMarkets> next200 = new ArrayList<>();


		doReturn(first200).when(mockApiClient).getCoinMarkets(200, 1);
		doReturn(next200).when(mockApiClient).getCoinMarkets(200, 2);
	}
}
