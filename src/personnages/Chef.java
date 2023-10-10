package personnages;

public class Chef {
	private String nom;
	private int force;
	private int effetPotion =1;
	private Village village;
	
	public Chef(String nom, int force, int effetPotion, Village village) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
		this.village = village;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "'"+ texte +"'");
	}
	private String prendreParole() {
		return "Le chef" + nom + "du village" + village.getNom() + " : "; 
	}
	public void frapper(Romain romain) {
		System.out.println(nom + "envoie un coup a " + romain.getNom());
		romain.recevoirCoup(force/3);
	}
	public static void main(String[] args) {
		Village v= new Village("vivi",20);
		Chef chef=new Chef("abra",6,1,v);
		System.out.println(chef.getNom());
	}
}