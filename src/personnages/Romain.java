package personnages;

public class Romain {
	private String nom;
	private int force;
	public Romain(String nom, int force) {
		assert force>=0 : "Force pas positive";
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "'"+ texte +"'");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : "; 
	}
	public void recevoirCoup(int forceCoup) {
		assert force>=0 : "Force pas positive";
		int force_init=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert force<force_init: "Force ne diminue pas après recevoirCoup";
	}
	public static void main(String[] args) {
		Romain cesar= new Romain("Cêsar", 6);
		cesar.recevoirCoup(1);
	}
}
