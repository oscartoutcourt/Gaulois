package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;

	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois= new Gaulois[nbVillageoisMaximum];
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois g) {
		villageois[nbVillageois]=g;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int num) {
		return villageois[num];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village '"+ nom+"' il y a le chef '"+chef.getNom()+"' et les villageois : ");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println(villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village=new Village("Village des irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//indice 30 pas dans le tableau
		Chef abraracourcix= new Chef("Abraracoucix",6,1,village);
		village.setChef(abraracourcix);
		Gaulois asterix= new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//Il n'y a personne dans la case numero 1	
		village.afficherVillageois();
	}
}
