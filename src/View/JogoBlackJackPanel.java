package View;

import Controller.InterfaceJogador;
import Model.CardLabel;
import Model.Jogador;
import Model.JogadorRemote;
import Model.TimerRound;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class JogoBlackJackPanel extends javax.swing.JPanel {

    final static int UNICO_MESA = 4;
    final static int SUCC = 9;

    private Jogador jogador;
    private InterfaceJogador objDealer;
    private int meuID;
    private List<CardLabel> cartasNaMesa = new ArrayList<CardLabel>();
    private TimerRound timer;

    public JogoBlackJackPanel(InterfaceJogador objDealer) {
        initComponents();
        this.objDealer = objDealer;
        hit_btn.setVisible(false);
        stand_btn.setVisible(false);
        coins_img.setVisible(false);
        turn_label.setVisible(false);
        lose_label.setVisible(false);
        playAgain_btn.setVisible(false);
        playAgain_btn.setEnabled(false);
    }

    public void setJogadorID(int id) {
        this.meuID = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void adicionarCarta(CardLabel carta) {

        cartasNaMesa.add(carta);

        this.add(carta);
        this.setComponentZOrder(carta, 0);
    }

    public void limparCartas() {

        for (CardLabel c : cartasNaMesa) {
            this.remove(c);
        }

        cartasNaMesa.clear();
        this.playAgain_btn.setVisible(false);
        this.lose_label.setVisible(false);
        this.name_label.setText("");
        this.other_user_lb.setText("");
        this.other_user_lb2.setText("");

        repaint();
        revalidate();
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        if (jogador.isIsEspectador()) {
            hit_btn.setVisible(false);
            stand_btn.setVisible(false);
            coins_img.setVisible(false);
            dealer_label.setText("Dealer");

            setComponentZOrder(dealer_label, 0);
            setComponentZOrder(name_label, 0);
        } else {
            dealer_label.setText("Dealer");
            coins_img.setVisible(true);
            hit_btn.setVisible(true);
            stand_btn.setVisible(true);

            setComponentZOrder(hit_btn, 0);
            setComponentZOrder(stand_btn, 0);
            setComponentZOrder(coins_img, 0);
            setComponentZOrder(dealer_label, 0);
            setComponentZOrder(name_label, 0);
        }

    }

    public void atualizarTurno(boolean isPlaying) {
        hit_btn.setVisible(true);
        stand_btn.setVisible(true);
        coins_img.setVisible(true);
        hit_btn.setEnabled(isPlaying);
        stand_btn.setEnabled(isPlaying);
    }

    public void indicarVez(String nome) {
        turn_label.setVisible(true);
        turn_label.setText("É A VEZ DO " + nome);
        setComponentZOrder(turn_label, 0);

    }

    public void indicarMeioRounda(String aviso) {
        turn_label.setVisible(true);
        turn_label.setText(aviso);
        valorCartasDealer_lb.setVisible(false);
        valorCartas_lb.setVisible(false);
        setComponentZOrder(turn_label, 0);
    }

    public void indicarPerdeu() {
        if (this.timer != null) {
            this.timer.desligarTimer();
        }
        lose_label.setText("BUSTED!");
        lose_label.setVisible(true);
        setComponentZOrder(lose_label, 0);
    }

    public void indicarFichas(String numeroFichas) {
        coins_img.setText(numeroFichas);
        setComponentZOrder(coins_img, 0);
    }

    public void iniciarTimer() {
        this.timer = new TimerRound(this);
        timer.comecarTimer();
    }

    public void apresentarTimer(int numero) {
        String num = Integer.toString(numero);

        this.timer_label.setText(num);
        setComponentZOrder(this.timer_label, 0);
    }

    public void nomesValoresJogadores(String userPrincipal, String user2, String user3, String valorCartas, String valorCartasDealer) {
        name_label.setText("User: " + userPrincipal);
        valorCartasDealer_lb.setText(valorCartasDealer);
        valorCartas_lb.setText(valorCartas);
        setComponentZOrder(valorCartas_lb, 0);
        setComponentZOrder(valorCartasDealer_lb, 0);

        if (!user2.equalsIgnoreCase("")) {
            other_user_lb2.setText("User: " + user2);
            setComponentZOrder(other_user_lb2, 0);
        }

        if (!user3.equalsIgnoreCase("")) {
            other_user_lb.setText("User: " + user3);
            setComponentZOrder(other_user_lb, 0);
        }
    }

    public void apresentarMensagens(String mensagem) {
        if(mensagem.contains("COMECOU")){
            this.mensagens_AreaText.setText("");
            int indexMensagem = mensagem.indexOf(":");
            String msg = "Dealer -> " + mensagem.substring(indexMensagem + 1, mensagem.length()) + "\n"; 
            this.mensagens_AreaText.append(msg);
            return;
        }
        String texto = "Dealer -> " + mensagem + "\n";
        this.mensagens_AreaText.append(texto);
    }

    public void playAgain() {
        if (this.timer != null) {
            this.timer_label.setText("");
            this.timer.desligarTimer();
        }

        this.hit_btn.setEnabled(false);
        this.stand_btn.setEnabled(false);
        this.playAgain_btn.setVisible(true);
        this.playAgain_btn.setEnabled(true);
        this.valorCartas_lb.setVisible(true);
        this.valorCartasDealer_lb.setVisible(true);
        setComponentZOrder(playAgain_btn, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        dealer_label = new javax.swing.JLabel();
        coins_img = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        turn_label = new javax.swing.JLabel();
        lose_label = new javax.swing.JLabel();
        other_user_lb = new javax.swing.JLabel();
        other_user_lb2 = new javax.swing.JLabel();
        valorCartasDealer_lb = new javax.swing.JLabel();
        hit_btn = new javax.swing.JButton();
        stand_btn = new javax.swing.JButton();
        valorCartas_lb = new javax.swing.JLabel();
        playAgain_btn = new javax.swing.JButton();
        timer_label = new javax.swing.JLabel();
        quit_btn = new javax.swing.JButton();
        label_background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensagens_AreaText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        dealer_label.setBackground(new java.awt.Color(255, 255, 255));
        dealer_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dealer_label.setForeground(new java.awt.Color(255, 255, 255));
        dealer_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dealer_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        coins_img.setBackground(new java.awt.Color(255, 255, 255));
        coins_img.setForeground(new java.awt.Color(255, 255, 255));
        coins_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coins_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/poker-chip .png"))); // NOI18N
        coins_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        name_label.setBackground(new java.awt.Color(255, 255, 255));
        name_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name_label.setForeground(new java.awt.Color(255, 255, 255));
        name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        turn_label.setBackground(new java.awt.Color(255, 255, 255));
        turn_label.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        turn_label.setForeground(new java.awt.Color(255, 255, 255));
        turn_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turn_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lose_label.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        lose_label.setForeground(new java.awt.Color(204, 0, 0));
        lose_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lose_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        other_user_lb.setBackground(new java.awt.Color(255, 255, 255));
        other_user_lb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        other_user_lb.setForeground(new java.awt.Color(255, 255, 255));
        other_user_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        other_user_lb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        other_user_lb2.setBackground(new java.awt.Color(255, 255, 255));
        other_user_lb2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        other_user_lb2.setForeground(new java.awt.Color(255, 255, 255));
        other_user_lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        other_user_lb2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        valorCartasDealer_lb.setBackground(new java.awt.Color(255, 255, 255));
        valorCartasDealer_lb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        valorCartasDealer_lb.setForeground(new java.awt.Color(255, 255, 255));
        valorCartasDealer_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorCartasDealer_lb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        hit_btn.setBackground(new java.awt.Color(46, 139, 87));
        hit_btn.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        hit_btn.setForeground(new java.awt.Color(255, 255, 255));
        hit_btn.setText("Hit");
        hit_btn.setToolTipText("");
        hit_btn.addActionListener(this::hit_btnActionPerformed);

        stand_btn.setBackground(new java.awt.Color(178, 34, 34));
        stand_btn.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        stand_btn.setForeground(new java.awt.Color(255, 255, 255));
        stand_btn.setText("Stand");
        stand_btn.addActionListener(this::stand_btnActionPerformed);

        valorCartas_lb.setBackground(new java.awt.Color(255, 255, 255));
        valorCartas_lb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        valorCartas_lb.setForeground(new java.awt.Color(255, 255, 255));
        valorCartas_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorCartas_lb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        playAgain_btn.setBackground(new java.awt.Color(178, 34, 34));
        playAgain_btn.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        playAgain_btn.setForeground(new java.awt.Color(255, 255, 255));
        playAgain_btn.setText("Play Again");
        playAgain_btn.addActionListener(this::playAgain_btnActionPerformed);

        timer_label.setBackground(new java.awt.Color(255, 255, 255));
        timer_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timer_label.setForeground(new java.awt.Color(255, 255, 255));
        timer_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        quit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quit.png"))); // NOI18N
        quit_btn.setBorderPainted(false);
        quit_btn.setContentAreaFilled(false);
        quit_btn.setFocusPainted(false);
        quit_btn.addActionListener(this::quit_btnActionPerformed);

        label_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bj_table.jpg"))); // NOI18N
        label_background.addHierarchyListener(this::label_backgroundHierarchyChanged);

        mensagens_AreaText.setColumns(20);
        mensagens_AreaText.setRows(5);
        jScrollPane1.setViewportView(mensagens_AreaText);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel1.setText("Game Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(quit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)
                        .addComponent(dealer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(other_user_lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(410, 410, 410)
                        .addComponent(other_user_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(turn_label, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(valorCartas_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(hit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(stand_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(coins_img))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(playAgain_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(lose_label, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(valorCartasDealer_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(667, 667, 667)
                        .addComponent(timer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label_background))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dealer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(other_user_lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(other_user_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(turn_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(valorCartas_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coins_img)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stand_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10)
                                .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(playAgain_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(276, 276, 276)
                                .addComponent(lose_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(valorCartasDealer_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(436, 436, 436)
                                .addComponent(timer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_background, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void label_backgroundHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_label_backgroundHierarchyChanged

    }//GEN-LAST:event_label_backgroundHierarchyChanged

    private void stand_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stand_btnActionPerformed
        if (this.timer != null) {
            this.timer.desligarTimer();
        }
        try {
            this.objDealer.jogadorPediuStand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_stand_btnActionPerformed

    private void hit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hit_btnActionPerformed
        try {
            this.objDealer.jogadorPediuHit(this.meuID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_hit_btnActionPerformed


    private void playAgain_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgain_btnActionPerformed

        try {
            this.objDealer.iniciarJogo();
            this.playAgain_btn.setVisible(false);
            this.playAgain_btn.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_playAgain_btnActionPerformed

    private void quit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quit_btnActionPerformed
        Object[] options = {"Sair do Jogo", "Espetador"};
        int n = JOptionPane.showOptionDialog(this, "Deseja Sair do Jogo?", "Sair do Jogo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Sair do Jogo?", "Sair", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    this.objDealer.logout(this.meuID);
                    System.exit(0);
                } catch (RemoteException e) {
                    System.out.println(e);
                }
            } else if (confirm == JOptionPane.NO_OPTION) {
            }

        } else if (n == 1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Ir para Espetador?", "Espetador", JOptionPane.YES_NO_OPTION);
            int respostaEspetador = 0;
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    respostaEspetador = this.objDealer.passarEspetador(this.meuID);
                } catch (RemoteException e) {
                    System.out.println(e);
                }
                if (respostaEspetador == UNICO_MESA) {
                    JOptionPane.showMessageDialog(this, "É o unico jogador na mesa.", "Passar Espetador", JOptionPane.PLAIN_MESSAGE);
                } else if (respostaEspetador == SUCC) {
                    JOptionPane.showMessageDialog(this, "Passou a espetador.", "Passar Espetador", JOptionPane.PLAIN_MESSAGE);
                }
            } else if (confirm == JOptionPane.NO_OPTION) {
            }
        }
    }//GEN-LAST:event_quit_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coins_img;
    private javax.swing.JLabel dealer_label;
    private javax.swing.JButton hit_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel lose_label;
    private javax.swing.JTextArea mensagens_AreaText;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel other_user_lb;
    private javax.swing.JLabel other_user_lb2;
    private javax.swing.JButton playAgain_btn;
    private javax.swing.JButton quit_btn;
    private javax.swing.JButton stand_btn;
    private javax.swing.JLabel timer_label;
    private javax.swing.JLabel turn_label;
    private javax.swing.JLabel valorCartasDealer_lb;
    private javax.swing.JLabel valorCartas_lb;
    // End of variables declaration//GEN-END:variables

}
