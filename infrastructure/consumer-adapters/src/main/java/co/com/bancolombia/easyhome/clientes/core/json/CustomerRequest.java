package co.com.bancolombia.easyhome.clientes.core.json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class CustomerRequest {
    private String customerIdType;
    private String customerId;
}
