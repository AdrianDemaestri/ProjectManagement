package modelo;

import java.io.Serializable;
import java.time.LocalTime;

public class Tiempo implements Serializable {

    public static LocalTime pasarSegundosATime(int tiempo){
        int segundos, minutos, horas, resto;
        // Calculamos el tiempo total en hs y el resto lo usamos para caluclar los min
        resto = tiempo % 3600;
        horas = tiempo - resto;
        horas = horas / 3600;
        // Caclucalos los minutos con la parte entera y con el resto calculamos los seg
        minutos = resto;
        resto = resto % 60;
        minutos = minutos - resto;
        minutos = minutos / 60;
        // Calculamos los seg con la parte entera
        segundos = resto;
        LocalTime time = LocalTime.of(horas,minutos,segundos);
        return time;
    }
    public static int pasarTimeASegundos(LocalTime time){
        return (time.getHour()*3600) + (time.getMinute()*60) + time.getSecond();
    }
    public static int sumarTimes(int time1, int time2){
        return (time1 + time2);
    }
    public static int restarTimes(int tiempoFinal, int tiempoInicial){
        if(tiempoFinal >= tiempoInicial)
            return (tiempoFinal-tiempoInicial);
        else
            return ((86400 - tiempoInicial) + tiempoFinal);
    }
    public static LocalTime convertirStringATime(String textField){
        String[] tiempo = textField.split(":");
        return LocalTime.of(Integer.valueOf(tiempo[0]),Integer.valueOf(tiempo[1]),Integer.valueOf(tiempo[2]));
    }
}