package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee t = new Trophee(gaulois,equipement);
		trophees[nbTrophees++]=t;
	}
	public String extraireInstructionsOCaml() {
		StringBuilder bld = new StringBuilder();
		for(int i=0;i<nbTrophees;i++) {
			bld.append("	\""+ trophees[i].getGaulois().getNom()+"\", \""+trophees[i].getEquipement()+"\";\n");
		}
		return "let musee = [\n"+bld.toString()+ "]";
	}
}
