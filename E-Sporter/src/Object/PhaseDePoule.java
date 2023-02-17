package Object;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

//Classe qui définit les fonctions d'une phase
public class PhaseDePoule extends Phase {

	private List<Map<Equipe,Integer>> poules;
	private static final int NB_POULES = 4;

	/**
	 * Constructeur de la classe "Phase"
	 * @param tournoi
	 */
	public PhaseDePoule( Tournoi tournoi) {
		super(tournoi);
		this.poules = new ArrayList<>();
	}
	
	/**
	 * Récupere la liste des poules
	 * @return
	 */
	public List<Map<Equipe, Integer>> getPoules() {
		return poules;
	}
	
	/**
	 * Récupere le classement
	 * @param poule
	 * @return
	 */
	private List<Equipe> getClassement(int poule) {
		List<Equipe> res = new ArrayList<Equipe>();
		System.out.println(poules);
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
	
	/**
	 * Modification des poules d'un match
	 */
	public void setPoulesFromMatchs() {
		List<Equipe> participants = new ArrayList<>();
		List<Equipe> verifies = new ArrayList<>();
		if (!getMatchs().isEmpty()) {
			for (int i = 0; i < NB_POULES; i++) {
				List<Match> filtreMatch = getMatchs().stream().filter((m)-> !participants.contains(m.getEquipe1()) && !participants.contains(m.getEquipe2())).collect(Collectors.toList());
				Match match1 = filtreMatch.stream().findFirst().get();
				Equipe equipe = match1.getEquipe1();
				verifies.clear();
				poules.add(new HashMap<Equipe,Integer>());
				int finalI;
				finalI = i;
				System.out.println(equipe);
				filtreMatch.stream().filter((m) -> m.getEquipe1() == equipe || m.getEquipe2() == equipe)
						.forEach((m) ->
								{
									List<Match> matchsJoueurs;
									if (m.getEquipe1()== equipe) {
										if (poules.get(finalI).get(m.getEquipe2()) == null ) {
											poules.get(finalI).put(m.getEquipe2(),0);
										}
										matchsJoueurs = matchs.stream().filter((me) -> me.getEquipe1() == m.getEquipe2() && !verifies.contains(me.getEquipe2())|| me.getEquipe2() == m.getEquipe2() && !verifies.contains(me.getEquipe1())).collect(Collectors.toList());
										verifies.add(m.getEquipe2());
										participants.add(m.getEquipe2());
										setPoule(finalI,matchsJoueurs);
									}
									else {
										if (poules.get(finalI).get(m.getEquipe1()) == null ) {
											poules.get(finalI).put(m.getEquipe1(),0);
										}
										matchsJoueurs = matchs.stream().filter((me) -> (me.getEquipe2() == m.getEquipe1() && !verifies.contains(me.getEquipe1()) || me.getEquipe1() == m.getEquipe1()) && !verifies.contains(me.getEquipe2())).collect(Collectors.toList());
										verifies.add(m.getEquipe1());
										participants.add(m.getEquipe1());
										setPoule(finalI,matchsJoueurs);
									}
								});
			}
		}

	}
	
	/**
	 * Modification d'un poule
	 * @param poule
	 * @param matchs
	 */
	private void setPoule(int poule, List<Match> matchs) {
		for (Match m : matchs) {
			enregistrerGagnant(poule,m);
		}
	}
	
	/**
	 * Récupere la premiere poule
	 * @param poule
	 * @return
	 */
	public Equipe getPremier(int poule) {
		return this.getClassement(poule).get(0);
	}

	/**
	 * Récupere la deuxième poule
	 * @param poule
	 * @return
	 */
	public Equipe getDeuxième(int poule) {
		return this.getClassement(poule).get(1);
	}
	
	/**
	 * Génere les poules
	 * @throws Exception
	 */
	private void genererPoules() throws Exception {
		List<Equipe> listEquipe = getTournoi().getListeEquipe();
		if(isElim() && listEquipe.size()< 16) {
			throw new Exception("Pas assez d'equipes");
		}
		//Sous listes de niveaux
		@SuppressWarnings("unchecked")
		List<Equipe>[] subLists = new ArrayList[NB_POULES];
		//Tri des equipes par points
		Collections.sort(listEquipe);
		for (int i = 0; i < NB_POULES; i++) {
			subLists[i] = new ArrayList<Equipe>();
			for (int j = 0; j < NB_POULES; j++) {
				//ajout des niveaux
				subLists[i].add(listEquipe.get(i * NB_POULES + j));
			}
			Collections.shuffle(subLists[i]);
		}
		for (int i = 0; i < NB_POULES; i++) {
			poules.add(new HashMap<Equipe, Integer>());
			for (int j =0;  j<NB_POULES;j++) {
				poules.get(i).put(subLists[j].get(i),0);
			}
		}
	}

	/**
	 * Génere les matchs
	 */
	public void genererMatchs() {
		try {
			genererPoules();
		}
		catch (Exception e) {
			System.out.println("Erreur lors de la gen de poule");
			return;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getTournoi().getDateTournoi());
		calendar.add(Calendar.DATE,-1);
		List<List<Equipe[]>> paires = new ArrayList<List<Equipe[]>>();
		for (int i = 0; i < NB_POULES; i++) {
			List<Equipe> listEquipePoule = new ArrayList<>(poules.get(i).keySet());
			Collections.shuffle(listEquipePoule);
			List<Equipe[]>paire = new ArrayList<>();
			paires.add(paire);
			for (int j = 0; j < 3; j++) {
				for (int k = j+1; k <NB_POULES ; k++) {
					paire.add(new Equipe[] {listEquipePoule.get(j),listEquipePoule.get(k)} );
				}
			}
			Collections.shuffle(paire);
		}
		for (int i = 0; i <6; i++) {
			calendar.add(Calendar.DATE,1);
			for (int j = 0; j < NB_POULES; j++) {
				Equipe equipe1 = paires.get(j).get(i)[0];
				Equipe equipe2 = paires.get(j).get(i)[1];
				Match match = new Match(new Date(calendar.getTime().getTime()),equipe1,equipe2,this);
				getMatchs().add(match);
			}
		}
	}
	/**
	 * Transforme une poule en "string"
	 * @return
	 */
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
	
	/**
	 * Enregistre le gagnant
	 * @param poule
	 * @param m
	 */
	public void enregistrerGagnant(int poule, Match m) {
		if (getMatchs().contains(m) && m.getWinner() != null) {
			Equipe egagnante = m.getWinner();
			Map<Equipe,Integer> pouleselect = poules.get(poule);
			if (pouleselect.get(egagnante) == null ) {
				pouleselect.put(egagnante,0);
			}
			if (pouleselect.get(m.getLoser()) == null ) {
				pouleselect.put(m.getLoser(),0);
			}
				pouleselect.put(egagnante, pouleselect.get(egagnante) + 1);
		}
	}
	
	/**
	 * Récupere les match à partir d'un id
	 */
	public void getMatchsFromID() throws Exception {
		super.getMatchsFromID();
		setPoulesFromMatchs();
		System.out.println(toStringPoule());
	}


    /**
     * Permet de savoir si c'est une phase éliminatoire ou pas
     */
	public boolean isElim() {
		return false;
	}
	
	/**
	 * Permet de savoir si les match sont términés
	 */
	@Override
	public boolean matchsFinis() {
		System.out.println(matchs);
		for (Match m :
				matchs) {
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

	/**
	 * Permet de transformer des objets en "string"
	 */
	@Override
	public String toString() {
		return super.toString()+
				", \n" + toStringPoule() +
				'}';
	}
}
