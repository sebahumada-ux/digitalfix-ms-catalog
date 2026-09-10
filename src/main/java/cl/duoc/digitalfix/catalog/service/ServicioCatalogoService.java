package cl.duoc.digitalfix.catalog.service;

import cl.duoc.digitalfix.catalog.dto.ActualizarServicioCatalogoRequest;
import cl.duoc.digitalfix.catalog.dto.CrearServicioCatalogoRequest;
import cl.duoc.digitalfix.catalog.dto.ServicioCatalogoResponse;
import cl.duoc.digitalfix.catalog.exception.ServicioNoEncontradoException;
import cl.duoc.digitalfix.catalog.model.ServicioCatalogo;
import cl.duoc.digitalfix.catalog.repository.ServicioCatalogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCatalogoService {

    private final ServicioCatalogoRepository repository;

    public ServicioCatalogoService(
            ServicioCatalogoRepository repository) {

        this.repository = repository;
    }

    public List<ServicioCatalogoResponse> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public ServicioCatalogoResponse buscarPorId(Long id) {

        ServicioCatalogo servicio = buscarEntidadPorId(id);

        return convertirAResponse(servicio);
    }

    public ServicioCatalogoResponse crear(
            CrearServicioCatalogoRequest request) {

        ServicioCatalogo servicio = new ServicioCatalogo();

        servicio.setNombre(request.nombre());
        servicio.setDescripcion(request.descripcion());
        servicio.setTarifa(request.tarifa());
        servicio.setStock(request.stock());

        if (request.activo() == null) {
            servicio.setActivo(true);
        } else {
            servicio.setActivo(request.activo());
        }

        ServicioCatalogo guardado = repository.save(servicio);

        return convertirAResponse(guardado);
    }

    public ServicioCatalogoResponse actualizar(
            Long id,
            ActualizarServicioCatalogoRequest request) {

        ServicioCatalogo servicio = buscarEntidadPorId(id);

        servicio.setTarifa(request.tarifa());
        servicio.setStock(request.stock());

        ServicioCatalogo actualizado = repository.save(servicio);

        return convertirAResponse(actualizado);
    }

    private ServicioCatalogo buscarEntidadPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new ServicioNoEncontradoException(id)
                );
    }

    private ServicioCatalogoResponse convertirAResponse(
            ServicioCatalogo servicio) {

        return new ServicioCatalogoResponse(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getDescripcion(),
                servicio.getTarifa(),
                servicio.getStock(),
                servicio.getActivo()
        );
    }
}