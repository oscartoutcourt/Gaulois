package personnages;

public class Musee {
	private Equipement trophees[];
	trophees= new Equipement[200];
	private int nbTrophees;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophees++]=equipement;
	}
}
