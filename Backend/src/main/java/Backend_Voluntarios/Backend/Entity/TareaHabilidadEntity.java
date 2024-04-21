package Backend_Voluntarios.Backend.Entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "tarea_habilidad")

public class TareaHabilidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idTareaHabilidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idTarea;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idHabilidad;
    @ElementCollection
    private List<String> habilidadRequerida;

    // Constructor
    public TareaHabilidadEntity(Long idTarea, Long idHabilidad, List<String> habilidad_requerida) {
        this.idTarea = idTarea;
        this.idHabilidad = idHabilidad;
        this.habilidadRequerida = habilidad_requerida;
    }

    // Constructor vacio
    public TareaHabilidadEntity() {
        super();
    }

    // Getters an Setters
    public Long getIdTareaHabilidad() {
        return idTareaHabilidad;
    }

    public void setIdTareaHabilidad(Long idTareaHabilidad) {
        this.idTareaHabilidad = idTareaHabilidad;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public List<String> getHabilidadRequerida() {
        return habilidadRequerida;
    }

    public void setHabilidadRequerida(List<String> habilidadRequerida) {
        this.habilidadRequerida = habilidadRequerida;
    }
}
