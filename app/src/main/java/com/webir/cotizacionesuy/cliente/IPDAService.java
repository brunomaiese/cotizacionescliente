package com.webir.cotizacionesuy.cliente;

import com.webir.cotizacionesuy.dtypes.RespuestaCotizaciones;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface IPDAService {
    //String BASE_URL = "http://10.1.1.108:8080/pdaserver-web/rest/"; //asd
    String BASE_URL = "http://des20.correo.com.uy:8980/server-cotizaciones/";
    //String BASE_URL = "http://PDA-wildfly.correo.com.uy:8080/pdaserver-web/rest/";

    @GET("cotizaciones")
    public Call<RespuestaCotizaciones> prueba();
}
//