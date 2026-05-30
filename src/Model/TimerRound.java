package Model;

import View.JogoBlackJackPanel;
import java.util.Timer;
import java.util.TimerTask;

public class TimerRound{

    private Timer timer;
    private JogoBlackJackPanel panel;

    public TimerRound(JogoBlackJackPanel panel) {
        this.panel = panel;
    }

    public void desligarTimer() {
        if (this.timer != null) {
            this.timer.cancel();
        }
    }
    
    public void comecarTimer(){
        this.timer = new Timer();
            TimerTask task = new TimerTask() {

                int count = 20;

                @Override
                public void run() {
                    panel.apresentarTimer(count);
                    count--;

                    if (count < 0) {
                        desligarTimer();
                    }

                }
            };

            this.timer.scheduleAtFixedRate(task, 0, 1000);
    }

    }

