package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "peticiones_servicio")
public class PeticionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDate fecha;
    private boolean status;
    private String estado; // pendiente, aceptada, rechazada, completada...

    // Relación muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Relación muchos a uno con PrestadorServicio
    @ManyToOne
    @JoinColumn(name = "servidor_id")
    private PrestadorServicio servidor;
}
