package modelo;

import java.util.ArrayList;

public interface Informe {


//    public void mostrarResumen();
//    public void mostrarEstadisticas();

    public int lineasCodigoTotal();
    public Long tiempoTotal();
    public Long tiempoDesarrollo();
    public Long tiempoCorrecciones();
    public float lineaCodigoTotalPorHora();
    public float lineaCodigoErroneasCada100Lineas();
    public float porcentajeCodigoErroneo();
}
