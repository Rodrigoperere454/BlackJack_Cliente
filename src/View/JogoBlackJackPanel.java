package View;

import Controller.InterfaceJogador;
import Model.CardLabel;
import Model.Jogador;
import Model.JogadorRemote;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JogoBlackJackPanel extends javax.swing.JPanel {

    private Jogador jogador;
    private InterfaceJogador objDealer;
    private int meuID;
    private List<CardLabel> cartasNaMesa = new ArrayList<CardLabel>();

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
        
        repaint();
        revalidate();
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        if (jogador.isIsEspectador()) {
            hit_btn.setVisible(false);
            stand_btn.setVisible(false);
            coins_img.setVisible(false);
            name_label.setText("");
            dealer_label.setText("");
            return;
        }

        dealer_label.setText("Dealer");

        coins_img.setVisible(true);
        hit_btn.setVisible(true);
        stand_btn.setVisible(true);

        hit_btn.setEnabled(false);
        stand_btn.setEnabled(false);

        setComponentZOrder(hit_btn, 0);
        setComponentZOrder(stand_btn, 0);
        setComponentZOrder(coins_img, 0);
        setComponentZOrder(dealer_label, 0);
        setComponentZOrder(name_label, 0);

    }

    public void atualizarTurno(boolean isPlaying) {
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
        lose_label.setText("BUSTED!");
        lose_label.setVisible(true);
        setComponentZOrder(lose_label, 0);
    }

    public void indicarFichas(String numeroFichas) {
        coins_img.setText(numeroFichas);
        setComponentZOrder(coins_img, 0);
    }

    public void nomesValoresJogadores(String userPrincipal, String user2, String user3, String valorCartas, String valorCartasDealer) {
        name_label.setText("User: " + userPrincipal);
        valorCartasDealer_lb.setText(valorCartasDealer);
        valorCartas_lb.setText(valorCartas);
        setComponentZOrder(valorCartas_lb, 0);
        setComponentZOrder(valorCartasDealer_lb, 0);

        if (!user2.equalsIgnoreCase("")) {
            other_user_lb2.setText(user2);
        }

        if (!user3.equalsIgnoreCase("")) {
            other_user_lb.setText(user3);
        }
    }

    public void playAgain() {
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
        label_background = new javax.swing.JLabel();

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

        label_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bj_table.jpg"))); // NOI18N
        label_background.addHierarchyListener(this::label_backgroundHierarchyChanged);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(valorCartasDealer_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(coins_img))
            .addGroup(layout.createSequentialGroup()
                .addGap(560, 560, 560)
                .addComponent(other_user_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(lose_label, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(other_user_lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label_background))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(turn_label, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(playAgain_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(valorCartas_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(dealer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(hit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(stand_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(valorCartasDealer_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280)
                .addComponent(coins_img))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(other_user_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(lose_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(other_user_lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(label_background, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(turn_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(playAgain_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(valorCartas_lb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(dealer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(hit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(stand_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void label_backgroundHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_label_backgroundHierarchyChanged

    }//GEN-LAST:event_label_backgroundHierarchyChanged

    private void stand_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stand_btnActionPerformed
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coins_img;
    private javax.swing.JLabel dealer_label;
    private javax.swing.JButton hit_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel lose_label;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel other_user_lb;
    private javax.swing.JLabel other_user_lb2;
    private javax.swing.JButton playAgain_btn;
    private javax.swing.JButton stand_btn;
    private javax.swing.JLabel turn_label;
    private javax.swing.JLabel valorCartasDealer_lb;
    private javax.swing.JLabel valorCartas_lb;
    // End of variables declaration//GEN-END:variables
}
