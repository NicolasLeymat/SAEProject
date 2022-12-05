package Object;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PhaseFinale extends Phase{
    private Calendar datephasefinale;
    private PhaseDePoule phaseDePoule;
    private List<Match> matchsAJouer;
    private List<Match> matchsTermines;
    private boolean finale;


    public PhaseFinale(PhaseDePoule phaseDePoule) {
        super();
        datephasefinale = Calendar.getInstance();
        datephasefinale.setTime(getTournoi().getDateTournoi());
        datephasefinale.add(Calendar.DATE,6);
        this.phaseDePoule = phaseDePoule;
        this.matchsAJouer = new ArrayList<Match>();
        finale = false;
    }


    @Override
    public void genererMatchs()  {
        if (getMatchs().isEmpty()) {

            for (int i = 0; i < 2; i++) {
                datephasefinale.add(Calendar.DATE,1);
                for (int j = 0; j < 2; j++) {
                    matchsAJouer.add(new Match(new Date(datephasefinale.getTime().getTime()),phaseDePoule.getPremier(j+2*i),phaseDePoule.getDeuxième(4-j-2*i),this));
                }
            }
            getMatchs().addAll(matchsAJouer);
        }
        else {
            if (matchsFinis() && !finale) {
                getMatchs().addAll(matchsAJouer);
                List<Match> nouveauxMatchs = new ArrayList<>();
                int size = matchsAJouer.size();
                // si il reste deux matchs génère la petite finale
                if (size ==2) {
                    datephasefinale.add(Calendar.DATE,1);
                    nouveauxMatchs.add(new Match(new Date (datephasefinale.getTime().getTime()),matchsAJouer.get(0).getLoser(),matchsAJouer.get(1).getLoser(),this));
                    finale = true;
                }
                for (int i = 0; i < size; i += 2) {
                    datephasefinale.add(Calendar.DATE,1);
                    //creation de matchs de la phase suivantes
                    nouveauxMatchs.add(new Match(new Date (datephasefinale.getTime().getTime()), matchsAJouer.get(i).getWinner(), matchsAJouer.get(i+1).getWinner(), this));
                }
                matchsAJouer.clear();
                matchsAJouer.addAll(nouveauxMatchs);
            }
        }
    }

    public boolean matchsFinis() {
        for (Match m:
             matchsAJouer) {
            if (m.getWinner() == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isElim() {
        return true;
    }
}
