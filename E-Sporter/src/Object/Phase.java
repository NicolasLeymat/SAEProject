package Object;

public class Phase {

	private boolean elim;
	private Tournoi tournoi;

	public Phase(boolean elim, Tournoi tournoi) {
		this.elim = elim;
		this.tournoi = tournoi;
	}

	public boolean isElim() {
		return elim;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

}
