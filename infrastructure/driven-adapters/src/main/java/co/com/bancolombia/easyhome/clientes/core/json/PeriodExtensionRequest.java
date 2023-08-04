package co.com.bancolombia.easyhome.clientes.core.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodExtensionRequest{
    @Size(min = 1, max = 10, message = "document_type no puede ser mayor a 10 caráteres")
    @NotNull(message = "document_type no puede ser nulo")
    @Pattern(regexp = "[a-zA-Z]+", message = "document_type no puede contener caracteres especiales")
    private String documentType;

    @Size(min = 1, max = 30, message = "valor máximo excedido para document_number")
    @NotNull(message = "document_number no puede ser nulo")
    @Pattern(regexp = "[a-zA-Z0-9]+" , message = "document_number no puede contener caracteres especiales")
    private String documentNumber;

    @Size(min = 1, max = 100, message = "customer_name no puede ser mayor a 100 caráteres")
    @NotNull(message = "customer_name no puede ser nulo")
    @Pattern(regexp = "([a-zA-Z\u00f1\u00d1\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da] ?)+",
            message = "customer_name no puede contener caracteres especiales")
    private String customerName;

    @Size(min = 1, max = 22, message = "obligation_number no puede ser mayor a 30 dígitos")
    @NotNull(message = "obligation_number no puede ser nulo")
    @Pattern(regexp = "[0-9]+", message = "obligation_number no puede contener caracteres especiales")
    private String obligationNumber;

    @Max(value = 360, message = "El valor máximo para new_terms es 360")
    @Min(value = 1, message = "El valor mínimo para new_terms es 1")
    @NotNull(message = "new_terms no puede ser nulo")
    private long newTerms;

    @Max(value = 360, message = "El valor máximo para old_terms es 360")
    @Min(value = 0, message = "El valor mínimo para old_terms es 0")
    private long oldTerms;

    private LocalDateTime requestDate;

}
