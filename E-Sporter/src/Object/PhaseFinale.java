package Object;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PhaseFinale extends Phase{
    private Calendar datephasefinale;
    private PhaseDePoule phaseDePoule;
    private List<Match> matchsAJouer;
    private boolean finale;


    public PhaseFinale(Tournoi tournoi,PhaseDePoule phaseDePoule) {
        super(tournoi);
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
                    matchsAJouer.add(new Match(new Date(datephasefinale.getTime().getTime()),phaseDePoule.getPremier(j+2*i),phaseDePoule.getDeuxième(3-j-2*i),this));
                }
            }
            getMatchs().addAll(matchsAJouer);
        }
        else {
            if (matchsFinis() && !finale) {
                List<Match> nouveauxMatchs = new ArrayList<>();
                int size = matchsAJouer.size();
                System.out.println("match a jouer "+size);
                // si il reste deux matchs génère la petite finale
                if (size ==2) {
                    System.out.println("pf");
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
                getMatchs().addAll(matchsAJouer);
            }
            else {
                System.out.println(""+matchsFinis()+finale);
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

    public boolean estFinie () {
        return finale && matchsFinis();
    }


    public List<Match> getMatchsAJouer() {
        return matchsAJouer;
    }

    public Equipe[] getClassement() throws Exception {
        if (!estFinie()) {
            throw new Exception("le tournoi n'est pas fini");
        }
        Equipe[] res = new Equipe[4];
        res[0] = getMatch(7).getWinner();
        res[1] = getMatch(7).getLoser();
        res[2] = getMatch(6).getWinner();
        res[3] = getMatch(6).getWinner();
        return res;
    }

    @Override
    public boolean isElim() {
        return true;
    }
}
