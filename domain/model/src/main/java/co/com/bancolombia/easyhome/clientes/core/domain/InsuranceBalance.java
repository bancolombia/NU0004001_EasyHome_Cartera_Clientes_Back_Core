package co.com.bancolombia.easyhome.clientes.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InsuranceBalance {
    private String codigoMonedaISO4217Alfabetico;
    private Double insuranceBalance;
}
