package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees=0;
	private Equipement[] trophees = new Equipement[100];

	
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
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : "; 
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un coup a " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
		return;
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion +" fois d�cupl�e");
	}
	
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Ast�rix", 10);
		asterix.boirePotion(10);
	}
}

