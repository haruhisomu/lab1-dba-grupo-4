package Backend_Voluntarios.Backend.Controller;

import java.util.List;
import java.util.Map;

import Backend_Voluntarios.Backend.Service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Backend_Voluntarios.Backend.Service.EmergenciaService;
import Backend_Voluntarios.Backend.Entity.EmergenciaEntity;
import Backend_Voluntarios.Backend.Service.InstitucionService;
import Backend_Voluntarios.Backend.Entity.InstitucionEntity;

@RestController
@RequestMapping("/emergencia")
@CrossOrigin(origins = "*")
public class EmergenciaController {
    @Autowired
    private EmergenciaService emergenciaService;

    @Autowired
    private InstitucionService institucionService;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping("/{id}")
    public EmergenciaEntity getEmergenciaById(@PathVariable Long id) {
        return emergenciaService.getEmergenciaById(id);

    }

    @GetMapping("/all")
    public List<EmergenciaEntity> getAllEmergencias() {
        return emergenciaService.getAllEmergencias();
    }

    @PostMapping("/add")
    public EmergenciaEntity addEmergencia(@RequestBody Map<String, String> body) {
        String tipoEmergencia = body.get("tipoEmergencia");
        String zonaEmergencia = body.get("zonaEmergencia");
        String condicionFisica = body.get("condicionFisica");
        String cantidadVoluntariosMinimo = body.get("cantidadVoluntariosMinimo");
        String cantidadVoluntariosMaximo = body.get("cantidadVoluntariosMaximo");
        Long idInstitucion = Long.parseLong(body.get("idInstitucion"));

        InstitucionEntity institucion = institucionService.getInstitucionById(idInstitucion);

        EmergenciaEntity emergencia = new EmergenciaEntity(tipoEmergencia, zonaEmergencia, condicionFisica,
                cantidadVoluntariosMinimo, cantidadVoluntariosMaximo, institucion);
        Long idUsuario = 1L;
        auditoriaService.registrarCambio(idUsuario, "Add", "añadio una emergencia");
        emergenciaService.addEmergencia(emergencia);

        // Long idUsuario = //metodo para obtener id de usuario ya listo, esperar a
        // pablo
        // auditoriaService.registrarCambio(idUsuario, "Add", "añadio una emergencia");

        return emergencia; // ! Se debe cambiar al terminar el front por seguridad de que no devuelva
                           // ! datos, solo debe devolver una respuesta de que se guardo correctamente
    }
}
