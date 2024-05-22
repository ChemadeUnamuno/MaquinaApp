package com.politecnicomalaga.hotelapp.model;
public class UtilidadCheck {

    //Método que dado un DNI numérico calcula la letra que le corresponde
    //Si el DNI que nos pasan es incorrecto (no numérico) devolvemos '-' como error
    public static char calculaLetraDNI(String DNI) {
        long numDNI;
        try {
            numDNI = Long.valueOf(DNI);
        } catch(NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            return '-';
        }


        //El string de letras es fijo y deberían de ir en este orden
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        //La letra correspondiente será el resto de la división del número del DNI entre las 23 posibilidades que hay
        return letras.charAt((int)(numDNI % letras.length()));

    }

    //Método que dado un DNI numérico calcula la letra que le corresponde
    //Si el DNI que nos pasan es incorrecto (no numérico) devolvemos '-' como error
    public static char getLetraDNI(String DNI) {
        long numDNI;
        try {
            numDNI = Long.valueOf(DNI);
        } catch(NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            return '-';
        }


        //El string de letras es fijo y deberían de ir en este orden
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        //La letra correspondiente será el resto de la división del número del DNI entre las 23 posibilidades que hay
        return (char)(letras.charAt((int)(numDNI % letras.length()))+1);

    }

    //Método para evaluar una ruta relativa en linux del siguiente tipo:
    //Si la ruta tiene la forma "./dir1/dir2/.../dirn/" es correcta para n subdirectorios
    //Siempre, siempre, el número de subdir está entre 1 y N
    public static boolean isRelativePath(String path) {

        if (path.length()<2) return false;
        if (path.charAt(0)!='.') return false;
        String pathWithoutDot = path.substring(1);
        boolean result = true;
        while(pathWithoutDot.length()>1) {
            int slashPos = pathWithoutDot.indexOf('/');
            if (slashPos!=0) return false;
            pathWithoutDot = pathWithoutDot.substring(1);
            slashPos = pathWithoutDot.indexOf('/');
            if (!pathWithoutDot.isEmpty() && (slashPos==-1 || slashPos==0)) return false;
            pathWithoutDot = pathWithoutDot.substring(slashPos);
        }
        return result;
    }

    //Alternativa al anterior
    public static boolean isSubPath(String path) {

        if (path.length()<1) return false;
        if (path.charAt(0)!='.') return false;
        String pathWithoutDot = path.substring(1);
        boolean result = true;
        while(pathWithoutDot.length()>1) {
            int slashPos = pathWithoutDot.indexOf('/');
            if (slashPos!=1) return false;
            pathWithoutDot = pathWithoutDot.substring(1);
            slashPos = pathWithoutDot.indexOf('/');
            if (slashPos==1) return false;
            pathWithoutDot = pathWithoutDot.substring(slashPos);
        }
        return result;
    }

}