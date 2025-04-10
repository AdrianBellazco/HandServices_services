package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre_servicio;
    private String descripcion;

    // Relación con Prestadores (un servicio puede tener muchos prestadores)
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<PrestadorServicio> prestadores;
}
