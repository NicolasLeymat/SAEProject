package Object;

import Application.Connexion;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//Classe qui définit les fonctions d'une phase
public class PhaseDePoule extends Phase {

	private List<Map<Equipe,Integer>> poules;

	//Constructeur de la classe "Phase"
	public PhaseDePoule( Tournoi tournoi) {
		super(tournoi);
		this.poules = new ArrayList<>();
	}




	public List<Map<Equipe, Integer>> getPoules() {
		return poules;
	}

	private List<Equipe> getClassement(int poule) {
		List<Equipe> res = new ArrayList<Equipe>();
		res.addAll(poules.get(poule).keySet());

		Collections.sort(res, (x,y) ->
			 {
			if (poules.get(poule).get(x) >= poules.get(poule).get(y)) {
				return -1;
			} else {
				return 1;
			}
		});
				return res;
	}

	public Equipe getPremier(int poule) {
		return this.getClassement(poule).get(0);
	}

	public Equipe getDeuxième(int poule) {
		return this.getClassement(poule).get(1);
	}

	public void genererPoules() throws Exception {
		List<Equipe> listEquipe = getTournoi().getListeEquipe();
		if(isElim() && listEquipe.size()< 16) {
			throw  new Exception("Pas assez d'equipes");
		}
		//Sous listes de niveaux
		List<Equipe>[] subLists = new ArrayList[4];
		//Tri des equipes par points
		Collections.sort(listEquipe);
		for (int i = 0; i < 4; i++) {
			subLists[i] = new ArrayList<Equipe>();
			for (int j = 0; j < 4; j++) {
				//ajout des niveaux
				subLists[i].add(listEquipe.get(i * 4 + j));
			}
			Collections.shuffle(subLists[i]);
		}
		for (int i = 0; i < 4; i++) {
			poules.add(new HashMap<Equipe, Integer>());
			for (int j =0;  j<4;j++) {
				poules.get(i).put(subLists[i].get(j),0);
			}
		}
		this.genererMatchs();
	}

	public void genererMatchs() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getTournoi().getDateTournoi());
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
				getMatchs().add(match);
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
		if (getMatchs().contains(m)) {
			m.setWinner(gagnant);
			Equipe egagnante = m.getWinner();
			poules.get(poule).put(egagnante,poules.get(poule).get(egagnante)+1);
		}
	}


    //Fonction qui permet de savoir si c'est une phase éliminatoire ou pas 
	public boolean isElim() {
		return false;
	}

	@Override
	public boolean matchsFinis() {
		if (poules.isEmpty()) {
			return false;
		}
		for (Match m :
				getMatchs()) {
			if (m.getWinner() == null)  {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getType() {
		return "Poules";
	}

	//Fonction qui permet de récuperer le tournoi d'une phase






	@Override
	public String toString() {
		return super.toString()+
				", \n" + toStringPoule() +
				'}';
	}
}
