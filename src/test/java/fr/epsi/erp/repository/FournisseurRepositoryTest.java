package fr.epsi.erp.repository;

import fr.epsi.erp.model.Fournisseur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class FournisseurRepositoryTest {

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Test
    public void findFirstByNom() {

        // Arrange
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom("test");

        Optional<Fournisseur> optionalFournisseur = Optional.of(fournisseur);

        // Mock
        fournisseurRepository.save(fournisseur);

        // Act
        Optional<Fournisseur> optionalFournisseurACT = fournisseurRepository.findFirstByNom("test");

        // Assert
        assertThat(optionalFournisseurACT.isPresent()).isEqualTo(true);
        assertThat(optionalFournisseurACT.get().getNom().equals(fournisseur.getNom()));
    }
}