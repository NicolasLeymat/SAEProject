package Object;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

//Classe qui définit les fonctions d'une phase
public class Phase {

	private boolean elim;
	private Tournoi tournoi;
	private List<Match> matchs;
	private List<List<Equipe>> poules;

	//Constructeur de la classe "Phase"
	public Phase(boolean elim, Tournoi tournoi) {
		this.elim = elim;
		this.tournoi = tournoi;
	}

	public void genererPoules() throws Exception {
		List<Equipe> listEquipe = tournoi.getListeEquipe();
		if(isElim() && listEquipe.size()< 16) {
			throw  new Exception("Pas assez d'equipes");
		}
		Collections.shuffle(tournoi.getListeEquipe());
		for (int i = 0; i < 4; i++) {
			poules.add(new ArrayList<Equipe>());
			for (int j =0; j<4;j++) {
				poules.get(i).add(listEquipe.get(i*4+j));
			}
		}
		this.genererMatchs();
	}

	private void genererMatchs() {
		Calendar calendar = Calendar.getInstance();
		tournoi.getDateTournoi();
		calendar.setTime(tournoi.getDateTournoi());
		calendar.add(Calendar.DATE,-1);
		List<List<Integer[]>> paires = new ArrayList<List<Integer[]>>();
		for (int i = 0; i < 4; i++) {
			Collections.shuffle(poules.get(i));
			List<Integer[]>paire = new ArrayList<Integer[]>();
			paires.add(paire);
			for (int j = 0; j < 3; j++) {
				for (int k = j+1; k <4 ; k++) {
					paire.add(new Integer[] {j,k} );
				}
			}
			Collections.shuffle(paire);
		}
		for (int i = 0; i <6; i++) {
			calendar.add(Calendar.DATE,1);
			for (int j = 0; j < 4; j++) {
				Equipe equipe1 = poules.get(j).get(paires.get(j).get(i)[0]);
				Equipe equipe2 = poules.get(j).get(paires.get(j).get(i)[1]);
				Match match = new Match((Date) calendar.getTime(),equipe1,equipe2,this);
				matchs.add(match);
			}
		}
	}


    //Fonction qui permet de savoir si c'est une phase éliminatoire ou pas 
	public boolean isElim() {
		return elim;
	}

    //Fonction qui permet de récuperer le tournoi d'une phase
	public Tournoi getTournoi() {
		return tournoi;
	}
	
	public int getId() {
		return 0;
	}

	@Override
	public String toString() {
		return "Phase{" +
				"elim=" + elim +
				", matchs=" + matchs +
				", poules=" + poules +
				'}';
	}
}
