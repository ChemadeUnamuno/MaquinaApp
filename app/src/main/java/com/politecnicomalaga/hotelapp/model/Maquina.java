package com.politecnicomalaga.hotelapp.model;

public class Maquina {

    private String codMaquina;
    private float temperatura;
    private float amperaje;
    private boolean encendida;

    public Piloto getLuzPiloto() {
        if(amperaje<2 || amperaje>8) return Piloto.apagada;
        if(temperatura<=55) return Piloto.verde;
        if(temperatura>=56 && temperatura<=84) return Piloto.amarillo;
        return Piloto.rojo;
    }

    public void arrancar() {
        if(this.getLuzPiloto()!= Piloto.apagada) {
            this.setEncendida(true);
        }
    }

    public void apagar() {
        if(this.isEncendida()) {
            this.setEncendida(false);
        }
    }

    public enum Piloto {
        apagada,
        rojo,
        amarillo,
        verde
    }

    public Maquina(String codMaquina, float temperatura, float amperaje) {
        this.codMaquina = codMaquina;
        this.temperatura = temperatura;
        this.amperaje = amperaje;
        this.encendida = false;
    }

    public String getCodMaquina() {
        return codMaquina;
    }

    public void setCodMaquina(String codMaquina) {
        this.codMaquina = codMaquina;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getAmperios() {
        return amperaje;
    }

    public void setAmperios(float amperaje) {
        this.amperaje = amperaje;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }
}
