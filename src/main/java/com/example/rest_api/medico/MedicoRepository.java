package com.example.rest_api.medico;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//esto implementa las operaciones CRUD para ser usadas
@Repository
public interface MedicoRepository extends CrudRepository<Medico,Long>
{
    @Query("SELECT u FROM Medico u where u.estado = :estado") 
    Iterable<Medico> finByEstado(@Param("estado") String estado);
}