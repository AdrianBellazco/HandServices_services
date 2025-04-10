package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class PrestadorServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Un prestador tiene una cuenta de usuario (datos personales, login.)
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    // Muchos prestadores pueden ofrecer el mismo tipo de servicio (Ej: plomería)
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    // Un prestador puede tener muchas peticiones de servicio hechas por clientes
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<PeticionServicio> peticiones;

    // Un prestador puede trabajar con muchos clientes, y un cliente con varios prestadores
    @ManyToMany
    @JoinTable(
            name = "prestador_cliente",
            joinColumns = @JoinColumn(name = "prestador_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes;

    // Un prestador puede tener varios niveles educativos y un mismo nivel puede pertenecer a varios prestadores
    @ManyToMany
    @JoinTable(
            name = "prestador_nivel_educativo",
            joinColumns = @JoinColumn(name = "prestador_id"),
            inverseJoinColumns = @JoinColumn(name = "nivel_educativo_id")
    )
    private List<NivelEducativo> nivelesEducativos;

    // Un prestador puede tener muchos comentarios asociados
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    // Un prestador puede tener muchas calificaciones (puntuaciones) hechas por distintos clientes
    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Puntuacion> puntuaciones;
}
