package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación uno a uno con usuario
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // FK hacia usuarios.id
    private Usuarios usuario;

    // Relación muchos a muchos con servidores (prestadores)
    @ManyToMany
    @JoinTable(
            name = "cliente_servidor", // Tabla intermedia
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servidor_id")
    )
    private List<PrestadorServicio> servidores;

    // Peticiones hechas por este cliente
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<PeticionServicio> peticiones;
}
