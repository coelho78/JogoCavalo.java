/*
 * Tabuleiro.java
 */

package jogocavalo.ui;

import jogocavalo.application.*;

import java.util.ArrayList;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Tabuleiro extends javax.swing.JFrame {
    
    //criar o ArrayList para os botões
    ArrayList<JButton> ta = new ArrayList<JButton>();
    
    /* indica o tipo de jogo
     * tipo=1  Jogo do cavalo
     * tipo=2  Jogo do ponei
     * tipo=3  Jogo do cavalo solitario
     * tipo=4  Jogo do ponei solitario 
       tipo=5  para escolher o numero duplo para apagar*/
    int tipo=1;  
    
    int aux_tipo;
    
    // indica o cavalo a jogar
    // jogador=1  cavalo branco
    // jogador=2  cavalo preto
    int jogador =1;
    
    jogada cb;  // cavalo branco
    jogada cp;  // cavalo preto
    
    // arraylists da class jogador que guarda os nomes e pontos
    // dos jogadores para cada tipo de jogo
    ArrayList<jogador> jCavalo = new ArrayList<jogador>();
    ArrayList<jogador> jPonei = new ArrayList<jogador>();
    ArrayList<jogador> jCavaloSolitario = new ArrayList<jogador>();
    ArrayList<jogador> jPoneiSolitario = new ArrayList<jogador>();
    
    //janela para mostrar a pontuação
    pontos jPontos= new pontos();
    
    /** Creates new form Tabuleiro */
    public Tabuleiro() {
        initComponents();
    }
    
    
    /* este metodo 
     * String nfile - recebe o nome do ficheiro, cda tipo de jogo tem um ficheiro
     * ArrayList<jogador> pj - o arraylist de cada tipo de jogo
     * escreve no ficheiro o conteudo do arraylist pj - nome;pontos
     */ 
    void escreverFicheiro(String nfile,ArrayList<jogador> pj){
                 
        FileWriter file;
        PrintWriter writer;
        String text;
 
        try{
            file=new FileWriter(nfile);
            writer = new PrintWriter(file);
        

            for (int i = 0; i < pj.size(); i++) {
                text=pj.get(i).getNome();
                text = text + ";"; //separador - separa o nome dos pontos
                text=text + pj.get(i).getPontos();
                writer.println(text);
            }
            writer.flush();

        }catch (IOException e) {}
    }
            
            
    
    /* 2este metodo 
     * String nfile - recebe o nome do ficheiro, cda tipo de jogo tem um ficheiro
     * ArrayList<jogador> pj - o arraylist de cada tipo de jogo
     * lê o conteudo do ficheiro que tem o nome e a pontuação de cada jodagor
     * e guarda no arraylist pj
     */ 
    void lerFicheiro(String nfile,ArrayList<jogador> pj){
                 
        FileReader file;
        BufferedReader reader;
 
        try{
            file=new FileReader(nfile);
            //cria o buffer para ler o ficheiro
            reader = new BufferedReader(file);
            String text = null;
 
            // repete ate ler todas as linhas do ficheiro
            // cada linha tem o nome e os pontos separados por ;
            //          nome;pontos
            while ((text = reader.readLine()) != null)
            {
                //adiciona ao array o nome e pontos do jogador
                pj.add(new jogador(text));
            }
            reader.close();
        } 
        catch (FileNotFoundException e){} //apanha a excepção no caso do ficheiro não existir
        catch (IOException e){} //apanha a excepção no caso de erro de input/output
    }
    
    //ordena por ordem decrescente o arraylist que recebe tendo
    // como referencia os pontos dos jogadores
    void ordenarArrayList(ArrayList<jogador> aj){
        int menorP,auxP; //
        String menorN, auxN;
        for(int i=0;i<aj.size()-1;i++){
            menorP=aj.get(i).getPontos();
            menorN=aj.get(i).getNome();
            for(int j=i+1;j<aj.size();j++){
                if(menorP < aj.get(j).getPontos()){
                    auxP=menorP;
                    menorP=aj.get(j).getPontos();
                    aj.get(j).setPontos(auxP);
                    auxN=menorN;
                    menorN=aj.get(j).getNome();
                    aj.get(j).setNome(auxN);
                }
            }
            aj.get(i).setPontos(menorP);
            aj.get(i).setNome(menorN);
        }
    }
    
    // metodo para mostrar a pontuação
    // parametros de Entrada
    // ArrayList<jogador> jp - Array com o nome dos jogadores e respectivos pontos
    // String t - frase que indica o tipo de jogo
    void mostrarPontos(ArrayList<jogador> jp, String t){
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)jPontos.jTable1.getModel();
        
        if (jp.isEmpty()){
            jPontos.jLabel1.setText("Não Existe Pontuação");
            jPontos.jTable1.setVisible(false);
        }else{
            jPontos.jLabel1.setText(t);
            ordenarArrayList(jCavalo);
            for(int i=0;i<dtm.getRowCount();i++)// apaga todas as linhas da tabela
                dtm.removeRow(0);
            for(int i=0;i<jp.size();i++)// adiciona novas linhas com o nome e respectivo pontos do jodador
                dtm.addRow(new Object[]{jp.get(i).getNome(),jp.get(i).getPontos()});
            jPontos.jTable1.setVisible(true);
        }
        jPontos.setVisible(true);
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton101 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton102 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo do Cavalo e do Ponei");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jogo do Cavalo");
        jLabel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogocavalo/ui/WN.gif"))); // NOI18N
        jButton101.setBorder(null);
        jButton101.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField1.setText("Nome Jogador Cavalo Branco");

        jLabel1.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jogocavalo/ui/BN.gif"))); // NOI18N
        jButton102.setBorder(null);
        jButton102.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField2.setText("Nome Jogador Cavalo Preto");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(91, 91, 91))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton11.setBackground(new java.awt.Color(0, 204, 255));
        jButton11.setForeground(new java.awt.Color(255, 0, 0));
        jButton11.setBorder(null);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton11.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setForeground(new java.awt.Color(255, 0, 0));
        jButton12.setBorder(null);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton12.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 204, 255));
        jButton13.setForeground(new java.awt.Color(255, 0, 0));
        jButton13.setBorder(null);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton13.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setForeground(new java.awt.Color(255, 0, 0));
        jButton14.setBorder(null);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton14.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 204, 255));
        jButton15.setForeground(new java.awt.Color(255, 0, 0));
        jButton15.setBorder(null);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton15.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setForeground(new java.awt.Color(255, 0, 0));
        jButton16.setBorder(null);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton16.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(0, 204, 255));
        jButton17.setForeground(new java.awt.Color(255, 0, 0));
        jButton17.setBorder(null);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton17.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setForeground(new java.awt.Color(255, 0, 0));
        jButton18.setBorder(null);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton18.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 204, 255));
        jButton19.setForeground(new java.awt.Color(255, 0, 0));
        jButton19.setBorder(null);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton19.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setForeground(new java.awt.Color(255, 0, 0));
        jButton20.setBorder(null);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton20.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setForeground(new java.awt.Color(255, 0, 0));
        jButton21.setBorder(null);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton21.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(0, 204, 255));
        jButton22.setForeground(new java.awt.Color(255, 0, 0));
        jButton22.setBorder(null);
        jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton22.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton22.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setForeground(new java.awt.Color(255, 0, 0));
        jButton23.setBorder(null);
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton23.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(0, 204, 255));
        jButton24.setForeground(new java.awt.Color(255, 0, 0));
        jButton24.setBorder(null);
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton24.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setForeground(new java.awt.Color(255, 0, 0));
        jButton25.setBorder(null);
        jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton25.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton25.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 204, 255));
        jButton26.setForeground(new java.awt.Color(255, 0, 0));
        jButton26.setBorder(null);
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton26.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(255, 255, 255));
        jButton27.setForeground(new java.awt.Color(255, 0, 0));
        jButton27.setBorder(null);
        jButton27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton27.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(0, 204, 255));
        jButton28.setForeground(new java.awt.Color(255, 0, 0));
        jButton28.setBorder(null);
        jButton28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton28.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(255, 255, 255));
        jButton29.setForeground(new java.awt.Color(255, 0, 0));
        jButton29.setBorder(null);
        jButton29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton29.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(0, 204, 255));
        jButton30.setForeground(new java.awt.Color(255, 0, 0));
        jButton30.setBorder(null);
        jButton30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton30.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 204, 255));
        jButton31.setForeground(new java.awt.Color(255, 0, 0));
        jButton31.setBorder(null);
        jButton31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton31.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(255, 255, 255));
        jButton32.setForeground(new java.awt.Color(255, 0, 0));
        jButton32.setBorder(null);
        jButton32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton32.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(0, 204, 255));
        jButton33.setForeground(new java.awt.Color(255, 0, 0));
        jButton33.setBorder(null);
        jButton33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton33.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 255, 255));
        jButton34.setForeground(new java.awt.Color(255, 0, 0));
        jButton34.setBorder(null);
        jButton34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton34.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton34.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(0, 204, 255));
        jButton35.setForeground(new java.awt.Color(255, 0, 0));
        jButton35.setBorder(null);
        jButton35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton35.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(255, 255, 255));
        jButton36.setForeground(new java.awt.Color(255, 0, 0));
        jButton36.setBorder(null);
        jButton36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton36.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton36.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(0, 204, 255));
        jButton37.setForeground(new java.awt.Color(255, 0, 0));
        jButton37.setBorder(null);
        jButton37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton37.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton37.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(255, 255, 255));
        jButton38.setForeground(new java.awt.Color(255, 0, 0));
        jButton38.setBorder(null);
        jButton38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton38.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(0, 204, 255));
        jButton39.setForeground(new java.awt.Color(255, 0, 0));
        jButton39.setBorder(null);
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton39.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton40.setBackground(new java.awt.Color(255, 255, 255));
        jButton40.setForeground(new java.awt.Color(255, 0, 0));
        jButton40.setBorder(null);
        jButton40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton40.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setForeground(new java.awt.Color(255, 0, 0));
        jButton41.setBorder(null);
        jButton41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton41.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(0, 204, 255));
        jButton42.setForeground(new java.awt.Color(255, 0, 0));
        jButton42.setBorder(null);
        jButton42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton42.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(255, 255, 255));
        jButton43.setForeground(new java.awt.Color(255, 0, 0));
        jButton43.setBorder(null);
        jButton43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton43.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton44.setBackground(new java.awt.Color(0, 204, 255));
        jButton44.setForeground(new java.awt.Color(255, 0, 0));
        jButton44.setBorder(null);
        jButton44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton44.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton44.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(255, 255, 255));
        jButton45.setForeground(new java.awt.Color(255, 0, 0));
        jButton45.setBorder(null);
        jButton45.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton45.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton45.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(0, 204, 255));
        jButton46.setForeground(new java.awt.Color(255, 0, 0));
        jButton46.setBorder(null);
        jButton46.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton46.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton46.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(255, 255, 255));
        jButton47.setForeground(new java.awt.Color(255, 0, 0));
        jButton47.setBorder(null);
        jButton47.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton47.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton47.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton48.setBackground(new java.awt.Color(0, 204, 255));
        jButton48.setForeground(new java.awt.Color(255, 0, 0));
        jButton48.setBorder(null);
        jButton48.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton48.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton48.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton49.setBackground(new java.awt.Color(255, 255, 255));
        jButton49.setForeground(new java.awt.Color(255, 0, 0));
        jButton49.setBorder(null);
        jButton49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton49.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton49.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton50.setBackground(new java.awt.Color(0, 204, 255));
        jButton50.setForeground(new java.awt.Color(255, 0, 0));
        jButton50.setBorder(null);
        jButton50.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton50.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton50.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton51.setBackground(new java.awt.Color(0, 204, 255));
        jButton51.setForeground(new java.awt.Color(255, 0, 0));
        jButton51.setBorder(null);
        jButton51.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton51.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton52.setBackground(new java.awt.Color(255, 255, 255));
        jButton52.setForeground(new java.awt.Color(255, 0, 0));
        jButton52.setBorder(null);
        jButton52.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton52.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton53.setBackground(new java.awt.Color(0, 204, 255));
        jButton53.setForeground(new java.awt.Color(255, 0, 0));
        jButton53.setBorder(null);
        jButton53.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton53.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(255, 255, 255));
        jButton54.setForeground(new java.awt.Color(255, 0, 0));
        jButton54.setBorder(null);
        jButton54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton54.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton54.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(0, 204, 255));
        jButton55.setForeground(new java.awt.Color(255, 0, 0));
        jButton55.setBorder(null);
        jButton55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton55.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton55.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton56.setBackground(new java.awt.Color(255, 255, 255));
        jButton56.setForeground(new java.awt.Color(255, 0, 0));
        jButton56.setBorder(null);
        jButton56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton56.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton56.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton57.setBackground(new java.awt.Color(0, 204, 255));
        jButton57.setForeground(new java.awt.Color(255, 0, 0));
        jButton57.setBorder(null);
        jButton57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton57.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton57.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(255, 255, 255));
        jButton58.setForeground(new java.awt.Color(255, 0, 0));
        jButton58.setBorder(null);
        jButton58.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton58.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton58.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton59.setBackground(new java.awt.Color(0, 204, 255));
        jButton59.setForeground(new java.awt.Color(255, 0, 0));
        jButton59.setBorder(null);
        jButton59.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton59.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton59.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton60.setBackground(new java.awt.Color(255, 255, 255));
        jButton60.setForeground(new java.awt.Color(255, 0, 0));
        jButton60.setBorder(null);
        jButton60.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton60.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton60.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton61.setBackground(new java.awt.Color(255, 255, 255));
        jButton61.setForeground(new java.awt.Color(255, 0, 0));
        jButton61.setBorder(null);
        jButton61.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton61.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton61.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton62.setBackground(new java.awt.Color(0, 204, 255));
        jButton62.setForeground(new java.awt.Color(255, 0, 0));
        jButton62.setBorder(null);
        jButton62.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton62.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton62.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton63.setBackground(new java.awt.Color(255, 255, 255));
        jButton63.setForeground(new java.awt.Color(255, 0, 0));
        jButton63.setBorder(null);
        jButton63.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton63.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton63.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton64.setBackground(new java.awt.Color(0, 204, 255));
        jButton64.setForeground(new java.awt.Color(255, 0, 0));
        jButton64.setBorder(null);
        jButton64.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton64.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton64.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton65.setBackground(new java.awt.Color(255, 255, 255));
        jButton65.setForeground(new java.awt.Color(255, 0, 0));
        jButton65.setBorder(null);
        jButton65.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton65.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton65.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton66.setBackground(new java.awt.Color(0, 204, 255));
        jButton66.setForeground(new java.awt.Color(255, 0, 0));
        jButton66.setBorder(null);
        jButton66.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton66.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton66.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton67.setBackground(new java.awt.Color(255, 255, 255));
        jButton67.setForeground(new java.awt.Color(255, 0, 0));
        jButton67.setBorder(null);
        jButton67.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton67.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton67.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton68.setBackground(new java.awt.Color(0, 204, 255));
        jButton68.setForeground(new java.awt.Color(255, 0, 0));
        jButton68.setBorder(null);
        jButton68.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton68.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton68.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton69.setBackground(new java.awt.Color(255, 255, 255));
        jButton69.setForeground(new java.awt.Color(255, 0, 0));
        jButton69.setBorder(null);
        jButton69.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton69.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton69.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton70.setBackground(new java.awt.Color(0, 204, 255));
        jButton70.setForeground(new java.awt.Color(255, 0, 0));
        jButton70.setBorder(null);
        jButton70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton70.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton70.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton71.setBackground(new java.awt.Color(0, 204, 255));
        jButton71.setForeground(new java.awt.Color(255, 0, 0));
        jButton71.setBorder(null);
        jButton71.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton71.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton71.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton72.setBackground(new java.awt.Color(255, 255, 255));
        jButton72.setForeground(new java.awt.Color(255, 0, 0));
        jButton72.setBorder(null);
        jButton72.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton72.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton72.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton73.setBackground(new java.awt.Color(0, 204, 255));
        jButton73.setForeground(new java.awt.Color(255, 0, 0));
        jButton73.setBorder(null);
        jButton73.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton73.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton73.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton74.setBackground(new java.awt.Color(255, 255, 255));
        jButton74.setForeground(new java.awt.Color(255, 0, 0));
        jButton74.setBorder(null);
        jButton74.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton74.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton74.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton75.setBackground(new java.awt.Color(0, 204, 255));
        jButton75.setForeground(new java.awt.Color(255, 0, 0));
        jButton75.setBorder(null);
        jButton75.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton75.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton75.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton76.setBackground(new java.awt.Color(255, 255, 255));
        jButton76.setForeground(new java.awt.Color(255, 0, 0));
        jButton76.setBorder(null);
        jButton76.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton76.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton76.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton77.setBackground(new java.awt.Color(0, 204, 255));
        jButton77.setForeground(new java.awt.Color(255, 0, 0));
        jButton77.setBorder(null);
        jButton77.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton77.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton77.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton78.setBackground(new java.awt.Color(255, 255, 255));
        jButton78.setForeground(new java.awt.Color(255, 0, 0));
        jButton78.setBorder(null);
        jButton78.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton78.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton78.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton79.setBackground(new java.awt.Color(0, 204, 255));
        jButton79.setForeground(new java.awt.Color(255, 0, 0));
        jButton79.setBorder(null);
        jButton79.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton79.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton79.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton80.setBackground(new java.awt.Color(255, 255, 255));
        jButton80.setForeground(new java.awt.Color(255, 0, 0));
        jButton80.setBorder(null);
        jButton80.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton80.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton80.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton81.setBackground(new java.awt.Color(255, 255, 255));
        jButton81.setForeground(new java.awt.Color(255, 0, 0));
        jButton81.setBorder(null);
        jButton81.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton81.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton82.setBackground(new java.awt.Color(0, 204, 255));
        jButton82.setForeground(new java.awt.Color(255, 0, 0));
        jButton82.setBorder(null);
        jButton82.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton82.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton82.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton83.setBackground(new java.awt.Color(255, 255, 255));
        jButton83.setForeground(new java.awt.Color(255, 0, 0));
        jButton83.setBorder(null);
        jButton83.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton83.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton83.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton84.setBackground(new java.awt.Color(0, 204, 255));
        jButton84.setForeground(new java.awt.Color(255, 0, 0));
        jButton84.setBorder(null);
        jButton84.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton84.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton84.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton85.setBackground(new java.awt.Color(255, 255, 255));
        jButton85.setForeground(new java.awt.Color(255, 0, 0));
        jButton85.setBorder(null);
        jButton85.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton85.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton85.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton86.setBackground(new java.awt.Color(0, 204, 255));
        jButton86.setForeground(new java.awt.Color(255, 0, 0));
        jButton86.setBorder(null);
        jButton86.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton86.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton86.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton87.setBackground(new java.awt.Color(255, 255, 255));
        jButton87.setForeground(new java.awt.Color(255, 0, 0));
        jButton87.setBorder(null);
        jButton87.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton87.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton87.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton88.setBackground(new java.awt.Color(0, 204, 255));
        jButton88.setForeground(new java.awt.Color(255, 0, 0));
        jButton88.setBorder(null);
        jButton88.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton88.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton88.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton89.setBackground(new java.awt.Color(255, 255, 255));
        jButton89.setForeground(new java.awt.Color(255, 0, 0));
        jButton89.setBorder(null);
        jButton89.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton89.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton89.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton90.setBackground(new java.awt.Color(0, 204, 255));
        jButton90.setForeground(new java.awt.Color(255, 0, 0));
        jButton90.setBorder(null);
        jButton90.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton90.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton90.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton91.setBackground(new java.awt.Color(0, 204, 255));
        jButton91.setForeground(new java.awt.Color(255, 0, 0));
        jButton91.setBorder(null);
        jButton91.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton91.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton91.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton92.setBackground(new java.awt.Color(255, 255, 255));
        jButton92.setForeground(new java.awt.Color(255, 0, 0));
        jButton92.setBorder(null);
        jButton92.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton92.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton92.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton93.setBackground(new java.awt.Color(0, 204, 255));
        jButton93.setForeground(new java.awt.Color(255, 0, 0));
        jButton93.setBorder(null);
        jButton93.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton93.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton93.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton94.setBackground(new java.awt.Color(255, 255, 255));
        jButton94.setForeground(new java.awt.Color(255, 0, 0));
        jButton94.setBorder(null);
        jButton94.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton94.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton94.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton95.setBackground(new java.awt.Color(0, 204, 255));
        jButton95.setForeground(new java.awt.Color(255, 0, 0));
        jButton95.setBorder(null);
        jButton95.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton95.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton95.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton96.setBackground(new java.awt.Color(255, 255, 255));
        jButton96.setForeground(new java.awt.Color(255, 0, 0));
        jButton96.setBorder(null);
        jButton96.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton96.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton96.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton97.setBackground(new java.awt.Color(0, 204, 255));
        jButton97.setForeground(new java.awt.Color(255, 0, 0));
        jButton97.setBorder(null);
        jButton97.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton97.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton97.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton98.setBackground(new java.awt.Color(255, 255, 255));
        jButton98.setForeground(new java.awt.Color(255, 0, 0));
        jButton98.setBorder(null);
        jButton98.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton98.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton98.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton99.setBackground(new java.awt.Color(0, 204, 255));
        jButton99.setForeground(new java.awt.Color(255, 0, 0));
        jButton99.setBorder(null);
        jButton99.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton99.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton99.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton100.setBackground(new java.awt.Color(255, 255, 255));
        jButton100.setForeground(new java.awt.Color(255, 0, 0));
        jButton100.setBorder(null);
        jButton100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton100.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton100.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setBorder(null);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.setName("0"); // NOI18N
        jButton1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setBorder(null);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setBorder(null);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setBorder(null);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setBorder(null);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 204, 255));
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setBorder(null);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setForeground(new java.awt.Color(255, 0, 0));
        jButton7.setBorder(null);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 204, 255));
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.setBorder(null);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setForeground(new java.awt.Color(255, 0, 0));
        jButton9.setBorder(null);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton9.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 204, 255));
        jButton10.setForeground(new java.awt.Color(255, 0, 0));
        jButton10.setBorder(null);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton10.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setMnemonic('J');
        jMenu1.setText("Tipo de Jogo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cavalo");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Ponei");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Cavalo Solitario");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Ponei Solitario");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jLabel4.setBackground(java.awt.Color.red);
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu2.setMnemonic('J');
        jMenu2.setText("Tipo de Jogo");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Cavalo");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Ponei");
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Cavalo Solitario");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem8.setText("Ponei Solitario");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar2.add(jMenu2);

        jMenu3.setText("Pontuação");

        jMenuItem9.setText("Jogo do Cavalo");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem9MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Jogo do Ponei");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem10MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Jogo do Cavalo Solitario");
        jMenuItem11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem11MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Jogo do Ponei Solitario");
        jMenuItem12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem12MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //coloca os botões do tabuleiro no Arraylist
        ta.add(jButton1);
        ta.add(jButton2);
        ta.add(jButton3);
        ta.add(jButton4);
        ta.add(jButton5);
	ta.add(jButton6);
        ta.add(jButton7);
        ta.add(jButton8);
        ta.add(jButton9);
	ta.add(jButton10);

        ta.add(jButton11);
        ta.add(jButton12);
        ta.add(jButton13);
        ta.add(jButton14);
        ta.add(jButton15);
	ta.add(jButton16);
        ta.add(jButton17);
        ta.add(jButton18);
        ta.add(jButton19);
	ta.add(jButton20);
        
        ta.add(jButton21);
        ta.add(jButton22);
        ta.add(jButton23);
        ta.add(jButton24);
        ta.add(jButton25);
	ta.add(jButton26);
        ta.add(jButton27);
        ta.add(jButton28);
        ta.add(jButton29);
	ta.add(jButton30);
        
        ta.add(jButton31);
        ta.add(jButton32);
        ta.add(jButton33);
        ta.add(jButton34);
        ta.add(jButton35);
	ta.add(jButton36);
        ta.add(jButton37);
        ta.add(jButton38);
        ta.add(jButton39);
	ta.add(jButton40);
        
        ta.add(jButton41);
        ta.add(jButton42);
        ta.add(jButton43);
        ta.add(jButton44);
        ta.add(jButton45);
	ta.add(jButton46);
        ta.add(jButton47);
        ta.add(jButton48);
        ta.add(jButton49);
	ta.add(jButton50);
        
        ta.add(jButton51);
        ta.add(jButton52);
        ta.add(jButton53);
        ta.add(jButton54);
        ta.add(jButton55);
	ta.add(jButton56);
        ta.add(jButton57);
        ta.add(jButton58);
        ta.add(jButton59);
	ta.add(jButton60);
        
        ta.add(jButton61);
        ta.add(jButton62);
        ta.add(jButton63);
        ta.add(jButton64);
        ta.add(jButton65);
	ta.add(jButton66);
        ta.add(jButton67);
        ta.add(jButton68);
        ta.add(jButton69);
	ta.add(jButton70);
        
        ta.add(jButton71);
        ta.add(jButton72);
        ta.add(jButton73);
        ta.add(jButton74);
        ta.add(jButton75);
	ta.add(jButton76);
        ta.add(jButton77);
        ta.add(jButton78);
        ta.add(jButton79);
	ta.add(jButton80);
        
        ta.add(jButton81);
        ta.add(jButton82);
        ta.add(jButton83);
        ta.add(jButton84);
        ta.add(jButton85);
	ta.add(jButton86);
        ta.add(jButton87);
        ta.add(jButton88);
        ta.add(jButton89);
	ta.add(jButton90);
        
        ta.add(jButton91);
        ta.add(jButton92);
        ta.add(jButton93);
        ta.add(jButton94);
        ta.add(jButton95);
	ta.add(jButton96);
        ta.add(jButton97);
        ta.add(jButton98);
        ta.add(jButton99);
	ta.add(jButton100);
        
        //coloca o nome do botão igual a posicão no Arraylist
        for(int i=0;i<100;i++)
            ta.get(i).setName(String.valueOf(i));
        
        initBotoesClick();
        
        escolheNumeros();
        
        cb=new jogada(); // cria a instancia para a jogada do cavalo branco
        cp=new jogada(); // cria a instancia para a jogada do cavalo preto
        jLabel4.setText("E o Cavalo Branco a Jogar");
        
        //ler os ficheiros com a pontuação dos jogadores
        lerFicheiro("cavalo.txt",jCavalo);
        lerFicheiro("ponei.txt",jPonei);
        lerFicheiro("cavalosol.txt",jCavaloSolitario);
        lerFicheiro("poneisol.txt",jPoneiSolitario);
    }//GEN-LAST:event_formWindowOpened

void iniciarJogo(){
    for(int i=0;i<100;i++) //coloca ao numero do botões em cor vermelha
        ta.get(i).setForeground(new java.awt.Color(255, 0, 0));
    jLabel1.setText("0");
    jLabel2.setText("0");
    escolheNumeros();
    cb=new jogada(); // cria a instancia para a jogada do cavalo/ponei branco
    cp=new jogada(); // cria a instancia para a jogada do cavalo/ponei preto
    jogador=1;
    jLabel4.setText("E o Cavalo Branco a Jogar");

}
    
    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        jLabel3.setText("Jogo do Ponei");
        jPanel2.setVisible(true);
        tipo=2;
        iniciarJogo();
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        jLabel3.setText("Jogo do Cavalo Solitario");
        jPanel2.setVisible(false);
        tipo=3;
        iniciarJogo();
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        jLabel3.setText("Jogo do Ponei Solitario");
        jPanel2.setVisible(false);
        tipo=4;
        iniciarJogo();
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        jLabel3.setText("Jogo do Cavalo");
        jPanel2.setVisible(true);
        tipo=1;
        iniciarJogo();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MousePressed
        mostrarPontos(jCavalo,"Pontuação do Jogo do Cavalo");
    }//GEN-LAST:event_jMenuItem9MousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //escreve nos ficheiros a pontuação com os respectivos nomes dos jogadores - nome;pontos
        escreverFicheiro("cavalo.txt",jCavalo);
        escreverFicheiro("ponei.txt",jPonei);
        escreverFicheiro("cavalosol.txt",jCavaloSolitario);
        escreverFicheiro("poneisol.txt",jPoneiSolitario);
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem10MousePressed
        mostrarPontos(jPonei,"Pontuação do Jogo do Ponei");
    }//GEN-LAST:event_jMenuItem10MousePressed

    private void jMenuItem11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem11MousePressed
        mostrarPontos(jCavaloSolitario,"Pontuação do Jogo do Cavalo Solitario");
    }//GEN-LAST:event_jMenuItem11MousePressed

    private void jMenuItem12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem12MousePressed
        mostrarPontos(jPoneiSolitario,"Pontuação do Jogo do Ponei Solitario");
    }//GEN-LAST:event_jMenuItem12MousePressed
    
    private void escolheNumeros(){
        int ax[]=new int [100]; //cria o array
        int n,n1,aux;
        
        //limpa o tabuleiro
        for(int i=0;i<100;i++)
            ta.get(i).setIcon(null);
        
        //ciclo para preencher o array
        for(int i=0;i<100;i++)
            ax[i]=i;
        
        //ciclo para baralhar o array
        for(int i=0; i<200;i++){
            n=(int)Math.round(Math.random() * 49);// escolhe um numero aleatorio de 0 a 49
            n1= 50 + (int)Math.round(Math.random() * 49);// escolhe um numero aleatorio de 50 a 99
            aux=ax[n];
            ax[n]=ax[n1];  // troca o numero da posição n pelo da posição n1
            ax[n1]=aux;
        }
        
        for(int i=0;i<100;i++){
            if (ax[i] < 10)
                    ta.get(i).setText(String.valueOf("0" + ax[i]));
                else
                    ta.get(i).setText(String.valueOf(ax[i]));
        }
    }
    
    //coloca o evento click nos botões
    private void initBotoesClick(){
        for(int i=0;i<100;i++){
            ta.get(i).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    botaoClicked(evt);
                }
            });
        }
    }
    
    public void botaoClicked(java.awt.event.MouseEvent evt) {
    
        // posiçao para a mover o cavalo
        int pf=Integer.parseInt(evt.getComponent().getName());
        
        if (!ta.get(pf).getText().equals("")){
            switch(tipo){ // verifica o tipo de jogo
                case 1: // jogo do cavalo
                    jogaCavalo(pf);
                    break;
                    
                case 2:  // Jogo do ponei
                    jogaPonei(pf);
                    break;
                case 3:  // Jogo do Cavalo Solitario
                    jogaCavaloSolitario(pf);
                    break;
                case 4:  // Jogo do Ponei Solitario
                    jogaPoneiSolitario(pf);
                    break;
                case 5:  // para escolher o numero duplo para apagar
                    ta.get(pf).setText("");
                    tipo=aux_tipo;
                    numerosDuplos(2);
            }
            acabou();  // verifica quando o jogo acaba
            mensagem();
        }
    }
    
    void mensagem(){
        if (tipo==5)
            jLabel4.setText("Escolha um dos Numeros de cor Amarela");
        else if (cb.fim && (tipo==3 || tipo==4))
            jLabel4.setText("Jogo Terminou!!! (Escolha Outro jogo no menu Tipo de &Jogo)");
        else if (cb.fim && cp.fim)
            jLabel4.setText("Jogo Terminou!!! (Escolha Outro jogo no menu Tipo de &Jogo)");
        else if(jogador==1)
            jLabel4.setText("É o Cavalo Branco a Jogar");
        else if (jogador==2)
            jLabel4.setText("É o Cavalo Preto a Jogar");
    }
    
    private String msgFimJogo (int n){
        int pb=Integer.parseInt(jLabel1.getText()); // Pontos Cavalo Branco
        int pp=Integer.parseInt(jLabel2.getText()); // Pontos Cavalo Preto
        String nomeBranco=jTextField1.getText();
        String nomePreto=jTextField2.getText();
        
        String msg;
       
        if (n==1)
            msg=nomeBranco + " Terminou o Jogo com " + pb + " Pontos";
        else if (n==2)
            msg=nomePreto + " Terminou o Jogo com " + pp + " Pontos";
        else{
            msg=nomeBranco + " - " + pb + " Pontos\n";
            msg+=nomePreto + " - " + pp + " Pontos\n\n";
            if (pb > pp )
                msg+="O " + nomeBranco + " GANHOU!!!";
            else if (pb == pp)
                msg+="O Jogo terminou Empatado";
            else
                msg+="O " + nomePreto + " GANHOU!!!";
        }
        return msg;
    }
    
    private int numeroSimetrico(int r, int q){
        int ns=10*r+q;
        for(int i=0;i<100;i++){
            try{
                if (Integer.parseInt(ta.get(i).getText()) == ns)
                    return i;
            }catch(NumberFormatException Ex){
            }
        }
        return 0;
    }
    
    private void numerosDuplos(int cor){
        int r,q,n;
        for(int i=0;i<99;i++){
            try{
                n = Integer.parseInt(ta.get(i).getText());
                r = n % 10;
                q = (int)n / 10;
                if (cor==1 && r==q) //cor Amarela
                    ta.get(i).setForeground(new java.awt.Color(255, 255, 0));
                else if (cor==2 && r==q) // cor Vermelha
                    ta.get(i).setForeground(new java.awt.Color(255, 0, 0));
            }catch(NumberFormatException Ex){
            }
        }
    }
    
    private void apagaNumero(int pf){
        int numero=Integer.parseInt(ta.get(pf).getText());
        ta.get(pf).setText("");
        int resto= numero%10;
        int resultado=(int)numero/10;
        if (resto==resultado){ //numero duplo
            aux_tipo=tipo;
            tipo=5; // apaga o numero duplo escolhido pelo jogador
            numerosDuplos(1);
        }
        else
            ta.get(numeroSimetrico(resto,resultado)).setText("");
    }
    
    private void jogaCavalo(int pf){
        int pi,pontos;
        if (jogador==1){  // cavalo branco
            pi=cb.posicao; // posição do cavalo branco
            if (pi==-1 && cb.cavalo(pf,1)){ // inicio do jogo
                ta.get(pf).setIcon(jButton101.getIcon()); // coloca o cavalo branco no botão
                jLabel1.setText(ta.get(pf).getText()); // mostra os pontos na label
                apagaNumero(pf);
                jogador=2;  //muda de jogador
            }
            else if (cb.cavalo(pf,1)){ //durante o jogo
                ta.get(pf).setIcon(jButton101.getIcon()); // coloca o cavalo branco no botão
                ta.get(pi).setIcon(null); // limpa o cavalo branco da posição antiga
                pontos=Integer.parseInt(jLabel1.getText()); // pontos do cavalo branco
                pontos+=Integer.parseInt(ta.get(pf).getText()); // acumula os pontos
                jLabel1.setText(String.valueOf(pontos)); // mostra os pontos 
                apagaNumero(pf);
                if (!cp.fim) jogador=2;  //se o outro jogador ainda nao terminou muda de jogador
            }
        }
        else if (jogador==2){  // cavalo preto
            pi=cp.posicao; // posição do cavalo preto
            if (pi==-1 && cp.cavalo(pf,2)){ // inicio do jogo
                ta.get(pf).setIcon(jButton102.getIcon()); // coloca o cavalo preto no botão
                jLabel2.setText(ta.get(pf).getText()); // mostra os pontos na label
                apagaNumero(pf);
                jogador=1;  //muda de jogador
            }
            else if (cp.cavalo(pf,2)){ //durante o jogo
                ta.get(pf).setIcon(jButton102.getIcon()); // coloca o cavalo preto no botão
                ta.get(pi).setIcon(null); // limpa o cavalo preto da posição antiga
                pontos=Integer.parseInt(jLabel2.getText()); // pontos do cavalo preto
                pontos+=Integer.parseInt(ta.get(pf).getText()); // acumula os pontos
                jLabel2.setText(String.valueOf(pontos)); // mostra os pontos 
                apagaNumero(pf);
                if (!cb.fim) jogador=1;  //se o outro jogador ainda nao terminou muda de jogador
            }
        }
    }
    
    private void jogaCavaloSolitario(int pf){
        int pi,pontos;
        pi=cb.posicao; // posição do cavalo branco
        if (pi==-1 && cb.cavalo(pf,1)){ // inicio do jogo
            ta.get(pf).setIcon(jButton101.getIcon()); // coloca o cavalo branco no botão
            jLabel1.setText(ta.get(pf).getText()); // mostra os pontos na label
            apagaNumero(pf);
        }
        else if (cb.cavalo(pf,1)){ //durante o jogo
            ta.get(pf).setIcon(jButton101.getIcon()); // coloca o cavalo branco no botão
            ta.get(pi).setIcon(null); // limpa o cavalo branco da posição antiga
            pontos=Integer.parseInt(jLabel1.getText()); // pontos do cavalo branco
            pontos+=Integer.parseInt(ta.get(pf).getText()); // acumula os pontos
            jLabel1.setText(String.valueOf(pontos)); // mostra os pontos 
            apagaNumero(pf);
        }
    }
    
    private void jogaPonei(int pf){
        int pi,pontos;
        if (jogador==1){  // ponei branco
            pi=cb.posicao; // posição do ponei branco
            if (pi==-1 && cb.ponei(pf,1)){ // inicio do jogo
                ta.get(pf).setIcon(jButton101.getIcon()); // coloca o ponei branco no botão
                jLabel1.setText(ta.get(pf).getText()); // mostra os pontos na label
                apagaNumero(pf);
                jogador=2;  //muda de jogador
            }
            else if (cb.ponei(pf,1)){ //durante o jogo
                ta.get(pf).setIcon(jButton101.getIcon()); // coloca o ponei branco no botão
                ta.get(pi).setIcon(null); // limpa o ponei branco da posição antiga
                pontos=Integer.parseInt(jLabel1.getText()); // pontos do ponei branco
                pontos+=Integer.parseInt(ta.get(pf).getText()); // acumula os pontos
                jLabel1.setText(String.valueOf(pontos)); // mostra os pontos 
                apagaNumero(pf);
                if (!cp.fim) jogador=2;  //se o outro jogador ainda nao terminou muda de jogador
            }
        }
        else if (jogador==2){  // ponei preto
            pi=cp.posicao; // posição do ponei preto
            if (pi==-1 && cp.ponei(pf,2)){ // inicio do jogo
                ta.get(pf).setIcon(jButton102.getIcon()); // coloca o ponei preto no botão
                jLabel2.setText(ta.get(pf).getText()); // mostra os pontos na label
                apagaNumero(pf);
                jogador=1;  //muda de jogador
            }
            else if (cp.ponei(pf,2)){ //durante o jogo
                ta.get(pf).setIcon(jButton102.getIcon()); // coloca o ponei preto no botão
                ta.get(pi).setIcon(null); // limpa o ponei preto da posição antiga
                pontos=Integer.parseInt(jLabel2.getText()); // pontos do ponei preto
                pontos+=Integer.parseInt(ta.get(pf).getText()); // acumula os pontos
                jLabel2.setText(String.valueOf(pontos)); // mostra os pontos 
                apagaNumero(pf);
                if (!cb.fim) jogador=1;  //se o outro jogador ainda nao terminou muda de jogador
            }
        }
    }
    
    private void jogaPoneiSolitario(int pf){
        int pi,pontos;
        pi=cb.posicao; // posição do ponei branco
        if (pi==-1 && cb.ponei(pf,1)){ // inicio do jogo
            ta.get(pf).setIcon(jButton101.getIcon()); // coloca o ponei branco no botão
            jLabel1.setText(ta.get(pf).getText()); // mostra os pontos na label
            apagaNumero(pf);
        }
        else if (cb.ponei(pf,1)){ //durante o jogo
            ta.get(pf).setIcon(jButton101.getIcon()); // coloca o ponei branco no botão
            ta.get(pi).setIcon(null); // limpa o ponei branco da posição antiga
            pontos=Integer.parseInt(jLabel1.getText()); // pontos do ponei branco
            pontos+=Integer.parseInt(ta.get(pf).getText()); // acumula os pontos
            jLabel1.setText(String.valueOf(pontos)); // mostra os pontos 
            apagaNumero(pf);
        }
    }
    
    
    private void acabou(){
        if (tipo==1)
            acabouCavalo();
        else if (tipo==2)
            acabouPonei();
        else if (tipo==3)
            acabouCavaloSolitario();
        else if (tipo==4)
            acabouPoneiSolitario();
    }
    
    private void acabouCavalo(){
        if (cb.fimJogoCavalo(ta) && cp.fimJogoCavalo(ta)){ //verifica se o Jogo terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(3),"Jogo do Cavalo",JOptionPane.INFORMATION_MESSAGE);
            cb.fim=true;
            cp.fim=true;
            //adiciona os nomes dos jogadores e pontos no array
            String np=jTextField1.getText() + ";" + jLabel1.getText();
            jCavalo.add(new jogador(np)); //Jogador Cavalo Branco
            np=jTextField2.getText() + ";" + jLabel2.getText();
            jCavalo.add(new jogador(np)); //Jogador Cavalo Preto
        }
        else if (!cb.fim && cb.fimJogoCavalo(ta)){ //verifica se o Jogador 1 terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(1),"Jogo do Cavalo",JOptionPane.INFORMATION_MESSAGE);
            cb.fim=true;
            jogador=2;
        }
        else if (!cp.fim && cp.fimJogoCavalo(ta)){ //verifica se o Jogador 2 terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(2),"Jogo do Cavalo",JOptionPane.INFORMATION_MESSAGE);
            cp.fim=true;
            jogador=1;
        }
    }
    
    private void acabouCavaloSolitario(){
        if (cb.fimJogoCavalo(ta)){ //verifica se o Jogador 1 terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(1),"Jogo do Cavalo",JOptionPane.INFORMATION_MESSAGE);
            cb.fim=true;
            String np=jTextField1.getText() + ";" + jLabel1.getText();
            jCavaloSolitario.add(new jogador(np)); //Jogador Ponei Branco
        }
    }
    
    private void acabouPonei(){
        if (cb.fimJogoPonei(ta) && cp.fimJogoPonei(ta)){ //verifica se o Jogo terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(3),"Jogo do Ponei",JOptionPane.INFORMATION_MESSAGE);
            cb.fim=true;
            cp.fim=true;
            String np=jTextField1.getText() + ";" + jLabel1.getText();
            jPonei.add(new jogador(np)); //Jogador Ponei Branco
            np=jTextField2.getText() + ";" + jLabel2.getText();
            jPonei.add(new jogador(np)); //Jogador Ponei Preto
        }
        else if (!cb.fim && cb.fimJogoCavalo(ta)){ //verifica se o Jogador 1 terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(1),"Jogo do Ponei",JOptionPane.INFORMATION_MESSAGE);
            cb.fim=true;
            jogador=2;
        }
        else if (!cp.fim && cp.fimJogoCavalo(ta)){ //verifica se o Jogador 2 terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(2),"Jogo do Ponei",JOptionPane.INFORMATION_MESSAGE);
            cp.fim=true;
            jogador=1;
        }
    }
    
    private void acabouPoneiSolitario(){
        if (cb.fimJogoPonei(ta)){ //verifica se o Jogador 1 terminou
            JOptionPane.showMessageDialog(null,msgFimJogo(1),"Jogo do Ponei",JOptionPane.INFORMATION_MESSAGE);
            cb.fim=true;
            String np=jTextField1.getText() + ";" + jLabel1.getText();
            jPoneiSolitario.add(new jogador(np)); //Jogador Ponei Branco
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
}
