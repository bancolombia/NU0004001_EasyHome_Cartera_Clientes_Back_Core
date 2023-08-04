package co.com.bancolombia.easyhome.clientes.core.gateways;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface CreditGateway {

    public List<ProductResponse> getProductResponse(String customerIdType, String customerId,String token);
}
