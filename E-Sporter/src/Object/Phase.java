package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Classe qui définit les fonctions d'une phase
public class Phase {

	private boolean elim;
	private Tournoi tournoi;

	// Constructeur de la classe "Phase"
	public Phase(boolean elim, Tournoi tournoi) {
		this.elim = elim;
		this.tournoi = tournoi;
	}

	// Fonction qui permet de savoir si c'est une phase éliminatoire ou pas
	public boolean isElim() {
		return elim;
	}

	// Fonction qui permet de récuperer le tournoi d'une phase
	public Tournoi getTournoi() {
		return tournoi;
	}

	public static int getId(Connection connex, Phase phase) {
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = connex.prepareStatement(
					"select id_phase from LMN3783A.sae_phase where LMN3783A.sae_phase.elim = ? and LMN3783A.sae_phase.id_tournoi = ?");
			if (phase.isElim()) {
				pst.setInt(1, 1);
			} else {
				pst.setInt(1, 0);
			}
			pst.setInt(2, Tournoi.getId(connex, phase.getTournoi()));
			rs = pst.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}
