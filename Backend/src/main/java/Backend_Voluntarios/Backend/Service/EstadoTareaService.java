package Backend_Voluntarios.Backend.Service;

import Backend_Voluntarios.Backend.Entity.EstadoTareaEntity;
import Backend_Voluntarios.Backend.Repository.EstadoTareaRepository;
import java.util.List;

public class EstadoTareaService {
    private EstadoTareaRepository estadoTareaRepository;

    public List<EstadoTareaEntity> listAll(String palabraClave) {

        return estadoTareaRepository.listAll(palabraClave);

    }

    public EstadoTareaEntity findByIdTarea(Long idTarea) {
        return estadoTareaRepository.findByIdTarea(idTarea);
    }

    public EstadoTareaEntity findById(Long idEstadoTarea) {
        return estadoTareaRepository.findById(idEstadoTarea);
    }

    public List<Long> getTareasSinTerminar() {
        return estadoTareaRepository.findTareasSinTerminar();
    }

    public List<Long> getTareasTerminadas() {
        return estadoTareaRepository.findTareasTerminadas();
    }

    public void eliminarEstadoTarea(Long idEstadoTarea) {
        estadoTareaRepository.borrarEstadoTarea(idEstadoTarea);
    }

    public void guardarEstadoTarea(EstadoTareaEntity estadoTarea) {
        estadoTareaRepository.guardarEstadoTarea(estadoTarea.getIdEstadoTarea(), estadoTarea.getIdTarea(),
                estadoTarea.isEstadoTarea());
    }

    public List<EstadoTareaEntity> getAllEstadoHabilidad() {
        return estadoTareaRepository.findAll();
    }
}
