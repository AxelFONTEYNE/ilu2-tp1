package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	private class Marche {

		private Etal [] etals;
		private int nbEtalsOcc;
		private int nbEtals;
		
		public Marche(int nbEtals) {
			etals = new Etal[nbEtals];
			this.etals nbEtals = nbEtals;
			
		}
		
		public void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			Etal newEtal = new Etal();
			newEtal.occuperEtal(vendeur, produit, nbProduit);
			this.etals[indiceEtal] = newEtal;
			nbEtalsOcc += 1;
		}
		
		public int trouverEtalLibre() {
			for(int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe() == false) return i;
			}
			return -1;
		}
		
		public Etal[] trouverEtals(String produit) {
			Etal [] etalsOcc = new Etal [50];
			int ind = 0;
			for(int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe() == true) {
					etalsOcc[ind] = etals[i];
					ind ++;
				}
			}
			return etalsOcc;
		}
		
		public Etal trouverVendeur(Gaulois gaulois) {
			for(int i = 0; i < etals.length; i++) {
				if (etals[i].getVendeur() == gaulois) return etals[i];
			}
			return null;
		}
		
		public String afficherMarche() {
			int nbEtalsLibres = nbEtals - nbEtalsOcc;
			String chaine = "Il reste " + nbEtalsLibres + " étals non utilisés dans le marché. \n";
			return chaine;
			
		}
		
	}
}