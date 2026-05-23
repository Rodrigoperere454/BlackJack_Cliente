package View;

import Controller.InterfaceJogador;
import Model.Jogador;
import Model.JogadorRemote;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JogoBlackJackPanel extends javax.swing.JPanel {

    private Jogador jogador;
    private InterfaceJogador objDealer;
    private int meuID;

    public JogoBlackJackPanel(InterfaceJogador objDealer) {
        initComponents();
        this.objDealer = objDealer;
        hit_btn.setVisible(false);
        stand_btn.setVisible(false);
        coins_img.setVisible(false);
        turn_label.setVisible(false);

    }

    public void setJogadorID(int id) {
        this.meuID = id;
    }

    public Jogador getJogador() {
        return jogador;
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

        coins_img.setText(String.valueOf(jogador.getNumeroFichas()));
        name_label.setText("User: " + jogador.getNome());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        dealer_label = new javax.swing.JLabel();
        hit_btn = new javax.swing.JButton();
        stand_btn = new javax.swing.JButton();
        coins_img = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        turn_label = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        dealer_label.setBackground(new java.awt.Color(255, 255, 255));
        dealer_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dealer_label.setForeground(new java.awt.Color(255, 255, 255));
        dealer_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dealer_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
        turn_label.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        turn_label.setForeground(new java.awt.Color(255, 255, 255));

        label_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bj_table.jpg"))); // NOI18N
        label_background.addHierarchyListener(this::label_backgroundHierarchyChanged);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(coins_img))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(dealer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(hit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(turn_label, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_background, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(stand_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_background, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(370, 370, 370)
                            .addComponent(coins_img))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(dealer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(turn_label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(190, 190, 190)
                                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(140, 140, 140)
                                    .addComponent(hit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(140, 140, 140)
                                    .addComponent(stand_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(10, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coins_img;
    private javax.swing.JLabel dealer_label;
    private javax.swing.JButton hit_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel name_label;
    private javax.swing.JButton stand_btn;
    private javax.swing.JLabel turn_label;
    // End of variables declaration//GEN-END:variables
}
