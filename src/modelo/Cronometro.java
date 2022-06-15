package modelo;

import java.time.LocalTime;

public class Cronometro {
    private Long horaInicio;
    private Long horaFin;
    private MedirTiempo objeto;

    public Cronometro(Long horaInicio, Long horaFin, MedirTiempo objeto){
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.objeto = objeto;
    }
     public void iniciar(MedirTiempo obj){
         if (objeto != null)
            this.objeto = obj;
         this.horaInicio = Tiempo.pasarTimeALong(LocalTime.now());
     }
     public void finalizar(){
        this.horaFin = Tiempo.pasarTimeALong(LocalTime.now());
        objeto.setTiempo(horaFin - horaInicio);
     }
    public MedirTiempo getObjeto() {
        return objeto;
    }
}
