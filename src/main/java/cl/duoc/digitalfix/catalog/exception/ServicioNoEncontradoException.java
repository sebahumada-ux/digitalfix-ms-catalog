package cl.duoc.digitalfix.catalog.exception;

public class ServicioNoEncontradoException extends RuntimeException {

    public ServicioNoEncontradoException(Long id) {
        super("No se encontró el servicio con ID " + id);
    }
}