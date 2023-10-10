package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private boolean vainqueur;

	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "'" + texte + "'");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force >= 0 : "Force pas positive";
//		int oldForce = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force < oldForce : "Force ne diminue pas apr�s recevoirCoup";
//	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if ((equipements[0]).equals(equipement)) {
				System.out.println("Le soldat " + nom + " posséde déjà un " + equipement);
			} else {
				ajouterEquipement(equipement);
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est deja bien protégé !");
			break;
		default:
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement);
		equipements[nbEquipement] = equipement;
		nbEquipement++;
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		 } else {
			 equipementEjecte = ejecterEquipement();
			 parler("J'abandonne...");
		 }
		// post condition la force a diminue
		assert force <= oldForce;
		if(force==oldForce) {
			parler("tu ne me fais aucun degats! Je gagne");
			vainqueur=true;
		}
		return equipementEjecte;
	}
	
	public boolean isVainqueur() {
		return vainqueur;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup<0) {
			forceCoup=0;
		}
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			} 
		}
		return equipementEjecte;
	}


	public static void main(String[] args) {
		Romain cesar = new Romain("César", 6);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.CASQUE);
	}
}
