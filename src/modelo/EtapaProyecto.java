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
public class EtapaProyecto extends Crono implements Serializable{
    private Long tiempoEstimado;
    private Long tiempoReal;

    public Long getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Long tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Long getTiempoReal() {
        return tiempoReal;
    }

    public void setTiempoReal(Long tiempoReal) {
        this.tiempoReal = tiempoReal;
    }
    
}
