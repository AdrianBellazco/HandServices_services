package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "puntuaciones")
public class Puntuacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int valor;
    private String comentario;

    private String fecha;

    // Relación con PrestadorServicio
    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private PrestadorServicio prestador;
}
