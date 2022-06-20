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
public class EtapaProyecto extends MedirTiempo implements Serializable{
    public EtapaProyecto(int tiempo){
        super(tiempo);
    }
    public EtapaProyecto(EtapaProyecto etapa){
        super(etapa.getTiempo());
    }
}
