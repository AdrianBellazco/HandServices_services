package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "niveles_educativos")
public class NivelEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nivel;

    // Relación muchos a muchos con PrestadorServicio
    @ManyToMany(mappedBy = "nivelesEducativos")
    private List<PrestadorServicio> prestadores;
}
