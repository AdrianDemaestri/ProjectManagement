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
public class Desarrollo extends MedirTiempo implements Serializable{
    private Integer lineasCodigo;

    public Desarrollo(Integer lineasCodigo, int tiempo){
        super(tiempo);
        this.lineasCodigo = lineasCodigo;
    }
    public Desarrollo(Desarrollo desarrollo){
        super(desarrollo.getTiempo());
        this.lineasCodigo = desarrollo.getLineasCodigo();
    }

    public Desarrollo(){}

    public Integer getLineasCodigo() {
        return lineasCodigo;
    }

    public void setLineasCodigo(Integer lineasCodigo) {
        this.lineasCodigo = lineasCodigo;
    }
}
