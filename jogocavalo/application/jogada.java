/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogocavalo.application;

import java.util.ArrayList;
import javax.swing.JButton;

public class jogada {
    
    public int posicao; // indica a posição do cavalo
    public boolean fim =false; // indica se o cavalo terminou o jogo 
    public jogada(){
        posicao=-1;
    }
    
    /*Metodo que verifica a jogada do ponei
     * pos - posição actual do ponei
     * p - nova posição do ponei
     * retorna true se a nova posição é valida
     * retorna false se nova posição não é valida*/
    private boolean jogaPonei(int pos, int p){
        if (pos==0 && p==pos+11)
            return true;
        else if (pos>0 && pos<9 && (p==pos+9 || p==pos+11))
            return true;
        else if (pos==9 && p==pos+9 )
            return true;
        else if (pos>0 && pos<90 && pos%10==0 && (p==pos-9 || p==pos+11))
            return true;
        else if (pos==90 && p==pos-9 )
            return true;
        else if (pos>9 && pos<99 && pos%10==9 && (p==pos-11 || p==pos+9))
            return true;
        else if (pos>90 && pos<99 && (p==pos-9 || p==pos-11))
            return true;
        else if (pos==99 && p==pos-11 )
            return true;
        else if (p==pos-9 || p==pos-11 || p==pos+9 || p==pos+11)
            return true;
        return false;
    }
    
    
    /*Metodo que verifica a jogada do cavalo
     * pos - posição actual do cavalo
     * p - nova posição do cavalo
     * retorna true se a nova posição é valida
     * retorna false se nova posição não é valida*/
    private boolean jogaCavalo(int pos, int p){
        if (pos==0 && (p==pos+12 || p==pos+21))
            return true;
        else if (pos==1 && (p==pos+12 || p==pos+19 || p==pos+21))
            return true;
        else if (pos>1 && pos<8 && (p==pos+8 || p==pos+12 || p==pos+19 || p==pos+21))
            return true;
        else if (pos==8 && (p==pos+8 || p==pos+19 || p==pos+21))
            return true;
        else if (pos==9 && (p==pos+8 || p==pos+19))
            return true;
        else if (pos==10 && (p==pos-8 || p==pos+12 || p==pos+21))
            return true;
        else if (pos==11 && (p==pos-8 || p==pos+12 || p==pos+19 || p==pos+21))
            return true;
        else if (pos>11 && pos<18 && (p==pos-12 || p==pos-8 || p==pos+8 || p==pos+12 || p==pos+19 || p==pos+21))
            return true;
        else if (pos==18 && (p==pos-12 || p==pos+8 || p==pos+19 || p==pos+21))
            return true;
        else if (pos==19 && (p==pos-12 || p==pos+8 || p==pos+19))
            return true;
        else if ((pos==20 || pos==30 || pos==40 || pos==50 || pos==60 || pos==70) && (p==pos-19 || p==pos-8 || p==pos+12 || p==pos+21))
            return true;
        else if ((pos==21 || pos==31 || pos==41 || pos==51 || pos==61 || pos==71) && 
                (p==pos-21 || p==pos-19 || p==pos-8 || p==pos+12 || p==pos+19 || p==pos+21))
            return true;
        else if ((pos==28 || pos==38 || pos==48 || pos==58 || pos==68 || pos==78) && 
                (p==pos-21 || p==pos-19 || p==pos-12 || p==pos+8 || p==pos+19 || p==pos+21))
            return true;
        else if ((pos==29 || pos==39 || pos==49 || pos==59 || pos==69 || pos==79) && 
                (p==pos-21 || p==pos-12 || p==pos+8 || p==pos+19))
            return true;
        else if (pos==80 && (p==pos-19 || p==pos-8 || p==pos+12))
            return true;
        else if (pos==81 && (p==pos-21 || p==pos-19 || p==pos-8 || p==pos+12))
            return true;
        else if (pos>81 && pos<88 && (p==pos-21 || p==pos-19 || p==pos-12 || p==pos-8 || p==pos+8 || p==pos+12))
            return true;
        else if (pos==88 && (p==pos-21 || p==pos-19 || p==pos-12 || p==pos+8))
            return true;
        else if (pos==89 && (p==pos-21 || p==pos-12 || p==pos+8))
            return true;
        else if (pos==90 && (p==pos-19 || p==pos-8))
            return true;
        else if (pos==91 && (p==pos-21 || p==pos-19 || p==pos-8))
            return true;
        else if (pos>91 && pos<98 && (p==pos-21 || p==pos-19 || p==pos-12 || p==pos-8))
            return true;
        else if (pos==98 && (p==pos-21 || p==pos-19 || p==pos-12))
            return true;
        else if (pos==99 && (p==pos-21 || p==pos-12))
            return true;
        else if(p==pos-21 || p==pos+21 || p==pos-8 || p==pos+8 || p==pos-12 || p==pos+12 || p==pos-19 || p==pos+19)
            return true;
        return false;
    }
        
    /*metodo para validar a jogada do cavalo
     * p - nova posição do cavalo
     * j - numero do jogador
     * retorna true se a jogada estiver corrrecta
     * retorna false se a jogada não é valida*/
    public boolean cavalo(int p, int j){
        if(posicao<0 && j==1 && p<10){//inicio do jogo do cavalo branco
            posicao=p;
            return true;
        }
        else if(posicao<0 && j==2 && p>=90){//inicio do jogo do cavalo preto
            posicao=p;
            return true;
        }
        else if (posicao>=0 && jogaCavalo(posicao,p)){
            posicao=p;
            return true;
        }
        return false;
    }
    
    /*metodo para validar a jogada do ponei
     * p - nova posição do ponei
     * j - numero do jogador
     * retorna true se a jogada estiver corrrecta
     * retorna false se a jogada não é valida*/
    public boolean ponei(int p, int j){
        if(posicao<0 && j==1 && p<10){//inicio do jogo do ponei branco
            posicao=p;
            return true;
        }
        else if(posicao<0 && j==2 && p>=90){//inicio do jogo do ponei preto
            posicao=p;
            return true;
        }
        else if (posicao>=0 && jogaPonei(posicao,p)){
            posicao=p;
            return true;
        }
        return false;
    }
    
    public  boolean fimJogoPonei(ArrayList<JButton> ta){
        try{
            if (posicao==0 && ta.get(posicao+11).getText().equals(""))
                return true;
            else if (posicao>0 && posicao<9 && ta.get(posicao+9).getText().equals("") && 
                    ta.get(posicao+11).getText().equals(""))
                return true;
            else if (posicao==9 && ta.get(posicao+9).getText().equals(""))
                return true;
            else if (posicao>0 && posicao<90 && posicao%10==0 && 
                    ta.get(posicao-9).getText().equals("") && ta.get(posicao+11).getText().equals(""))
                return true;
            else if (posicao==90 && ta.get(posicao-9).getText().equals(""))
                return true;
            else if (posicao>9 && posicao<99 && posicao%10==9 && 
                    ta.get(posicao-11).getText().equals("") && ta.get(posicao+9).getText().equals(""))
                return true;
            else if (posicao>90 && posicao<99 && ta.get(posicao-9).getText().equals("") && 
                    ta.get(posicao-11).getText().equals(""))
                return true;
            else if (posicao==99 && ta.get(posicao-11).getText().equals(""))
                return true;
            else if (ta.get(posicao-11).getText().equals("") && ta.get(posicao-9).getText().equals("") &&
                    ta.get(posicao+9).getText().equals("") && ta.get(posicao+11).getText().equals(""))
                return true;
        }catch(ArrayIndexOutOfBoundsException ex1){} // caso a posicao saia fora do tabuleiro
        
        return false;
    }
    
    public boolean fimJogoCavalo(ArrayList<JButton> ta){
        try{
        if (posicao==0 && ta.get(posicao+12).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if (posicao==1 && ta.get(posicao+12).getText().equals("") && 
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if (posicao==8 && ta.get(posicao+8).getText().equals("") && 
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if (posicao==9 && ta.get(posicao+8).getText().equals("") && ta.get(posicao+19).getText().equals(""))
            return true;
        else if (posicao==10 && ta.get(posicao-8).getText().equals("") && 
                ta.get(posicao+12).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if (posicao==11 && ta.get(posicao-8).getText().equals("") && ta.get(posicao+12).getText().equals("") && 
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if (posicao==18 && ta.get(posicao-12).getText().equals("") && ta.get(posicao+8).getText().equals("") && 
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if (posicao==19 && ta.get(posicao-12).getText().equals("") && 
                ta.get(posicao+8).getText().equals("") && ta.get(posicao+19).getText().equals(""))
            return true;
        else if (posicao>1 && posicao<8 && ta.get(posicao+8).getText().equals("") && ta.get(posicao+12).getText().equals("") && 
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
       else if (posicao>11 && posicao<18 && ta.get(posicao-12).getText().equals("") && ta.get(posicao-8).getText().equals("") && 
                ta.get(posicao+8).getText().equals("") && ta.get(posicao+12).getText().equals("") && 
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
       else if (posicao==80 && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-8).getText().equals("") && ta.get(posicao+12).getText().equals(""))
            return true;
       else if (posicao==81 && ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-8).getText().equals("") && ta.get(posicao+12).getText().equals(""))
            return true; 
        else if (posicao==88 && ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-12).getText().equals("") && ta.get(posicao+8).getText().equals(""))
            return true;
        else if (posicao==89 && ta.get(posicao-21).getText().equals("") && 
                ta.get(posicao-12).getText().equals("") && ta.get(posicao+8).getText().equals(""))
            return true;
        else if (posicao==90 && ta.get(posicao-19).getText().equals("") && ta.get(posicao-8).getText().equals(""))
            return true;
        else if (posicao==91 && ta.get(posicao-21).getText().equals("") && 
                ta.get(posicao-19).getText().equals("") && ta.get(posicao-8).getText().equals(""))
            return true;
        else if (posicao==98 && ta.get(posicao-21).getText().equals("") && 
                ta.get(posicao-19).getText().equals("") && ta.get(posicao-12).getText().equals(""))
            return true;
        else if (posicao==99 && ta.get(posicao-21).getText().equals("") && ta.get(posicao-12).getText().equals(""))
            return true;
        else if (posicao>81 && posicao<88 && ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-12).getText().equals("") && ta.get(posicao-8).getText().equals("") && 
                ta.get(posicao+8).getText().equals("") && ta.get(posicao+12).getText().equals(""))
            return true;
        else if (posicao>91 && posicao<98 && ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-12).getText().equals("") && ta.get(posicao-8).getText().equals(""))
            return true;
        else if ((posicao==20 || posicao==30 || posicao==40 || posicao==50 || posicao==60 || posicao==70) &&
                ta.get(posicao-19).getText().equals("") && ta.get(posicao-8).getText().equals("") && 
                ta.get(posicao+12).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if ((posicao==21 || posicao==31 || posicao==41 || posicao==51 || posicao==61 || posicao==71) &&
                ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-8).getText().equals("") && ta.get(posicao+12).getText().equals("") &&
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if ((posicao==28 || posicao==38 || posicao==48 || posicao==58 || posicao==68 || posicao==78) &&
                ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-12).getText().equals("") && ta.get(posicao+8).getText().equals("") &&
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        else if ((posicao==29 || posicao==39 || posicao==49 || posicao==59 || posicao==69 || posicao==79) &&
                ta.get(posicao-21).getText().equals("") && ta.get(posicao-12).getText().equals("") && 
                ta.get(posicao+8).getText().equals("") && ta.get(posicao+19).getText().equals(""))
            return true;
        else if (ta.get(posicao-21).getText().equals("") && ta.get(posicao-19).getText().equals("") && 
                ta.get(posicao-12).getText().equals("") && ta.get(posicao-8).getText().equals("") && 
                ta.get(posicao+8).getText().equals("") && ta.get(posicao+12).getText().equals("") &&
                ta.get(posicao+19).getText().equals("") && ta.get(posicao+21).getText().equals(""))
            return true;
        }catch(ArrayIndexOutOfBoundsException ex1){} // caso a posicao saia fora do tabuleiro
        return false;
    }
    
}
