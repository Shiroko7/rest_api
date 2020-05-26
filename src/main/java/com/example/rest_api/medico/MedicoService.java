package com.example.rest_api.medico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//esto define que operaciones de las definidas seran usadas 
@Service
public class MedicoService 
{
    @Autowired
    private  MedicoRepository medicoRepository;

    // request
    public Iterable<Medico> listAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> listOne(Long id) {
        return medicoRepository.findById(id);
    }

    public Iterable<Medico> listByEstado(String estado)
    {
        return medicoRepository.finByEstado(estado);
    }
    //create & update
    public Medico saveOrUpdateMedico(Medico medico)
    {
        return medicoRepository.save(medico);
    }

    //delete
    public void deleteMedico(Long id)
    {
        medicoRepository.deleteById(id);
    }

}