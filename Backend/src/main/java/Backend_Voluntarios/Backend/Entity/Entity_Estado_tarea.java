package Backend_Voluntarios.Backend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Estado_tarea")
public class Entity_Estado_tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id_Estado_tarea;

    private Long Id_tarea;
    // el estado de la tarea deberia ser un String o un booleano?
    private boolean estado_tarea;

    public Entity_Estado_tarea(Long Id_estado_tarea, Long Id_tarea, boolean estado_tarea){
        this.Id_Estado_tarea = Id_estado_tarea;
        this.Id_tarea = Id_tarea;
        this.estado_tarea = estado_tarea;
    }
}
