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
    private JTextField jTextField;

    public Cronometro(MedirTiempo objeto){
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.objeto = objeto;
        time = new Timer(1000,acciones);
    }
    
    
    
    public Cronometro(int horas, int minutos, int segundos, MedirTiempo objeto){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.objeto = objeto;
        time = new Timer(1000,acciones);
    }
    
    private void establecerTiempo(){
        if (!jTextField.getText().equals("")) {
            horas = Tiempo.convertirStringATime(jTextField.getText()).getHour();
            minutos = Tiempo.convertirStringATime(jTextField.getText()).getMinute();
            segundos = Tiempo.convertirStringATime(jTextField.getText()).getSecond();
        }
    }
    
    public void iniciar(MedirTiempo obj, JTextField tiempo){
        jTextField = tiempo;
        establecerTiempo();
        if(this.objeto == obj){
           play();
        }
        if(this.objeto != obj) {
            this.objeto.setTiempo(Tiempo.pasarTimeASegundos(LocalTime.of(horas,minutos,segundos)));
            stop();
            play();
        }
     }
    
    public void play(){
        establecerTiempo();
        time.start();
    }
    
    private ActionListener acciones = new ActionListener() {
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
                if(horas == 23)
                    horas = 0;
                
                actualizarTiempo();
            }
        };
    
    private void actualizarTiempo(){
        
        String cadena = (horas <= 9 ? "0":"") + horas +":"+ (minutos <= 9 ? "0":"") + minutos +":"+ (segundos <= 9 ? "0":"") + segundos;
        jTextField.setText(cadena);
    }
    
    public void display(){
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
