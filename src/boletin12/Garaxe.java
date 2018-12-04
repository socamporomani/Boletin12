/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin12;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author socamporomani
 */
public class Garaxe {
  int  numeroCoches;
  String matricula;
  boolean tempo=true;
  long TInicio = 0, TFin, tiempo;
  float precio;
  float pago;
  float devolto;
  int hora,min,seg;

public void comprobar(){
 int numeroPlazas=5;
    if(numeroPlazas>numeroCoches){
    JOptionPane.showMessageDialog(null,"PLAZAS DISPONIBLES");
matricula=JOptionPane.showInputDialog("PLAZAS DISPONIBLES","introduce la matricula para el registro");
time();
    }
    
    else
        JOptionPane.showMessageDialog(null,"OCUPADO");
    
}  
public void time(){
 
if(tempo){
  TInicio = System.currentTimeMillis(); 
      System.out.println(tempo);   
      salir();
  }

  else{
      TFin = System.currentTimeMillis(); 
  tiempo = TFin - TInicio;
  precio();
  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
}
}
public void salir(){
    int respuesta =JOptionPane.showConfirmDialog(null, "¿quieres salir?", "Ventana para salir", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION){
        JOptionPane.showMessageDialog(null,"Ahora saldrá el cobro");
        tempo=false;
        time();
    }
    else 
        salir();
}

  public void precio(){
    int tiempoSegundos;
  
    int tiempoHora;
  
    tiempoSegundos=(int) (tiempo/1000);
    tiempoHora=tiempoSegundos/3600;
    hora=(int) (tiempoSegundos/3600);
    min=(int) ((tiempoSegundos-(3600*hora))/60);
    seg=(int) (tiempoSegundos-((hora*3600)+(min*60)));
      
    if(tiempoHora<=3){
        precio=1.5f;
    }
    else
        precio=(float) (1.5 +(0.2*(tiempoHora-3)));
   do{ 
    pago=Float.parseFloat(JOptionPane.showInputDialog("Introduzca el dinero"));

 devolto=pago-precio;}
while (pago<precio);
factura();    
      System.out.println(precio);
    
  }
    public void factura(){
        JOptionPane.showMessageDialog(null,"FACTURA MATRICULA COCHE " + matricula +"\n "
                + "TEMPO "+ hora+"h "+min+"m "+seg+"s \n"
                        + "PRECIO " + precio + "\n"
                                + "CARTOS RECIBIDOS " + pago + "€ \n"
                                        + "CARTOS DEVOLTOS " +devolto +"€"
                );
    }
  
}
