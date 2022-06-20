package modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class Cronometro extends javax.swing.JFrame{
    Timer time;
    private int horas;
    private int minutos;
    private int segundos;
    private MedirTiempo objeto;

    public Cronometro(MedirTiempo objeto){
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.objeto = objeto;
    }
    public Cronometro(int horas, int minutos, int segundos, MedirTiempo objeto){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.objeto = objeto;
    }
     public void iniciar(MedirTiempo obj, JTextField tiempo){
         if(this.objeto == obj){
            play(tiempo);
         }
         if(this.objeto != obj) {
             this.objeto.setTiempo(Tiempo.pasarTimeASegundos(LocalTime.of(horas,minutos,segundos)));
             stop();
             play(tiempo);
         }
     }
     public void play(JTextField tiempo){
         ActionListener acciones = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 segundos++;
                 if(segundos == 59){
                     minutos++;
                     segundos = 0;
                 }
                 if(minutos == 59){
                     horas++;
                     minutos = 0;
                 }
                 if(horas == 23){
                     horas = 0;
                 }
                 actualizarTiempo(tiempo);
             }
         };
         time = new Timer(1000,acciones);
     }
    private void actualizarTiempo(JTextField tiempo){
        String cadena = (horas <= 9 ? "0":"") + horas +":"+ (minutos <= 9 ? "0":"") + minutos +":"+ (segundos <= 9 ? "0":"") + segundos;
        tiempo.setText(cadena);
    }
     public void display(Timer time){
        if(time.isRunning())
            time.stop();
     }
     public void stop(){
         if(time.isRunning())
             time.stop();
         this.objeto.setTiempo(Tiempo.pasarTimeASegundos(LocalTime.of(horas,minutos,segundos)));
         horas = 0;
         minutos = 0;
         segundos = 0;
     }
     public int getHoras(){
        return this.horas;
     }
     public int getMinutos(){
         return this.minutos;
     }
     public int getSegundos(){
        return  this.segundos;
     }
    public MedirTiempo getObjeto() {
        return objeto;
    }
}
