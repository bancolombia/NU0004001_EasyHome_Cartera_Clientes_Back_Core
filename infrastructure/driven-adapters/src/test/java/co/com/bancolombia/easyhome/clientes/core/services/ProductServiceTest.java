package co.com.bancolombia.easyhome.clientes.core.services;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.gateways.CreditGateway;
import co.com.bancolombia.easyhome.clientes.core.gateways.SessionIdGateway;
import co.com.bancolombia.easyhome.clientes.core.json.ProductRequest;
import co.com.bancolombia.easyhome.clientes.core.services.util.ProductResponseBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Mock
    private CreditGateway creditGateway;
    @Mock
    private SessionIdGateway sessionIdGateway;
    private ProductRequest productRequest;
    private ProductService productService;

    @Before
    public void setUp() {
        creditGateway = Mockito.mock(CreditGateway.class);
        sessionIdGateway = Mockito.mock(SessionIdGateway.class);
    }

    @Test
    public void getProducts() {
        productRequest = new ProductRequest();
        productRequest.setCustomerDocument("1234");
        productRequest.setCustomerTypeDocument("cc");
        List<ProductResponse> response = new ProductResponseBuilder().getData();
        Mockito.when(creditGateway.getProductResponse(productRequest.getCustomerDocument(),productRequest.getCustomerTypeDocument(),"token")).thenReturn(response);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
        productService = new ProductService(creditGateway,sessionIdGateway);
        assertNotNull(productService.getProducts(productRequest,"2587413698"));
    }

    @Test (expected = BusinessException.class)
    public void getProducts_COR08() {
        productRequest = new ProductRequest();
        productRequest.setCustomerDocument("1234");
        productRequest.setCustomerTypeDocument("cc");
        List<ProductResponse> response = new ProductResponseBuilder().getData();
        Mockito.when(creditGateway.getProductResponse(productRequest.getCustomerDocument(),productRequest.getCustomerTypeDocument(),"token")).thenReturn(response);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(false);
        productService = new ProductService(creditGateway,sessionIdGateway);
        assertNotNull(productService.getProducts(productRequest,"2587413698"));
    }
}
