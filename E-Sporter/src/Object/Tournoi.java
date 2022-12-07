package Object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Application.Connexion;

//Classe qui définit les fonctions d'un tournoi
public class Tournoi {

	private int id;
	private String nom;
	private Date dateTournoi;
	private int championnat;
	private int notoriete;
	private int id_organisateur;
	private int id_Mode;
	private List<Equipe> listeEquipe;
	private PhaseDePoule phasePoule;
	private PhaseFinale phaseElim;

	private enum PointsClassement {
		PREMIER(100),DEUXIEME(60),TROISIEME(30),QUATRIEME(10);

		private int points;

		PointsClassement(int nb) {
			this.points = nb;
		}
	}

	//Constructeur de la classe "Tournoi"
	public Tournoi(String nom, Date dateTournoi, int championnat,int notoriete, int id_organisateur, int id_Mode) throws Exception {
		
		if (notoriete > 3 || notoriete < 1) {
			throw new Exception();
		}
		if (dateInvalide(dateTournoi)) {
			throw new Exception();
		}
		
		this.nom = nom;
		this.dateTournoi = dateTournoi;
		this.championnat = championnat;
		this.notoriete = notoriete;
		this.id_organisateur = id_organisateur;
		this.listeEquipe = new ArrayList<Equipe>();
		this.phasePoule = new PhaseDePoule(this);
		this.phaseElim = new PhaseFinale(this,phasePoule);
		this.id_Mode = id_Mode;
		this.id = -1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    //Fonction qui permet de récuperer le nom d'un tournoi
	public String getNom() {
		return nom;
	}
	
	//Fonction qui permet de récuperer une équipe d'un tournoi
	public Equipe getEquipe (String nom) {
		for (Equipe e : this.listeEquipe) {
			if (e.getNom() == nom) {
				return e;
			}
		}
		return null;
	}

	public PhaseDePoule getPhasePoule() {
		return phasePoule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//Fonction qui permet de récuperer la date d'un tournoi
	public Date getDateTournoi() {
		return dateTournoi;
	}
	
	//Fonction qui permet de changer la date d'un tournoi
	public void setDateTournoi(Date dateTournoi) {
		this.dateTournoi = dateTournoi;
	}

	//Fonction qui permet de récuperer la notoriété d'un tournoi
	public int getNotoriete() {
		return notoriete;
	}
	
	//Fonction qui permet de récuperer le championnat d'un tournoi
		public int getChampionnat() {
			return this.championnat;
		}

	//Fonction qui permet de changer la notoriété
	public void setNotoriete(int notoriete) {
		this.notoriete = notoriete;
	}
	
	//Fonction qui permet de récuperer l'identifiant de l'organisateur d'un tournoi
	public int getId_Organisateur() {
		return id_organisateur;
	}

	//Fonction qui permet de récuperer l'identifiant du mode de jeu d'un tournoi
	public int getId_Mode() {
		return id_Mode;
	}

	//Fonction qui permet d'ajouter une équipe à un tournoi
	public void addEquipe(Equipe equipe) throws Exception{
		if (this.listeEquipe.size()>=16) {
			throw new Exception();
		}
		if (dateInvalide(this.dateTournoi)==true) {
			throw new Exception();
		}
		this.listeEquipe.add(equipe);
	}
	
	//Fonction qui permet de retourner une réponse positive ou négative si une date est invalide
	private static boolean dateInvalide(Date date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();
		String temp = dtf.format(now);
		Date today = Date.valueOf(temp);
		boolean res = date.before(today);
		return res;
		
	}

	public void genererPhaseFinale() {
		if (phasePoule.matchsFinis()) {
			phaseElim.genererMatchs();
		}
	}

	public List<Equipe> getListeEquipe() {
		return listeEquipe;
	}
	
	//Fonction qui permet de récuperer une équipe d'un tournoi
	public Equipe getEquipeTournoi(int i) {
		return this.listeEquipe.get(i);
	}

	public PhaseFinale getPhaseElim() {
		return phaseElim;
	}
	
	private static ResultSet verifierPresenceTournoi(Connection connex, Tournoi tournoi) throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		pst = connex.prepareStatement("select count(1) from LMN3783A.sae_Tournoi where nom = ? and datetournoi= ?" );
		pst.setString(1, tournoi.getNom());
		pst.setDate(2, tournoi.getDateTournoi());
		rs = pst.executeQuery();
		rs.next();
		return rs;
	}
	
	private static ResultSet verifierPresenceTournoiId(Connection connex, int id) throws SQLException {
		PreparedStatement pst;
		ResultSet rs;
		pst = connex.prepareStatement("select count(1) from LMN3783A.sae_tournoi where id_tournoi = ?" );
		pst.setInt(1, id);
		rs = pst.executeQuery();
		rs.next();
		return rs;
	}
	
	
	public static int getLastId() {
		Connection connex = Connexion.connexion();
		Statement st;
		ResultSet rs;
		int r = 0;
		
		try {
			
			st = connex.createStatement();
			rs = st.executeQuery("select max(id_tournoi) from LMN3783A.sae_tournoi");
			rs.next();
			r = rs.getInt(1);
			
			rs.close();
			st.close();
			
		} catch (Exception ee) {
			ee.printStackTrace(); 
		}
		return r;
	}
	//Fonction qui permet d'enregistrer un tournoi dans la base de données
		public static int enregistrerTournoi(Tournoi tournoi) throws Exception {
			Connection connex = Connexion.connexion();
			PreparedStatement pst;
			ResultSet rs;
			try {
				
				rs = verifierPresenceTournoi(connex, tournoi);
				if (rs.getInt(1) != 0) {
					return -1;
				}
				
				if (tournoi.getId() == -1) {
					tournoi.setId(Tournoi.getLastId()+1);
				}
				
				pst = connex.prepareStatement("insert into LMN3783A.sae_tournoi(id_tournoi, nom, datetournoi, championnat, notoriete, id_organisateur,id_mode) values(?,?,?,?,?,?,?)");
				pst.setInt(1, tournoi.getId());
				pst.setString(2, tournoi.getNom());
				pst.setDate(3, tournoi.getDateTournoi());
				pst.setInt(4, tournoi.getChampionnat());
				pst.setInt(5,tournoi.getNotoriete());
				pst.setInt(6,tournoi.getId_Organisateur());
				pst.setInt(7, tournoi.getId_Mode());
				pst.executeUpdate();
				rs.close();
				pst.close();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
				return -1;
			}
			return 1;
		}
		
		public static int modifierTournoi(Tournoi t) {
			Connection connex = Connexion.connexion();
			PreparedStatement pst;
			ResultSet rs;
			try {
				
				rs = verifierPresenceTournoiId(connex, t.getId());
				if (rs.getInt(1) == 0) {
					return -1;
				}
				
				pst = connex.prepareStatement("update LMN3783A.sae_equipe set nom = ?, datetournoi = ?, championnat = ?, notoriete = ?, id_organisateur= ?,id_mode = ? where id_equipe = ?" );
				pst.setString(1, t.getNom());
				pst.setDate(2, t.getDateTournoi());
				pst.setInt(3, t.getChampionnat());
				pst.setInt(4,t.getNotoriete());
				pst.setInt(5,t.getId_Organisateur());
				pst.setInt(6, t.getId_Mode());
				pst.executeUpdate();
				
				rs.close();
				pst.close();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
				return -1;
			}
			return 1;
		}
		
		public static int supprimerTournoi(Tournoi t) {
			Connection connex = Connexion.connexion();
			PreparedStatement pst;
			ResultSet rs;
			
			try {
				
				rs = verifierPresenceTournoi(connex,t);
				if (rs.getInt(1) == 0) {
					return -1;
				}
				
				pst = connex.prepareStatement("delete from LMN3783A.sae_tournoi where nom = ? and datetournoi= ?" );
				pst.setString(1, t.getNom());
				pst.setDate(2, t.getDateTournoi());
				pst.executeUpdate();
				rs.close();
				pst.close();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
				return -1; 
			}
			return 1;
		}

	@Override
	public String toString() {
		return "Tournoi{" +
				"nom='" + nom + '\'' +
				", date=" + dateTournoi +
				", notoriete=" + notoriete +
				", listeEquipe=" + listeEquipe +
				", phasePoule=" + phasePoule +
				", phaseElim=" + phaseElim +
				'}';
	}

	public void ajouterPoints () throws  Exception {
		if (!phaseElim.estFinie()) {
			throw new Exception("le tournoi n'est pas fini");
		}
		Equipe[] classement = phaseElim.getClassement();
		classement[0].addPoints(PointsClassement.PREMIER.points*notoriete);
		classement[1].addPoints(PointsClassement.DEUXIEME.points*notoriete);
		classement[2].addPoints(PointsClassement.TROISIEME.points*notoriete);
		classement[3].addPoints(PointsClassement.QUATRIEME.points*notoriete);
		for (Match m :
				phaseElim.getMatchs()) {
			m.getWinner().addPoints(5);
		}
		for (Match m :
		phasePoule.getMatchs()) {
			m.getWinner().addPoints(1);
		}
	}
}
