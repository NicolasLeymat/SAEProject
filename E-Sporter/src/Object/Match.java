package Object;

import Application.Connexion;

import java.sql.*;

public class Match {
	private Equipe equipe1;
	private Equipe equipe2;
	private Phase phase;
	private int winner;
	private int id;

	private Date date;

	public Match(Date date, Equipe equipe1, Equipe equipe2, Phase phase) {
		this.setDate(date);
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.phase = phase;
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
		if (num <1 || num>2) {
			throw new IllegalArgumentException();
		}
		this.winner = num;
	}

	public int getLastId() {
		Connection ct = Connexion.connexion();
		java.sql.Statement st = null;
		ResultSet rs;
		int r = 0;
		try {
			st = ct.createStatement();
			rs = st.executeQuery("Select id_matchs as id from LMN3783A.sae_matchs");
			while (rs.next()) {
				r = rs.getInt("id");
			}
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return r;
	}


	public static int enregistrermatch(Match match) {
		Connection ct = Connexion.connexion();
		int id = match.getLastId();
		try {
			PreparedStatement ps = ct.prepareStatement("INSERT INTO SAE_MATCHS VALUES (?,?,?)");
			ps.setInt(1,id);
			ps.setDate(2,match.date);
			ps.setInt(3,Phase.getId(ct, match.getPhase()));
			ps.executeUpdate();
			PreparedStatement ps2 = ct.prepareStatement("INSERT INTO SAE_CONCERNER VALUES(?,?)");
			ps2.setString(1,match.equipe1.getNom());
			ps2.setInt(2,id);
			ps2.executeUpdate();
			ps2.setString(1,match.equipe2.getNom());
			ps2.executeUpdate();
			match.id = id;
			return 0;
		}
		catch (Exception e) {
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
			ps.setInt(1,winner);
			ps.setInt(2,match.id);
			return 0;
		}
		catch (Exception e ){
			e.printStackTrace();
			return -1;
		}
	}



}
