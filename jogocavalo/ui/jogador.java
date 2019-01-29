/*
 *class para guardar o nome e pontos dos jogador
 */

package jogocavalo.ui;


public class jogador {
    String nome;
    int pontos;
    
    //construtor da class 
    // recebe uma String - str -  
    jogador(String str){
        //verifica a posição do ponto e virgula
        int separador=str.lastIndexOf(";");
        
        nome=str.substring(0, separador-1);
        pontos=Integer.parseInt(str.substring(separador+1));
    }
    
    void setNome(String n){
        nome=n;
    }

    void setPontos(int p){
        pontos=p;
    }
    
    String getNome(){
        return nome;
    }

    int getPontos(){
        return pontos;
    }
}
