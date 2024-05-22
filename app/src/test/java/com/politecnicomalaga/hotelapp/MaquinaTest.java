package com.politecnicomalaga.hotelapp;
import org.junit.Test;

import static org.junit.Assert.*;

import com.politecnicomalaga.hotelapp.model.Maquina;

public class MaquinaTest {
    @Test
    public void test() {


        //Metodo AAA: Arange, Act, Assert -> Crea, Actua, Asegura que..

        //Arrange
        Maquina miMaquina;
        String codigo = "12";
        float temp= 20f;
        float amperaje = 3.0f;

        //Arrange and Act
        miMaquina = new Maquina(codigo,temp, amperaje);

        //Act
        String codAlmacenado = miMaquina.getCodMaquina();
        float tempAlmacenada = miMaquina.getTemperatura();
        float ampAlmacenado = miMaquina.getAmperios();

        //Assert

        assertEquals(codigo, codAlmacenado);
        assertTrue(temp == tempAlmacenada);
        assertTrue(amperaje == ampAlmacenado);

    }

}
