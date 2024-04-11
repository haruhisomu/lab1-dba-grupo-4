package Backend_Voluntarios.Backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "institucion")
public class InstitucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idInstitucion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idEmergencia;

    private String nombreInstitucion;


    // Constructor all
    public InstitucionEntity(Long idInstitucion, Long idEmergencia, String nombreInstitucion){
        super();
        this.idInstitucion = idInstitucion;
        this.idEmergencia = idEmergencia;
        this.nombreInstitucion = nombreInstitucion;
    }

    // Constructor empty
    public InstitucionEntity() {
        super();
    }

    // Getters
    public Long getIdInstitucion(){
        return idInstitucion;
    }

    public Long getId_Emergencia() {
        return idEmergencia;
    }

    public String getNombreInstitucion(){
        return nombreInstitucion;
    }

    //Setters

    public void setNombreInstitucion(String nombre_Institucion){
        this.nombreInstitucion= nombre_Institucion;
    }

    }



    

