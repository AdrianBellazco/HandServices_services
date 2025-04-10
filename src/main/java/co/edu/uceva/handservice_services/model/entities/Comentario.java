package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;
    private String autor; // opcional: podrías usar un Usuario o Cliente

    private String fecha;

    // Relación con PrestadorServicio
    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private PrestadorServicio prestador;
}
