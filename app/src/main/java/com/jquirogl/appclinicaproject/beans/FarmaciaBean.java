package com.jquirogl.appclinicaproject.beans;

import java.io.Serializable;

/**
 * Created by INTEL on 12/11/2017.
 */

public class FarmaciaBean implements Serializable {

    private int codigo_farma;
    private String nombre_farma;
    private String tipo_farma;
    private String labo_farma;
    private Integer stock_farma;
    private Double precio_farma;

    public FarmaciaBean() {
    }

    public FarmaciaBean(int codigo_farma, String nombre_farma, String tipo_farma, String labo_farma, Integer stock_farma, Double precio_farma) {
        this.codigo_farma = codigo_farma;
        this.nombre_farma = nombre_farma;
        this.tipo_farma = tipo_farma;
        this.labo_farma = labo_farma;
        this.stock_farma = stock_farma;
        this.precio_farma = precio_farma;
    }

    public int getCodigo_farma() {
        return codigo_farma;
    }

    public void setCodigo_farma(int codigo_farma) {
        this.codigo_farma = codigo_farma;
    }

    public String getNombre_farma() {
        return nombre_farma;
    }

    public void setNombre_farma(String nombre_farma) {
        this.nombre_farma = nombre_farma;
    }

    public String getTipo_farma() {
        return tipo_farma;
    }

    public void setTipo_farma(String tipo_farma) {
        this.tipo_farma = tipo_farma;
    }

    public String getLabo_farma() {
        return labo_farma;
    }

    public void setLabo_farma(String labo_farma) {
        this.labo_farma = labo_farma;
    }

    public Integer getStock_farma() {
        return stock_farma;
    }

    public void setStock_farma(Integer stock_farma) {
        this.stock_farma = stock_farma;
    }

    public Double getPrecio_farma() {
        return precio_farma;
    }

    public void setPrecio_farma(Double precio_farma) {
        this.precio_farma = precio_farma;
    }

    public String getDisponibilidad(Integer stock_farma) {
        String dispo = "";
        if (stock_farma > 20) dispo = "DISPONIBLE";
        else if (stock_farma > 1) dispo = "LIMITADO";
        else dispo = "AGOTADO";
        return  dispo;
    }

}
