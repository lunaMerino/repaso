package org.fundacion.repaso.dto;

import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Asignatura;
import org.fundacion.repaso.persistance.model.Nota;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignaturaDTO {
    private Long id;
    private String asignaturaName;
    private List<NotaDTO> notas;

    public AsignaturaDTO(Asignatura a) {
        this.id = a.getAsignaturaId();
        this.asignaturaName = a.getAsignaturaName();
        this.notas = toNotasDTO(a.getNotas());
    }

    private List<AlumnoDTO> toAlumnoDTO(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            alumnosDTO.add(new AlumnoDTO(a));
        }
        return alumnosDTO;
    }
    private List<NotaDTO> toNotasDTO(List<Nota> notas) {
        List<NotaDTO> notasDTO = new ArrayList<>();
        for (Nota a : notas) {
            notasDTO.add(new NotaDTO(a));
        }
        return notasDTO;
    }
}
