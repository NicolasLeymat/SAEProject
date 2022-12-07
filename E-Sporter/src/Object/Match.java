package Object;

import Application.Connexion;

import java.sql.*;

public class Match {
	private Equipe equipe1;
	private Equipe equipe2;
	private Equipe winner;
	private Phase phase;
	private int id;
	private Date date;

	public Match(Date date, Equipe equipe1, Equipe equipe2, Phase phase) {
		this.setDate(date);
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.phase = phase;
		this.winner = null;
		this.id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Equipe getEquipe1() {
		return equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public Phase getPhase() {
		return this.phase;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setWinner(int num) throws IllegalArgumentException {
		if (num < 1 || num > 2) {
			throw new IllegalArgumentException();
		}
		if (num == 1 ) {
			winner = equipe1;
		}
		else {
			winner = equipe2;
		}
	}

	public Equipe getWinner() {
		return winner;
	}

	public Equipe getLoser () {
		if (winner == equipe1) {
			return equipe2;
		}
		else if (winner == equipe2) {
			return equipe1;
		}
		else  {
			return null ;
		}
	}

	public int getLastId() {
		Connection ct = Connexion.connexion();
		Statement st;
		ResultSet rs;
		int r = 0;
		try {
			st = ct.createStatement();
			rs = st.executeQuery("Select max(id_match) as id from LMN3783A.sae_match");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}

	public static int enregistrermatch(Match m) {
		Connection connex = Connexion.connexion();
		PreparedStatement pst;
		PreparedStatement pst2;
		PreparedStatement pst3;
		
		try {
			if (m.getId() == -1) {
				m.setId(Tournoi.getLastId()+1);
			}
			pst= connex.prepareStatement("INSERT INTO SAE_MATCHS VALUES (?,?,?)");
			pst.setInt(1, m.getId());
			pst.setDate(2, m.date);
			pst.setInt(3, m.phase.getId());
			pst.executeUpdate();
			pst2 = connex.prepareStatement("INSERT INTO SAE_CONCERNER VALUES(?,?)");
			pst2.setInt(1, m.getEquipe1().getId());
			pst2.setInt(2, m.getId());
			pst2.executeUpdate();
			pst3 = connex.prepareStatement("INSERT INTO SAE_CONCERNER VALUES(?,?)");
			pst3.setInt(1, m.getEquipe2().getId());
			pst3.setInt(2, m.getId());
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int validerVainqueur(Match match, int winner) {
		Connection ct = Connexion.connexion();
		if (match.id == 0) {
			throw new IllegalArgumentException("match inexistant");
		}
		match.setWinner(winner);
		try {
			PreparedStatement ps = ct.prepareStatement("UPDATE SAE_MATCH SET WINNER = ? WHERE ID = ?");
			ps.setInt(1, winner);
			ps.setInt(2, match.id);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Match{" +
				"equipe1=" + equipe1.getNom() +
				", equipe2=" + equipe2.getNom() +
				", winner=" + winner +
				", id=" + id +
				", date=" + date +
				"}\n";
	}
}
