package com.sistema.evaluacion.repositories;

import com.sistema.evaluacion.models.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRolRepository extends JpaRepository<Rol,Long> {

}
