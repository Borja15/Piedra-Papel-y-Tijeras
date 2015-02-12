
package proyectopptijeras;


import java.util.Random;
import javax.swing.JOptionPane;





/**
 * Clase TijerasPapelPiedra
    Esta clase funcionara con variables y métodos para desarrollar el popular juego de Piedra,Papel y Tijeras.
    EL numero de partidas realizadas,un color elegido,un nombre para el jugador y seleccionar los elementos
    de juego Piedra,Papel y Tijeras.
    El juego sera para un jugador,siendo posible desarrollar el resultado rival de la clase aleatoriamente.
 * @author Borja Andrades
 */
public class TijerasPapelPiedra {

    /**
    Constantes PIEDRA,PAPEL Y TIJERAS que representan los elementos del juego
    Cada uno asignado a un int.
    */
    private final int PIEDRA = 0;
    private final int TIJERA = 1;
    private final int PAPEL = 2;
    /**
    Variables que almacenan la puntuacion inicial del jugador y del jugador Rival(La propia clase)
    */
    private int puntuacion = 0;
    private int puntuacionRival = 0;
    /**
    Variable que almacenara en un String el movimiento del jugador,el del rival y el resultado final indicando
    cual mano es la ganadora
    */
    private String ganador;
    /**
    Variable almacenara el movimiento del Rival
    */
    private int movimiento;
    /**
    Variables que indican el estado de la mano piedra,papel o tijeras,es decir,la mano cerrada o abierta 
    enseñando piedra,papel o tijeras
    */
    private boolean estadopiedra,estadotijera,estadopapel;
    /**
    Variables para la selección del color
    */
    private  int color;
    private String colorFinal,rondaFinal;
    /**
    Variables para la selección de partidas
    */
    private int partidas,numPartidas;
    /**
    Variable que guardara el nombre del Jugador
    */
    private String jugador;
    
    /**
     * 
    Método constructor de la clase TijerasPapelPiedra
    Inicialmente el estado de las manos sera 'false' (cerradas)
    Por defecto el numero de partidas sera 3
    */
    public TijerasPapelPiedra(){ 
        estadopiedra = false;
        estadotijera = false;
        estadopapel = false;
        numPartidas = 3;  
    }
    /**
    Método para llamar a Piedra
    * 
    * @return Retorna la constante PIEDRA
    */
    public int getMovimientoPiedra(){
        estadopiedra = true;
        return PIEDRA;
    }
    /**
     * Método para llamar a Tijeras
     * 
     * @return Retorna la constante TIJERA 
     */
    public int getMovimientoTijera(){
        estadotijera = true;
        return TIJERA;
    }
    /**
     * Método para llamar a Papel
     * 
     * @return Retorna la constante PAPEL
     */
    public int getMovimientoPapel(){
        estadopapel = true;
        return PAPEL;
    }
    /**
     * Método para obtener la mano rival
     * Se creara un número random entre 0 y 2 y se le asignara a cada uno
     * piedra,papel o tijeras
     */
    public void setMovimientoRival(){
        Random rival = new Random();
        int numeroRival = rival.nextInt(3);
        switch(numeroRival){
            case 0:
                movimiento = PIEDRA;
                break;
            case 1:
                movimiento = TIJERA;
                break;
            case 2:
                movimiento = PAPEL;
                break;
        }
    }

    /**
     * Método para obtener la mano rival
     * Se creara un número random entre 0 y 2 y se le asignara a cada uno
     * piedra,papel o tijeras
     * @return Retorna el movimiento que hara el rival
     */
    public int getMovimientoRival(){
        return movimiento;
    }
    /**
     * Método para obtener el ganador de la partida
     * a partir del movimiento del rival y si abrimos la mano enseñando piedra,papel o tijeras
     * Al mismo tiempo,Si la mano ganadora es la del jugador aumentara su puntuacion en 1
     * Si al contrario,la mano ganadora es la del rival,aumentara su puntuacion en 1
     * 
     * El estado de la mano se volvera a cerrar para la siguente ronda
     * 
     * @return Retorna el string con la mano rival,la del jugador y la mano ganadora
     */
    public String getGanador(){ 
        if(movimiento == PIEDRA){
            if(estadotijera){
                ganador = "Elegiste Tijera,Tu rival Piedra \n¡Gana Piedra!";
                estadotijera = false;
                puntuacionRival++;
            }
            if(estadopiedra){
                ganador = "Elegiste Piedra,Tu rival Piedra \n¡Empate!";
                estadopiedra = false;
            }
            if(estadopapel){
                ganador = "Elegiste Papel,Tu rival Piedra \n¡Gana Papel!";
                estadopapel = false;
                puntuacion++;
            }
        }
        if(movimiento == TIJERA){
            if(estadotijera){
                ganador = "Elegiste Tijeras,Tu rival Tijeras \n¡Empate!";
                estadotijera = false;
            }
            if(estadopiedra){
                ganador = "Elegiste Piedra,tu rival Tijeras \n!Gana Piedra!";
                estadopiedra = false;
                puntuacion++;
            }
            if(estadopapel){
                ganador = "Elegiste Papel,tu rival Tijeras \n¡Gana Tijera!";
                estadopapel = false;
                puntuacionRival++;
            }
        }
        if(movimiento == PAPEL){
            if(estadotijera){
                ganador = "Elegiste Tijeras,tu rival Papel \n¡Gana Tijera!";
                estadotijera = false;
                puntuacion++;
            }
            if(estadopiedra){
                ganador = "Elegiste Piedra,tu rival Papel \n¡Gana Papel!";
                estadopiedra = false;
                puntuacionRival++;
            }
            if(estadopapel){
                ganador = "Elegiste Papel,tu rival Papel \n¡Empate!";
                estadopapel = false;
            }
        }
        return ganador;
    }
    /**
     * Método que elige un color
     * Hasta el 3,tiene asignado un color por defecto
     * 
     * @param color Se le asignara un int dependiendo del color que queramos que escriba
     */
    public void setColor(int color){
        this.color = color;
        switch(color){
            case 0: colorFinal = "Rojo";
                break;
            case 1:colorFinal = "Amarillo";
                break;
            case 2:colorFinal = "Verde";
                 break;
            case 3:colorFinal = "Azul";
                break;
        }
    }
    /**
     * Método que devuelve el color
     * 
     * @return Retorna el color elegido
     */
    public int getColor(){
      return this.color;
    }
    
    /**
     * Método para asignar el numero de partidas que queremos jugar
     * 
     * @param partidas Numero de partidas que queremos jugar,por defecto seran 3,5 o 7
     * @return Retorna el numero de partido que queremos jugar
     */
    public int getRound(int partidas){
        this.partidas = partidas;
        switch(partidas){
            case 0: numPartidas = 3;
                break;
            case 1: numPartidas = 5;
                break;
            case 2: numPartidas = 7;
                break;
        }
        return numPartidas;
    }
    
   
    /**
     * Método que insertara el ganador de la ronda segun el numero de partidas
     * Al ganar o perder,se reiniciaran los valores para comenzar de nuevo la partida
     * 
     * @return Retorna si has ganado o perdido,segun tu puntuacion y el numero de partida elegida
     */
    public String setRound(){
        switch(numPartidas){
            case 3:
                if(puntuacion == 3){
                  rondaFinal = "Eres el ganador";
                  String victoria = (true) ? "¡HAS GANADO!" : "HAS PERDIDO";
                  JOptionPane.showMessageDialog(null,victoria,"Enhorabuena",JOptionPane.INFORMATION_MESSAGE);
                  setReiniciar();
                }else{
                    if(puntuacionRival == 3){
                        rondaFinal = "Eres el perdedor";
                        String victoria = (true) ? "¡HAS PERDIDO!" : "HAS GANADO";
                        JOptionPane.showMessageDialog(null,victoria,"Lastima..",JOptionPane.INFORMATION_MESSAGE);
                        setReiniciar();
                    }
                }
            break;
            case 5:
                if(puntuacion == 5){
                  rondaFinal = "Eres el ganador";
                  String victoria = (true) ? "¡HAS GANADO!" : "HAS PERDIDO";
                  JOptionPane.showMessageDialog(null,victoria,"Enhorabuena",JOptionPane.INFORMATION_MESSAGE);
                  setReiniciar();
                }else{
                    if(puntuacionRival == 5){
                        rondaFinal = "Eres el perdedor";
                        String victoria = (true) ? "¡HAS PERDIDO!" : "HAS GANADO";
                        JOptionPane.showMessageDialog(null,victoria,"Lastima..",JOptionPane.INFORMATION_MESSAGE); 
                        setReiniciar();
                    }
                }
            break;
            case 7:
                if(puntuacion == 7){
                  rondaFinal = "Eres el ganador";
                  String victoria = (true) ? "¡HAS GANADO!" : "HAS PERDIDO";
                  JOptionPane.showMessageDialog(null,victoria,"Enhorabuena",JOptionPane.INFORMATION_MESSAGE); 
                  setReiniciar();
                }else{
                    if(puntuacionRival == 7){
                        rondaFinal = "Eres el perdedor";
                        String victoria = (true) ? "¡HAS PERDIDO!" : "HAS GANADO";
                        JOptionPane.showMessageDialog(null,victoria,"Lastima..",JOptionPane.INFORMATION_MESSAGE);
                        setReiniciar();
                        
                    }
                }
            break;
        }
        return rondaFinal;
    }
    /**
     * Método que reinicia la partida para volver a comenzar
     * Devolvera las puntuaciones a 0
     * Cerrara las manos
     * Obtendra un nuevo movimiento del rival
     * Y pondra por defecto el color y el numero de partidas elegido anteriormente
     * 
     */
    public void setReiniciar(){
        puntuacion = 0;
        puntuacionRival = 0;
        getColor();
        setRound();
        getMovimientoRival();
        estadotijera = false;
        estadopiedra = false;
        estadopapel = false;
    }
    /**
     * Método para obtener el nombre del jugaor
     * 
     * @param jugador Nombre del jugador
     * @return Retorna el nombre del jugador
     */
    public String getJugador(String jugador){
        this.jugador = jugador;
        return jugador;
    }
    
    /**
     * Método que escribe una cadena con todo el resultado final de nuestra partida
     * Se le asigna el nombre del jugador
     * Se le asigna el ganador de la ronda (No de la partida)
     * Se le asigna las puntuaciones
     * Se le asigna el color elegido
     * Se le asigna el numero de rondas elegido
     * @return Retorna todo lo asignado
     */
    public String toResultadoFinal(){
        String Final = "\nJUGADOR: "+ jugador;
        Final += "\nEsta ronda: " + getGanador();
        Final += "\nTu puntuacion:" +puntuacion;
        Final += "\nPuntuacion rival: "+puntuacionRival;
        Final += "\nColor Elegido: " + colorFinal;
        Final += "\nAl mejor de: " +numPartidas+" Rondas";
        Final += "\n================";
        return Final;
    }
}
