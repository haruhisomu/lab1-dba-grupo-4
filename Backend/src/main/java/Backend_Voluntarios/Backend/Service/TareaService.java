package Backend_Voluntarios.Backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Backend_Voluntarios.Backend.Repository.TareaRepository;
import Backend_Voluntarios.Backend.Entity.TareaEntity;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public TareaEntity getTareaById(Long id) {
        return TareaRepository.findTareaById(id);
    }

    public List<TareaEntity> getAllTareas() {
        return TareaRepository.findAllTareas();
    }

    public TareaEntity addTarea(TareaEntity tarea) {
        return TareaRepository.saveTarea(tarea.getIdTarea(),
                tarea.getIdEstadoTarea(),
                tarea.getNombreTarea(),
                tarea.getDescripcionTarea(),
                tarea.getTipoTarea());
    }
}