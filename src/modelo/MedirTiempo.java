package modelo;

import javax.swing.*;
import java.io.Serializable;

public class MedirTiempo implements Serializable {
    private int tiempo;

    public MedirTiempo(int tiempo){
        this.tiempo = tiempo;
    }
    public MedirTiempo(){
        this.tiempo = 0;
    }

    public void cronometro(Cronometro cronometro, JTextField tiempo) {
        cronometro.iniciar(this,tiempo);
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
