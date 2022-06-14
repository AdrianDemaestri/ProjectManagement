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
public class Desarrollo extends Crono implements Serializable{
    private Integer lineasCodigo;
    private Long tiempo;

    public Integer getLineasCodigo() {
        return lineasCodigo;
    }

    public void setLineasCodigo(Integer lineasCodigo) {
        this.lineasCodigo = lineasCodigo;
    }

    
}
