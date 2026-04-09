package controleur;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlAfficherVillageTest {
	private Village village;
    private ControlAfficherVillage controlAfficherVillage;
    
    @BeforeEach
    public void setUp() {
        village = new Village("Village", 10, 5);
        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);         
        village.ajouterHabitant(new Gaulois("Asterix", 5));
        village.ajouterHabitant(new Gaulois("Obelix",7));
        controlAfficherVillage = new ControlAfficherVillage(village);
    }

	@Test
	void testControlAfficherVillage() {
		 String[] villageois = controlAfficherVillage.donnerNomsVillageois();
	        assertNotNull(villageois);
	}

	@Test
	void testDonnerNomsVillageois() {
		
	}

	@Test
	void testDonnerNomVillage() {
		
	}

	@Test
	void testDonnerNbEtals() {
		
	}

}
