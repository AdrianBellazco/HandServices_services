package co.edu.uceva.handservice_services.model.entities;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private usuarios usuario;

    // Aquí puedes agregar más campos y relaciones
}
