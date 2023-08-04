package co.com.bancolombia.easyhome.clientes.core.services;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessExeptionType;
import co.com.bancolombia.easyhome.clientes.core.gateways.CreditGateway;
import co.com.bancolombia.easyhome.clientes.core.gateways.SessionIdGateway;
import co.com.bancolombia.easyhome.clientes.core.json.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CreditGateway creditGateway;
    private final SessionIdGateway sessionIdGateway;
    public List<ProductResponse> getProducts(ProductRequest productRequest, String token){
        Boolean sessionValid = sessionIdGateway.sessionIdValid(productRequest.getCustomerTypeDocument(),
                productRequest.getCustomerDocument(),token);
        if(sessionValid){
            return creditGateway.getProductResponse(productRequest.getCustomerTypeDocument(),
                    productRequest.getCustomerDocument(),token);
        }else {
            throw new BusinessException(BusinessExeptionType.COR08);
        }

    }
}
