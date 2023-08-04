package co.com.bancolombia.easyhome.clientes.core.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
        @NotNull(message = "customerDocument no puede ser nulo")
        private String customerDocument;
        @NotNull(message = "customerTypeDocument no puede ser nulo")
        private String customerTypeDocument;

}
