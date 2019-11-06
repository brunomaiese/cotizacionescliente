package com.webir.cotizacionesuy.cliente;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PDAService {
    public static IPDAService getPDAService() {

        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.MINUTES).connectTimeout(1, TimeUnit.MINUTES)
                .build();
        return new Retrofit.Builder().
                baseUrl(IPDAService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).client(client).build().create(IPDAService.class);
    }


}
