package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
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
		System.out.println(prendreParole() + "\""+ texte +"\"");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : "; 
	}


//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un coup a " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille  = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
		}
	}
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion +" fois décuplée");
	}
	public void faireUneDonnation(Musee musee) {
		if(trophees.length != 0) {
			int i=0;
			StringBuilder bld = new StringBuilder();
			while(trophees[i]!=null) {
				bld.append("- "+trophees[i]+"\n");
				musee.donnerTrophees(this, trophees[i]);
				i++;
			}
			parler("Je donne au musee tous mes trophees:\n"+bld.toString());
			trophees = new Equipement[100];
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Astérix", 10);
		Romain cesar= new Romain("César", 2);
		cesar.sEquiper(Equipement.BOUCLIER);
		asterix.frapper(cesar);
	}
}

