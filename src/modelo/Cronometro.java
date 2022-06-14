package modelo;

import java.time.LocalTime;

public class Cronometro {
    private long horaInicio;
    private long horaFin;
    private Crono objeto;

     public void iniciar(Crono obj){
         if (objeto != null)
            this.objeto = obj;
         this.horaInicio = Tiempo.pasarTimeALong(LocalTime.now());
     }
     public void finalizar(){
        this.horaFin = Tiempo.pasarTimeALong(LocalTime.now());
        objeto.setTiempo(horaFin - horaInicio);
     }
    public Crono getObjeto() {
        return objeto;
    }
}
