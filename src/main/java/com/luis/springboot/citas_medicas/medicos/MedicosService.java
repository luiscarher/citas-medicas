package com.luis.springboot.citas_medicas.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicosService {
    @Autowired private MedicosRepository repo;
    public List<Medicos> listAll(){
        return (List<Medicos>) repo.findAll();
    }

    public void save(Medicos medico) {
        repo.save(medico);
    }

    public Medicos get(Integer id) throws MedicoNotFoundException {
        Optional<Medicos> resultado = repo.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        throw new MedicoNotFoundException("No se pudieron encontrar usuarios con este ID");
    }
}
