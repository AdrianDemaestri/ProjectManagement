package modelo;

import java.io.Serializable;

public class Crono implements Serializable {
    private Long tiempo;
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
