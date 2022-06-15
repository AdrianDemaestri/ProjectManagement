package modelo;

import java.io.Serializable;

public class MedirTiempo implements Serializable {
    private Long tiempo;

    public MedirTiempo(Long tiempo){
        this.tiempo = tiempo;
    }

    public void cronometro(Cronometro cronometro) {
        cronometro.iniciar(this);
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }
}
