package cl.duoc.digitalfix.catalog.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "CATALOG_SERVICES")
@Data
@NoArgsConstructor
public class ServicioCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal tarifa;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean activo = true;
}