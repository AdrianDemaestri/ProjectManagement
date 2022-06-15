package modelo;

import java.io.Serializable;
import java.time.LocalTime;

public class Tiempo implements Serializable {

    public static LocalTime pasarLongATime(Long tiempoEnNano){
        Double nanosegundos, segundos, minutos, horas, resto;
        // Calculamos el tiempo total en hs y el resto lo usamos para caluclar los min
        resto = tiempoEnNano % (double)(3600000000000L);
        horas = tiempoEnNano - resto;
        horas = horas / (double)3600000000000L;
        // Caclucalos los minutos con la parte entera y con el resto calculamos los seg
        minutos = resto;
        resto = resto % (double)60000000000L;
        minutos = minutos - resto;
        minutos = minutos / (double)60000000000L;
        // Calculamos los seg con la parte entera y con el resto calculamos los nanoseg
        segundos = resto;
        resto = resto % (double)1000000000L;
        segundos = segundos - resto;
        segundos = segundos / (double)1000000000L;

        int hs, mn, sg, nsg;
        hs = horas.intValue();
        mn = minutos.intValue();
        sg = segundos.intValue();
        nsg = resto.intValue();
        LocalTime time = LocalTime.of(hs, mn, sg, nsg);
        return time;
    }
    public static Long pasarTimeALong(LocalTime time){
        return (long)(time.getHour()*3600000000000L) + (time.getMinute()*60000000000L) + (time.getSecond()*1000000000L) + time.getNano();
    }
    public static Long sumarTimes(Long time1, Long time2){
        return (time1 + time2);
    }
    public static Long restarTime(Long tiempoFinal, Long tiempoInicial){
        if(tiempoFinal >= tiempoInicial)
            return (tiempoFinal-tiempoInicial);
        else
            return ((86400000000000L- tiempoInicial) + tiempoFinal);
    }
}