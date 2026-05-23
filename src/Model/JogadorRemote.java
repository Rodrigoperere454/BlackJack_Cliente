package Model;

import Model.Card;
import Model.CardLabel;
import Controller.InterfaceJogadorCB;
import View.JogoBlackJackPanel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JogadorRemote extends UnicastRemoteObject implements InterfaceJogadorCB {

    private JogoBlackJackPanel janelaJogo;
    private int meuID;
    private Jogador jogador;
    private Card card;

    public JogadorRemote(JogoBlackJackPanel janela) throws RemoteException {
        this.janelaJogo = janela;
    }

    public JPanel getJanelaJogo() {
        return janelaJogo;
    }

    public void setJanelaJogo(JogoBlackJackPanel janelaJogo) {
        this.janelaJogo = janelaJogo;
    }

    @Override
    public void receberCartasGUI(Card carta1, Card carta2, boolean isJogador) throws RemoteException {
        CardLabel cardLabel1 = new CardLabel();
        cardLabel1.setCardImage(carta1.getName());
        cardLabel1.setCardCovered(true);
        cardLabel1.setLocation(320, 250);
        this.janelaJogo.add(cardLabel1);
        this.janelaJogo.setComponentZOrder(cardLabel1, 0);

        CardLabel cardLabel2 = new CardLabel();
        cardLabel2.setCardImage(carta2.getName());
        cardLabel2.setCardCovered(false);
        cardLabel2.setLocation(340, 250);
        this.janelaJogo.add(cardLabel2);
        this.janelaJogo.setComponentZOrder(cardLabel2, 0);

        janelaJogo.revalidate();

    }

    @Override
    public void receberCartasDealer(Card carta1) throws RemoteException {
        // cartas do dealer
        CardLabel cardLabel1 = new CardLabel();
        cardLabel1.setCardImage(carta1.getName());
        cardLabel1.setCardCovered(true);
        cardLabel1.setLocation(320, 40);
        System.out.println(cardLabel1.getSize());
        this.janelaJogo.add(cardLabel1);
        this.janelaJogo.setComponentZOrder(cardLabel1, 0);

        CardLabel cardLabel2 = new CardLabel();
        cardLabel2.setCardImage("bv");
        cardLabel2.setCardCovered(false);
        cardLabel2.setLocation(340, 40);
        this.janelaJogo.add(cardLabel2);
        this.janelaJogo.setComponentZOrder(cardLabel2, 0);
    }

    @Override
    public void atualizarJanelaJogo(Jogador cartasJogador1, Jogador cartasJogador2, Jogador cartasJogador3, List<Card> cartasDealer) {
        int positionXJogador1 = 0;
        int positionYJogador1 = 0;

        int positionXJogador2 = 0;
        int positionYJogador2 = 0;

        int positionXJogador3 = 0;
        int positionYJogador3 = 0;

        if (cartasJogador1.getId() == meuID) {
            //this.janelaJogo.setJogador(cartasJogador1);
            positionXJogador1 = 300;
            positionYJogador1 = 250;

            positionXJogador2 = 40;
            positionYJogador2 = 150;

            positionXJogador3 = 560;
            positionYJogador3 = 150;

        } else if (cartasJogador2.getId() == meuID) {
            //this.janelaJogo.setJogador(cartasJogador2);
            positionXJogador2 = 300;
            positionYJogador2 = 250;

            positionXJogador1 = 40;
            positionYJogador1 = 150;

            positionXJogador3 = 560;
            positionYJogador3 = 150;
        } else {
            //this.janelaJogo.setJogador(cartasJogador3);
            positionXJogador3 = 300;
            positionYJogador3 = 250;

            positionXJogador2 = 40;
            positionYJogador2 = 150;

            positionXJogador1 = 560;
            positionYJogador1 = 150;

        }

        if (cartasJogador1 != null) {
            for (int i = 0; i < cartasJogador1.getCartas().size(); i++) {
                CardLabel cardLabel1 = new CardLabel();
                cardLabel1.setCardImage(cartasJogador1.getCartas().get(i).getName());
                if (i != cartasJogador1.getCartas().size() - 1) {
                    cardLabel1.setCardCovered(true);
                } else {
                    cardLabel1.setCardCovered(false);
                }
                cardLabel1.setLocation(positionXJogador1 + (i * 20), positionYJogador1);
                this.janelaJogo.add(cardLabel1);
                this.janelaJogo.setComponentZOrder(cardLabel1, 0);
            }
        }

        if (cartasJogador2 != null) {
            for (int i = 0; i < cartasJogador2.getCartas().size(); i++) {
                CardLabel cardLabel2 = new CardLabel();
                cardLabel2.setCardImage(cartasJogador2.getCartas().get(i).getName());
                if (i != cartasJogador2.getCartas().size() - 1) {
                    cardLabel2.setCardCovered(true);
                } else {
                    cardLabel2.setCardCovered(false);
                }
                cardLabel2.setLocation(positionXJogador2 + (i * 20), positionYJogador2);
                this.janelaJogo.add(cardLabel2);
                this.janelaJogo.setComponentZOrder(cardLabel2, 0);
            }
        }

        if (cartasJogador3 != null) {
            for (int i = 0; i < cartasJogador3.getCartas().size(); i++) {
                CardLabel cardLabel3 = new CardLabel();
                cardLabel3.setCardImage(cartasJogador3.getCartas().get(i).getName());
                if (i != cartasJogador3.getCartas().size() - 1) {
                    cardLabel3.setCardCovered(true);
                } else {
                    cardLabel3.setCardCovered(false);
                }
                cardLabel3.setLocation(positionXJogador3 + (i * 20), positionYJogador3);
                this.janelaJogo.add(cardLabel3);
                this.janelaJogo.setComponentZOrder(cardLabel3, 0);
            }
        }

        //Remover a carta virada do dealer se este tiver mais de 2 cartas
        Card removeVerse = null;
        if (cartasDealer.size() > 2) {
            for (Card c : cartasDealer) {
                if (c.getName().equalsIgnoreCase("bv")) {
                    removeVerse = c;
                }
            }

            cartasDealer.remove(removeVerse);
        }

        int positionXDealer = 300;
        int positionYDealer = 40;
        if (cartasDealer != null) {
            for (int i = 0; i < cartasDealer.size(); i++) {
                CardLabel cardLabel4 = new CardLabel();
                cardLabel4.setCardImage(cartasDealer.get(i).getName());
                if (i != cartasDealer.size() - 1) {
                    cardLabel4.setCardCovered(true);
                } else {
                    cardLabel4.setCardCovered(false);
                }
                cardLabel4.setLocation(positionXDealer + (i * 20), positionYDealer);
                this.janelaJogo.add(cardLabel4);
                this.janelaJogo.setComponentZOrder(cardLabel4, 0);
            }
        }

        this.janelaJogo.revalidate();
        this.janelaJogo.repaint();

    }

    @Override
    public void setIDjogador(int id) throws RemoteException {
        this.meuID = id;
        this.janelaJogo.setJogadorID(id);
    }


    @Override
    public void receberTurno(int id, String nome) {
            if (this.meuID == id) {
                this.janelaJogo.atualizarTurno(true);
            } else {
                this.janelaJogo.atualizarTurno(false);
            }

            this.janelaJogo.indicarVez(nome);

            this.janelaJogo.revalidate();
  
    }

    @Override
    public void indicarPerdeu() throws RemoteException {
        this.janelaJogo.indicarPerdeu();
        this.janelaJogo.atualizarTurno(false);
    }
}