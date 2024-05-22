package com.politecnicomalaga.hotelapp.model;

public class Maquina2 {
    //Atributos
    //visibilidad tipo nombre;

    private String codMaquina;
    private float amperios;
    private float temperatura;
    private boolean encendida;
    private boolean encendida2;

    public enum Piloto {
        rojo,
        verde,
        amarillo,
        off
    }



    //Métodos

    public Maquina2(String codMaquina, float amperios, float temperatura) {
        this.codMaquina = codMaquina;
        this.amperios = amperios;
        this.temperatura = temperatura;
        this.encendida = false;
        this.encendida2 = false;
    }

    public String getCodMaquina() {
        return codMaquina;
    }

    public void setCodMaquina(String codMaquina) {
        this.codMaquina = codMaquina;
    }

    public float getAmperios() {
        return amperios;
    }

    public void setAmperios(float amperios) {
        this.amperios = amperios;
        if (detecterIncidencia()) {
            encendida = false;
            encendida2 = true;
        }
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        if (detecterIncidencia()) encendida=false;
        encendida2 = true;
    }

    public boolean isEncendida() {
        return encendida2;
    }

    /*public void setEncendida(boolean encendida) {
        if (!this.detecterIncidencia())
            this.encendida = encendida;
    }*/


    //visibilidad tiporetorno nombre(Tipo arg1, Tipo arg2...) {

    public boolean arrancar() {
        if (!this.detecterIncidencia()) {
            this.encendida = true;
            this.encendida2 = encendida;
            return true;
        } else {
            this.encendida = false;
            return false;
        }

    }

    public boolean comprobarTemperatura() {
        return (temperatura<85);
    }

    public boolean comprobarAmperaje() {
        return (amperios>=2 && amperios<=8);
    }

    public boolean apagar() {
        if (encendida) {
            encendida = false;
            encendida2 = encendida;
        }
        else
            return false;

        return true;
    }

    public boolean detecterIncidencia() {

        return (temperatura>84 || amperios<2 || amperios>8);
    }

    public Piloto getLuzPiloto() {
        if (encendida) {
            if (encendida2) return Piloto.verde;
            if (temperatura<55) return Piloto.verde;
            if (temperatura<85) return Piloto.amarillo;
            else return Piloto.rojo;
        } else {
            if (temperatura>=85 || encendida2) return Piloto.rojo;
            else return Piloto.off;
        }
    }
}

