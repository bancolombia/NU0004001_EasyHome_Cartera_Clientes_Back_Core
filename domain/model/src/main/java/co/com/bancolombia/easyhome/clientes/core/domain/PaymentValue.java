package co.com.bancolombia.easyhome.clientes.core.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PaymentValue {
    private String codigoMonedaISO4217Alfabetico;
    private Double paymentValue;
}
