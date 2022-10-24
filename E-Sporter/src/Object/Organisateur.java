package Object;

//Classe qui définit les fonctions d'un organisateur
public class Organisateur {
	
	private String nom;

	//Constructeur de la classe "Organisateur"
	public Organisateur(String nom) {
		this.setNom(nom);
	}

    //Fonction qui permet de récuperer le nom de l'organisateur
	public String getNom() {
		return nom;
	}

    //Fonction qui permet de changer le nom de l'organisateur
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
