package com.luis.springboot.citas_medicas;

import com.luis.springboot.citas_medicas.medicos.Medicos;
import com.luis.springboot.citas_medicas.medicos.MedicosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MedicosReporitoryTests {
    @Autowired private MedicosRepository repo;

    @Test
    public void testAddNew(){
        Medicos medicos = new Medicos();
        medicos.setNombre("Luis");
        medicos.setApellidoPaterno("Herrera");
        medicos.setApellidoMaterno("Rios");
        medicos.setEspecialidad("Anesteciologo");

        Medicos savedMedico = repo.save(medicos);

        Assertions.assertNotNull(savedMedico);
        Assertions.assertTrue(savedMedico.getId() > 0);
    }

    @Test
    public void testListAll(){
        Iterable<Medicos> medicos = repo.findAll();
        //Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (Medicos medico : medicos) {
            System.out.println(medico);
        }
    }

    @Test
    public void testUpdate(){
        Integer medicoId = 1;
        Optional<Medicos> optionalMedicos = repo.findById(medicoId);
        Medicos medico = optionalMedicos.get();
        medico.setEspecialidad("Cirujano");
        repo.save(medico);

        Medicos updatedMedico = repo.findById(medicoId).get();
        Assertions.assertEquals(updatedMedico.getEspecialidad(), "Cirujano");
    }

    @Test
    public void testGet(){
        Integer medicoId = 1;
        Optional<Medicos> optionalMedico = repo.findById(medicoId);
        Assertions.assertNotNull(optionalMedico);
        System.out.println(optionalMedico.get());
    }

    @Test
    public void testDelete(){
        Integer medicoId = 3;
        repo.deleteById(medicoId);

        Optional<Medicos> optionalMedicos = repo.findById(medicoId);
        Assertions.assertEquals(optionalMedicos, Optional.empty());
    }

}
