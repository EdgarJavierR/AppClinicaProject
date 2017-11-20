package com.jquirogl.appclinicaproject.beans;

/**
 * Created by cayomt56 on 11/19/2017.
 */

public class HistorialBean {

    private int codigo_historial;
    private String nombre_historial;
    private String fecha_historial;
    private String nombre_doctor;
    private String resumen_historial;
    private Double costo_historial;
    private int numero_boleta;
    private String metodo_pago;



    public HistorialBean(int codigo_historial, String nombre_historial, String fecha_historial, String nombre_doctor, String resumen_historial, Double costo_historial, int numero_boleta, String metodo_pago) {
        this.codigo_historial = codigo_historial;
        this.nombre_historial = nombre_historial;
        this.fecha_historial = fecha_historial;

        this.nombre_doctor = nombre_doctor;
        this.resumen_historial = resumen_historial;
        this.costo_historial = costo_historial;
        this.numero_boleta = numero_boleta;
        this.metodo_pago = metodo_pago;
    }

    public String getFecha_historial() {
        return fecha_historial;
    }

    public void setFecha_historial(String fecha_historial) {
        this.fecha_historial = fecha_historial;
    }

    public int getCodigo_historial() {
        return codigo_historial;
    }

    public void setCodigo_historial(int codigo_historial) {
        this.codigo_historial = codigo_historial;
    }

    public String getNombre_historial() {
        return nombre_historial;
    }

    public void setNombre_historial(String nombre_historial) {
        this.nombre_historial = nombre_historial;
    }

    public String getNombre_doctor() {
        return nombre_doctor;
    }

    public void setNombre_doctor(String nombre_doctor) {
        this.nombre_doctor = nombre_doctor;
    }

    public String getResumen_historial() {
        return resumen_historial;
    }

    public void setResumen_historial(String resumen_historial) {
        this.resumen_historial = resumen_historial;
    }

    public Double getCosto_historial() {
        return costo_historial;
    }

    public void setCosto_historial(Double costo_historial) {
        this.costo_historial = costo_historial;
    }

    public int getNumero_boleta() {
        return numero_boleta;
    }

    public void setNumero_boleta(int numero_boleta) {
        this.numero_boleta = numero_boleta;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
