package com.sullivankw.CoinMetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoinMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinMetricsApplication.class, args);
	}
}
