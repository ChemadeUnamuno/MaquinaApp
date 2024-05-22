package com.politecnicomalaga.hotelapp;
import org.junit.Test;
import static org.junit.Assert.*;

import com.politecnicomalaga.hotelapp.model.UtilidadCheck;


public class UtilidadCheckTest {

    static String dni1 = "44695987";
    static String dni2 = "23345567";
    static String dni3 = "23345578";
    static String ruta1 = "./dir1/dir2/.../dirn/";
    static String ruta2 = "./dir1/dir2/dirn/";
    static String ruta3 = "./dir1/.../dirn/";
    static char H = 'H';
    static char S = 'S';
    static char A = 'A';
    @Test
    public void testCalcularLetra() {
        assertEquals(H, UtilidadCheck.calculaLetraDNI(dni1));
        assertEquals(S, UtilidadCheck.calculaLetraDNI(dni2));
        assertEquals(A, UtilidadCheck.calculaLetraDNI(dni3));
    }

    @Test
    public void testGetLetra() {
        assertTrue(UtilidadCheck.getLetraDNI(dni1) == H);
    }

    @Test
    public void testIsRelativePath() {
        assertTrue(UtilidadCheck.isRelativePath(ruta1));
        assertTrue(UtilidadCheck.isRelativePath(ruta2));
        assertTrue(UtilidadCheck.isRelativePath(ruta3));
    }

    @Test
    public void testIsSubPath() {
        assertTrue(UtilidadCheck.isSubPath(ruta1));
    }

}
