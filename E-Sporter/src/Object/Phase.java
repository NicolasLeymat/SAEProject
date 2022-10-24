package Object;

public class Phase {

	private boolean elim;
	private Tournoi tournoi;
	private int id;

	public Phase(boolean elim, Tournoi tournoi, int id) {
		this.elim = elim;
		this.tournoi = tournoi;
		this.id = id;
	}

	public int getId () {
		return id;
	}

	public boolean isElim() {
		return elim;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

}
