package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "'"+ texte +"'");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : "; 
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un coup a " + romain.getNom());
		romain.recevoirCoup((force/3)*effetPotion);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion +" fois décuplée");
	}
	
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Astérix", 10);
		Romain cesar= new Romain("cesar", 10);
		asterix.boirePotion(10);
	}
}

