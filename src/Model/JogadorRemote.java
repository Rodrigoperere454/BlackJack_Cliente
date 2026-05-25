package Model;

import Model.Card;
import Model.CardLabel;
import Controller.InterfaceJogadorCB;
import View.JogoBlackJackPanel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JogadorRemote extends UnicastRemoteObject implements InterfaceJogadorCB {

    private JogoBlackJackPanel janelaJogo;
    private int meuID;
    
    private List<CardLabel> cardLabels = new ArrayList<CardLabel>();


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
    public void limparCardLabels(){
        this.janelaJogo.limparCartas();
    }

    @Override
    public void atualizarJanelaJogo(Jogador jogador1, Jogador jogador2, Jogador jogador3, List<Card> cartasDealer) {

        int positionXJogador1 = 0;
        int positionYJogador1 = 0;
        String nomeUserMain = "";

        int positionXJogador2 = 0;
        int positionYJogador2 = 0;
        String nomeUser2 = "";

        int positionXJogador3 = 0;
        int positionYJogador3 = 0;
        String nomeUser3 = "";

        int valorCartas = 0;
        int valorCartasDealer = 0;
        String minhasFichas = "";
        if (jogador1.getId() == meuID) {
            positionXJogador1 = 300;
            positionYJogador1 = 250;
            nomeUserMain = jogador1.getNome();
            try {
                minhasFichas = Integer.toString(jogador1.getNumeroFichas());
            } catch (Exception e) {
                System.out.println(e);
            }

            positionXJogador2 = 40;
            positionYJogador2 = 150;
            if (jogador2 != null) {
                nomeUser2 = jogador2.getNome();
            }
            positionXJogador3 = 560;
            positionYJogador3 = 150;
            if (jogador3 != null) {
                nomeUser3 = jogador3.getNome();
            }

            valorCartas = jogador1.getValorCartas();
        } else if (jogador2.getId() == meuID) {
            positionXJogador2 = 300;
            positionYJogador2 = 250;
            nomeUserMain = jogador2.getNome();
            try {
                minhasFichas = Integer.toString(jogador2.getNumeroFichas());
            } catch (Exception e) {
                System.out.println(e);
            }

            positionXJogador1 = 40;
            positionYJogador1 = 150;
            if (jogador1 != null) {
                nomeUser2 = jogador1.getNome();
            }
            positionXJogador3 = 560;
            positionYJogador3 = 150;
            if (jogador3 != null) {
                nomeUser3 = jogador3.getNome();
            }

            valorCartas = jogador2.getValorCartas();
        } else {
            positionXJogador3 = 300;
            positionYJogador3 = 250;
            nomeUserMain = jogador3.getNome();
            try {
                minhasFichas = Integer.toString(jogador3.getNumeroFichas());
            } catch (Exception e) {
                System.out.println(e);
            }
            positionXJogador2 = 40;
            positionYJogador2 = 150;
            if (jogador2 != null) {
                nomeUser2 = jogador2.getNome();
            }

            positionXJogador1 = 560;
            positionYJogador1 = 150;
            if (jogador1 != null) {
                nomeUser3 = jogador1.getNome();
            }

            valorCartas = jogador3.getValorCartas();
        }

        String valorCartasStr = "";
        try {
            valorCartasStr = Integer.toString(valorCartas);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Card c : cartasDealer) {
            valorCartasDealer += c.getValue();
        }

        String valorCartasDealerStr = "";
        try {
            valorCartasDealerStr = Integer.toString(valorCartasDealer);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            valorCartasStr = Integer.toString(valorCartas);
        } catch (Exception e) {
            System.out.println(e);
        }
        this.janelaJogo.nomesValoresJogadores(nomeUserMain, nomeUser2, nomeUser3, valorCartasStr, valorCartasDealerStr);
        this.janelaJogo.indicarFichas(minhasFichas);

        if (jogador1 != null) {
            for (int i = 0; i < jogador1.getCartas().size(); i++) {
                CardLabel cardLabel1 = new CardLabel();
                cardLabel1.setCardImage(jogador1.getCartas().get(i).getName());
                if (i != jogador1.getCartas().size() - 1) {
                    cardLabel1.setCardCovered(true);
                } else {
                    cardLabel1.setCardCovered(false);
                }
                cardLabels.add(cardLabel1);
                cardLabel1.setLocation(positionXJogador1 + (i * 20), positionYJogador1);
                this.janelaJogo.adicionarCarta(cardLabel1);
                //this.janelaJogo.add(cardLabel1);
                //this.janelaJogo.setComponentZOrder(cardLabel1, 0);
            }
        }

        if (jogador2 != null) {
            for (int i = 0; i < jogador2.getCartas().size(); i++) {
                CardLabel cardLabel2 = new CardLabel();
                cardLabel2.setCardImage(jogador2.getCartas().get(i).getName());
                if (i != jogador2.getCartas().size() - 1) {
                    cardLabel2.setCardCovered(true);
                } else {
                    cardLabel2.setCardCovered(false);
                }
                cardLabels.add(cardLabel2);
                cardLabel2.setLocation(positionXJogador2 + (i * 20), positionYJogador2);
                this.janelaJogo.adicionarCarta(cardLabel2);
                //this.janelaJogo.add(cardLabel2);
                //this.janelaJogo.setComponentZOrder(cardLabel2, 0);
            }
        }

        if (jogador3 != null) {
            for (int i = 0; i < jogador3.getCartas().size(); i++) {
                CardLabel cardLabel3 = new CardLabel();
                cardLabel3.setCardImage(jogador3.getCartas().get(i).getName());
                if (i != jogador3.getCartas().size() - 1) {
                    cardLabel3.setCardCovered(true);
                } else {
                    cardLabel3.setCardCovered(false);
                }
                cardLabels.add(cardLabel3);
                cardLabel3.setLocation(positionXJogador3 + (i * 20), positionYJogador3);
                this.janelaJogo.adicionarCarta(cardLabel3);
                //this.janelaJogo.add(cardLabel3);
                //this.janelaJogo.setComponentZOrder(cardLabel3, 0);
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
                this.janelaJogo.adicionarCarta(cardLabel4);
                //this.janelaJogo.add(cardLabel4);
                //this.janelaJogo.setComponentZOrder(cardLabel4, 0);
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

    @Override
    public void meioRounda() throws RemoteException {
        String meioRounda = "Espere a Rounda acabar";
        this.janelaJogo.indicarMeioRounda(meioRounda);
    }

    @Override
    public void playAgain() throws RemoteException {
        this.janelaJogo.playAgain();
    }
}
