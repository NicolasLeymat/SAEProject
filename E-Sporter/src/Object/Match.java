package Object;

import java.sql.Date;

//Classe qui définit les fonctions d'un match
public class Match {

	private Date date;

    //Constructeur de la classe "Match"
	public Match(Date date) {
		this.setDate(date);
	}

    //Fonction qui permet de récuperer la date d'un match
	public Date getDate() {
		return date;
	}

    //Fonction qui permet de changer la date d'un match
	public void setDate(Date date) {
		this.date = date;
	}

}
