package Object;

import java.sql.Date;
import java.util.*;

//Classe qui définit les fonctions d'une phase
public class PhaseDePoule {

	private boolean elim;
	private Tournoi tournoi;
	private List<Match> matchs;
	private List<Map<Equipe,Integer>> poules;

	//Constructeur de la classe "Phase"
	public PhaseDePoule(boolean elim, Tournoi tournoi) {
		this.elim = elim;
		this.tournoi = tournoi;
		this.matchs = new ArrayList<>();
		this.poules = new ArrayList<>();
	}

	public List<Map<Equipe, Integer>> getPoules() {
		return poules;
	}

	public List<Equipe> getClassement(int poule) {
		List<Equipe> res = new ArrayList<Equipe>();
		res.addAll(poules.get(poule).keySet());

		Collections.sort(res,new Comparator<Equipe> (){
			public int compare(Equipe a, Equipe b) {
			if (poules.get(poule).get(a) >= poules.get(poule).get(b)) {
				return -1;
			} else {
				return 1;
			}
		}});
				return res;
	}

	public void genererPoules() throws Exception {
		List<Equipe> listEquipe = tournoi.getListeEquipe();
		if(isElim() && listEquipe.size()< 16) {
			throw  new Exception("Pas assez d'equipes");
		}
		Collections.shuffle(tournoi.getListeEquipe());
		for (int i = 0; i < 4; i++) {
			poules.add(new HashMap<Equipe, Integer>());
			for (int j =0;  j<4;j++) {
				poules.get(i).put(listEquipe.get(i*4+j),0);
			}
		}
		this.genererMatchs();
	}

	private void genererMatchs() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tournoi.getDateTournoi());
		calendar.add(Calendar.DATE,-1);
		List<List<Equipe[]>> paires = new ArrayList<List<Equipe[]>>();
		for (int i = 0; i < 4; i++) {
			List<Equipe> listEquipePoule = new ArrayList(poules.get(i).keySet());
			Collections.shuffle(listEquipePoule);
			List<Equipe[]>paire = new ArrayList<>();
			paires.add(paire);
			for (int j = 0; j < 3; j++) {
				for (int k = j+1; k <4 ; k++) {
					paire.add(new Equipe[] {listEquipePoule.get(j),listEquipePoule.get(k)} );
				}
			}
			Collections.shuffle(paire);
		}
		for (int i = 0; i <6; i++) {
			calendar.add(Calendar.DATE,1);
			for (int j = 0; j < 4; j++) {
				Equipe equipe1 = paires.get(j).get(i)[0];
				Equipe equipe2 = paires.get(j).get(i)[1];
				Match match = new Match(new Date(calendar.getTime().getTime()),equipe1,equipe2,this);
				matchs.add(match);
			}
		}
	}

	public String toStringPoule() {
		String res = "";
		int i = 0;
		for (Map<Equipe,Integer> map:
			 poules) {
			res+= "Poule "+i+"\n";
			for (Equipe e:
				 map.keySet()) {
				res+= e.getNom()+" "+map.get(e)+"\n";
			}
			res+="\n";
			i++;
		}
		return res;
	}

	public void enregistrerGagnant(int poule, Match m,int gagnant) {
		if (matchs.contains(m)) {
			m.setWinner(gagnant);
			Equipe egagnante = m.getWinner();
			poules.get(poule).put(egagnante,poules.get(poule).get(egagnante)+1);
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

	public Match getMatch(int i) {
		return matchs.get(i);
	}

	public int getId() {
		return 0;
	}

	@Override
	public String toString() {
		return "Phase{" +
				"elim=" + elim +
				", matchs=\n" + matchs +
				", \n" + toStringPoule() +
				'}';
	}
}
