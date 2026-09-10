package cl.duoc.digitalfix.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CrearServicioCatalogoRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        String descripcion,

        @NotNull(message = "La tarifa es obligatoria")
        @PositiveOrZero(message = "La tarifa no puede ser negativa")
        BigDecimal tarifa,

        @NotNull(message = "El stock es obligatorio")
        @PositiveOrZero(message = "El stock no puede ser negativo")
        Integer stock,

        Boolean activo

) {
}