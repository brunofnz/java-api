package com.informatorio2021.proyectoFinal.repository;

import com.informatorio2021.proyectoFinal.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {
    Tags findByNombre(String nombre);
}
