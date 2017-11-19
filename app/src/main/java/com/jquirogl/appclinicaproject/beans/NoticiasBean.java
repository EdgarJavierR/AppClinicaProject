package com.jquirogl.appclinicaproject.beans;

import java.io.Serializable;

/**
 * Created by INTEL on 18/11/2017.
 */

public class NoticiasBean implements Serializable {

    private int codigo_noti;
    private String contenido_noti;
    private String foto_noti;
    private String fecha_noti;
    private String hora_noti;
    private String ubica_noti;

    public NoticiasBean() {
    }

    public NoticiasBean(int codigo_noti, String contenido_noti, String foto_noti, String fecha_noti, String hora_noti, String ubica_noti) {
        this.codigo_noti = codigo_noti;
        this.contenido_noti = contenido_noti;
        this.foto_noti = foto_noti;
        this.fecha_noti = fecha_noti;
        this.hora_noti = hora_noti;
        this.ubica_noti = ubica_noti;
    }

    public int getCodigo_noti() {
        return codigo_noti;
    }

    public void setCodigo_noti(int codigo_noti) {
        this.codigo_noti = codigo_noti;
    }

    public String getContenido_noti() {
        return contenido_noti;
    }

    public void setContenido_noti(String contenido_noti) {
        this.contenido_noti = contenido_noti;
    }

    public String getFoto_noti() {
        return foto_noti;
    }

    public void setFoto_noti(String foto_noti) {
        this.foto_noti = foto_noti;
    }

    public String getFecha_noti() {
        return fecha_noti;
    }

    public void setFecha_noti(String fecha_noti) {
        this.fecha_noti = fecha_noti;
    }

    public String getHora_noti() {
        return hora_noti;
    }

    public void setHora_noti(String hora_noti) {
        this.hora_noti = hora_noti;
    }

    public String getUbica_noti() {
        return ubica_noti;
    }

    public void setUbica_noti(String ubica_noti) {
        this.ubica_noti = ubica_noti;
    }
}
