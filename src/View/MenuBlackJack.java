package View;

import View.JogoBlackJackPanel;
import Model.JogadorRemote;
import Model.Jogador;
import Controller.InterfaceJogador;
import java.awt.Image;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.ImageIcon;
import javax.swing.*;

public class MenuBlackJack extends javax.swing.JFrame {

    private InterfaceJogador objJogador;
    private JogadorRemote jogadorcb;
    private JogoBlackJackPanel janelaJogo;
    
    final static int NOME_IGUAL = 0;
    final static int A_JOGAR = 1;
    final static int EM_RONDA = 2;
    final static int EM_ESP = 3;
    

    public MenuBlackJack() {
        initComponents();
        ImageIcon logoMenu = new ImageIcon(getClass().getResource("../Images/game.png"));
        label_logo.setIcon(logoMenu);
        this.pack();
        jogar_btn.setEnabled(false);
        quit_btn.setEnabled(false);
        
        this.setLocationRelativeTo(null);
        
        Image logoApp = new ImageIcon(getClass().getResource("../Images/game.png")).getImage();
        setIconImage(logoApp);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ip_textField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        port_textField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        connect_btn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        quit_btn = new javax.swing.JButton();
        jogar_btn = new javax.swing.JButton();
        label_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlackJack99");

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setText("BlackJack");

        ip_textField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ip_textField.setText("localhost");
        ip_textField.setToolTipText("Digite o IP do servidor");
        ip_textField.addActionListener(this::ip_textFieldActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("IP");

        port_textField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        port_textField.setText("1099");
        port_textField.setToolTipText("Digite o porto do servidor");
        port_textField.addActionListener(this::port_textFieldActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Port");

        connect_btn.setText("Conectar");
        connect_btn.addActionListener(this::connect_btnActionPerformed);

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel4.setText("MENU");

        quit_btn.setText("QUIT");
        quit_btn.addActionListener(this::quit_btnActionPerformed);

        jogar_btn.setText("JOGAR");
        jogar_btn.addActionListener(this::jogar_btnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ip_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(port_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(connect_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_logo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jogar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(port_textField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ip_textField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connect_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jogar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ip_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ip_textFieldActionPerformed

    private void port_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_port_textFieldActionPerformed

    private void connect_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_btnActionPerformed

        int port = 0;
        if (ip_textField.getText().isEmpty() || port_textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deve preencher o ip e o porto do servidor.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String host = ip_textField.getText();
                port = Integer.parseInt(port_textField.getText());

                Registry reg = LocateRegistry.getRegistry(host, port);

                this.objJogador = (InterfaceJogador) reg.lookup("gestorBJ");
                this.janelaJogo = new JogoBlackJackPanel(this.objJogador);
                JOptionPane.showMessageDialog(this, "Conectado ao servidor com sucesso.", "Sucesso", JOptionPane.WARNING_MESSAGE);

                jogar_btn.setEnabled(true);
                quit_btn.setEnabled(true);
                connect_btn.setEnabled(false);

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao servidor", "Erro", JOptionPane.WARNING_MESSAGE);

            }
        }
    }//GEN-LAST:event_connect_btnActionPerformed

    private void quit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quit_btnActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Desconectar do servidor?", "Sair", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

            } else if (confirm == JOptionPane.NO_OPTION) {
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao sair do servidor.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_quit_btnActionPerformed
 
    private void abrirJogo(Jogador jogador){
        janelaJogo.setJogador(jogador);
        setContentPane(janelaJogo);
           revalidate();
           repaint();
           pack();
    }
    
    private void jogar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogar_btnActionPerformed

        String nome = (String) JOptionPane.showInputDialog(this, "Digite um nome para jogar");
        if (nome == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deve preencher o seu nome.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                this.jogadorcb = new JogadorRemote(this.janelaJogo);
                Jogador jogadorBlack = new Jogador(nome, this.jogadorcb);
                this.setTitle("BlackJack99 - " + jogadorBlack.getNome());
                int respostaLogin = objJogador.login(jogadorBlack);
                
                if (respostaLogin == NOME_IGUAL){
                    JOptionPane.showMessageDialog(this, "Já existe um jogador com esse nome.", "Warning", JOptionPane.WARNING_MESSAGE);
                }else if(respostaLogin == A_JOGAR){
                    jogadorBlack.setIsEspectador(false);
                    JOptionPane.showMessageDialog(this, "Sucesso, Entrou como jogador.", "Warning", JOptionPane.WARNING_MESSAGE);
                    abrirJogo(jogadorBlack);
                    this.objJogador.iniciarJogo();
                }else if(respostaLogin == EM_RONDA){
                     jogadorBlack.setIsEspectador(true);
                     JOptionPane.showMessageDialog(this, "Sucesso, Entrou como jogador, mas tem de esperar a ronda acabar", "Warning", JOptionPane.WARNING_MESSAGE);
                     abrirJogo(jogadorBlack);
                }else if(respostaLogin == EM_ESP){
                    jogadorBlack.setIsEspectador(true);
                    JOptionPane.showMessageDialog(this, "Entrou como espectador.", "Warning", JOptionPane.WARNING_MESSAGE);
                    abrirJogo(jogadorBlack);

                }
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Não foi possivel iniciar o jogo.", "Erro", JOptionPane.WARNING_MESSAGE);

            }

        }
    }//GEN-LAST:event_jogar_btnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new MenuBlackJack().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect_btn;
    private javax.swing.JTextField ip_textField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jogar_btn;
    private javax.swing.JLabel label_logo;
    private javax.swing.JTextField port_textField;
    private javax.swing.JButton quit_btn;
    // End of variables declaration//GEN-END:variables
}
