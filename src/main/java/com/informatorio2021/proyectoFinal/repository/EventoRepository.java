package com.informatorio2021.proyectoFinal.repository;

import com.informatorio2021.proyectoFinal.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
