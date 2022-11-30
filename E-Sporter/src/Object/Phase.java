package Object;

import java.util.ArrayList;
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

	private void genererPoules() throws Exception {
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
	}

	public void genererMatchs() {
		
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

}
