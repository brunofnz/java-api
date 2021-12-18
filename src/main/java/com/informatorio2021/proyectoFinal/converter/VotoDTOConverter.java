package com.informatorio2021.proyectoFinal.converter;

import com.informatorio2021.proyectoFinal.dto.VotoDTO;
import com.informatorio2021.proyectoFinal.entity.Voto;
import com.informatorio2021.proyectoFinal.repository.EmprendimientoRepository;
import com.informatorio2021.proyectoFinal.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VotoDTOConverter implements Converter<VotoDTO, Voto> {
    public VotoDTOConverter(EmprendimientoRepository emprendimientoRepository,
                            UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    }
}