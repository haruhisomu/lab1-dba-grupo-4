package Backend_Voluntarios.Backend.Repository;

import Backend_Voluntarios.Backend.Entity.EmergenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmergenciaRepository extends JpaRepository<EmergenciaEntity, Long> {
    // findById
    @Query("SELECT e FROM EmergenciaEntity e WHERE e.idEmergencia = :id")
    EmergenciaEntity findEmergenciaById(@Param("id") Long id);

    // findAll
    @Query("SELECT e FROM EmergenciaEntity e")
    List<EmergenciaEntity> findAllEmergencias();

    // save
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO EmergenciaEntity (tipoEmergencia, zonaEmergencia, condicionFisica, cantidadVoluntariosMinimo, cantidadVoluntariosMaximo) VALUES (:tipoEmergencia, :zonaEmergencia, :condicionFisica, :cantidadVoluntariosMinimo, :cantidadVoluntariosMaximo)")
    void saveEmergencia(@Param("tipoEmergencia") String tipoEmergencia,
            @Param("zonaEmergencia") String zonaEmergencia,
            @Param("condicionFisica") String condicionFisica,
            @Param("cantidadVoluntariosMinimo") String cantidadVoluntariosMinimo,
            @Param("cantidadVoluntariosMaximo") String cantidadVoluntariosMaximo);
}

