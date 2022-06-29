/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author INFORMATICA2
 */
public class Correccion extends MedirTiempo implements Serializable {
    private Integer lineasAgregadas;
    private Integer lineasErroneas;

    public Correccion(Integer lineasAgregadas, Integer lineasErroneas, int tiempo){
        super(tiempo);
        this.lineasAgregadas = lineasAgregadas;
        this.lineasErroneas = lineasErroneas;
    }
    public Correccion(Correccion correccion){
        super(correccion.getTiempo());
        this.lineasAgregadas = correccion.getLineasAgregadas();
        this.lineasErroneas = correccion.getLineasErroneas();
    }

    public Correccion(){}

    public Integer getLineasAgregadas() {
        return lineasAgregadas;
    }

    public void setLineasAgregadas(Integer lineasAgregadas) {
        this.lineasAgregadas = lineasAgregadas;
    }

    public Integer getLineasErroneas() {
        return lineasErroneas;
    }

    public void setLineasErroneas(Integer lineasErroneas) {
        this.lineasErroneas = lineasErroneas;
    }

    public int LineasCodigo(){
        return getLineasAgregadas() - getLineasErroneas();
    }
}
