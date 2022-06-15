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
    private Long tiempo;
    private Integer lineasErroneas;

    public Integer getLineasAgregadas() {
        return lineasAgregadas;
    }

    public void setLineasAgregadas(Integer lineasAgregadas) {
        this.lineasAgregadas = lineasAgregadas;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
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
