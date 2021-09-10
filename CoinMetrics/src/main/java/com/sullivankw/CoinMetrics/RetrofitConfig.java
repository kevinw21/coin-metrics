package com.sullivankw.CoinMetrics;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    CoinGeckoApiService configureCoinGeckoApiService(final Retrofit.Builder builder) {
        Retrofit retrofit = builder
                .baseUrl("https://api.coingecko.com/api/v3/")
                .build();
                return retrofit.create(CoinGeckoApiService.class);
    }

    @Bean
    Retrofit.Builder configureRetrofitBuilder(final ObjectMapper objectMapper) {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(httpClient.build());
    }
}
