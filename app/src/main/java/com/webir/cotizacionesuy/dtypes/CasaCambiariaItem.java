package com.webir.cotizacionesuy.dtypes;


import java.io.Serializable;

public class CasaCambiariaItem implements Serializable {

    private String nombre;
    private double distancia;
    private double latitud;
    private double longitud;
    private double dolarCompra;
    private double dolarVenta;
    private double euroCompra;
    private double euroVenta;
    private double argentinoCompra;
    private double argentinoVenta;
    private double realCompra;
    private double realVenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getDolarCompra() {
        return dolarCompra;
    }

    public void setDolarCompra(double dolarCompra) {
        this.dolarCompra = dolarCompra;
    }

    public double getDolarVenta() {
        return dolarVenta;
    }

    public void setDolarVenta(double dolarVenta) {
        this.dolarVenta = dolarVenta;
    }

    public double getEuroCompra() {
        return euroCompra;
    }

    public void setEuroCompra(double euroCompra) {
        this.euroCompra = euroCompra;
    }

    public double getEuroVenta() {
        return euroVenta;
    }

    public void setEuroVenta(double euroVenta) {
        this.euroVenta = euroVenta;
    }

    public double getArgentinoCompra() {
        return argentinoCompra;
    }

    public void setArgentinoCompra(double argentinoCompra) {
        this.argentinoCompra = argentinoCompra;
    }

    public double getArgentinoVenta() {
        return argentinoVenta;
    }

    public void setArgentinoVenta(double argentinoVenta) {
        this.argentinoVenta = argentinoVenta;
    }

    public double getRealCompra() {
        return realCompra;
    }

    public void setRealCompra(double realCompra) {
        this.realCompra = realCompra;
    }

    public double getRealVenta() {
        return realVenta;
    }

    public void setRealVenta(double realVenta) {
        this.realVenta = realVenta;
    }
}
