package cl.duoc.digitalfix.catalog.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ActualizarServicioCatalogoRequest(

        @NotNull(message = "La tarifa es obligatoria")
        @PositiveOrZero(message = "La tarifa no puede ser negativa")
        BigDecimal tarifa,

        @NotNull(message = "El stock es obligatorio")
        @PositiveOrZero(message = "El stock no puede ser negativo")
        Integer stock

) {
}