package com.example.rest_api.medico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

//esto mapea la app en requests URL->HTTP
@RestController
@RequestMapping("/api/medicos")
public class MedicoController
{
    @Autowired
    private MedicoService medicoService;
    // post 1 medico, requiere un body json equivalente a la clase Medico
    @PostMapping("")
    public ResponseEntity<Medico> addMedico (@RequestBody Medico medico)
    {
        Medico med = medicoService.saveOrUpdateMedico(medico);
        return new ResponseEntity<Medico>(med, HttpStatus.CREATED);
    }
    // get all medicos
    @GetMapping("")
    public Iterable<Medico> getMedicos()
    {
        return medicoService.listAll();
    }
    // get 1 medico by id, el parametro esta en la URL
    @GetMapping("/{id}")
    public Optional<Medico> getMedicoById(@PathVariable("id") Long id)
    {
        return medicoService.listOne(id);
    }
    // get medicos que tengan el estado definido, este es un parametro de la request
    @GetMapping("/filter")
    public Iterable<Medico> getMedicosByEstado(@RequestParam(value="estado") String estado)
    {
        return medicoService.listByEstado(estado);
    }
    // update 1 medico, sobre su id
    @PutMapping("/{id}")
    public Medico updateMedico(@PathVariable Long id, @RequestBody Medico medico) 
    {
        Medico med = medicoService.listOne(id).get(); 
        med.setEstado(medico.getEstado());
        return medicoService.saveOrUpdateMedico(med);
    }
    // delete 1 medico, sobre su id
    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Long id)
    {
        medicoService.deleteMedico(id);
    }

}