package co.com.bancolombia.easyhome.clientes.core.rest;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessExeptionType;
import co.com.bancolombia.easyhome.clientes.core.gateways.SessionIdGateway;
import co.com.bancolombia.easyhome.clientes.core.json.PeriodExtensionRequest;
import co.com.bancolombia.easyhome.clientes.core.json.ProductRequest;
import co.com.bancolombia.easyhome.clientes.core.services.PeriodExtensionService;
import co.com.bancolombia.easyhome.clientes.core.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PeriodExtensionControllerTest {

    private MockMvc mockMvc;
    private PeriodExtensionRequest request;
    @Mock
    private ProductService productService;
    @Mock
    private PeriodExtensionService periodExtensionService;
    @Mock
    private ProductRequest productRequest;
    @Mock
    private SessionIdGateway sessionIdGateway;
    private MockMvc mockProducts;


    List<ProductResponse> productList;
    @InjectMocks
    private PeriodExtensionController periodExtensionController;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(periodExtensionController, periodExtensionService).build();
        request = new PeriodExtensionRequest();
        productRequest.setCustomerDocument("1000026299");
        productRequest.setCustomerTypeDocument("1");
        mockProducts = MockMvcBuilders.standaloneSetup(periodExtensionController,productService).build();
        ProductResponse product1 = new ProductResponse();
        productList = new ArrayList() {{
            add(product1);
        }};
        sessionIdGateway = Mockito.mock(SessionIdGateway.class);
    }

    @Test
    public void saveTest() throws Exception {
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setOldTerms(2);
        request.setNewTerms(5);
        request.setObligationNumber("435345675");
        Mockito.when(periodExtensionService.save(any(PeriodExtensionRequest.class),any())).thenReturn(35L);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
        Cookie cookie = new Cookie("token","123456985475");
        Cookie documentNumber = new Cookie("documentNumber","96258741");
        Cookie documentType = new Cookie("documentType","CC");
        mockMvc.perform(
                    MockMvcRequestBuilders.post("/core/customer_information/save")
                            .cookie(cookie)
                            .cookie(documentNumber)
                            .cookie(documentType)
                            .content(asJsonString(request))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void saveErrorTest() throws Exception{
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setOldTerms(10);
        request.setNewTerms(5);
        request.setObligationNumber("435345675");
        try {
        Mockito.when(periodExtensionService.save(any(PeriodExtensionRequest.class),any())).thenThrow(new BusinessException(BusinessExeptionType.COR18));
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
            Cookie cookie = new Cookie("token","123456985475");
            Cookie documentNumber = new Cookie("documentNumber","96258741");
            Cookie documentType = new Cookie("documentType","CC");
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/core/customer_information/save")
                            .cookie(cookie)
                            .cookie(documentNumber)
                            .cookie(documentType)
                            .content(asJsonString(request))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
            ).andExpect(MockMvcResultMatchers.status().isBadRequest());;
        }catch (Exception e){
            if(e.getCause() instanceof BusinessException){
                Assert.assertEquals("Request processing failed; nested exception is co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException: COR18-EL VALOR DEL NUEVO PLAZO NO PUEDE SER MENOR AL ANTERIOR",e.getMessage());
            } else {
                Assert.fail("unexpected exception");
            }
        }
    }

    @Test
    public void getProductsTest() throws Exception {
        when(productService.getProducts(productRequest,"123456987")).thenReturn(productList);
        Cookie token = new Cookie("token", "123456789");
        Cookie documentType = new Cookie("documentType", "CC");
        Cookie documentNumber = new Cookie("documentNumber", "22445577");


        mockProducts.perform(MockMvcRequestBuilders.post("/core/customer_information/products")
                .header("Authorization","Bearer 123456789").cookie(token, documentNumber, documentType)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
//    @Test
//    public void save_ERR18() throws Exception {
//        request.setCustomerName("Antonio gomez");
//        request.setDocumentNumber("22445577");
//        request.setDocumentType("CC");
//        request.setOldTerms(10);
//        request.setNewTerms(5);
//        request.setObligationNumber("435345675");
//        try {
//            Mockito.when(periodExtensionService.save(any(PeriodExtensionRequest.class),any())).thenThrow(new BusinessException(BusinessExeptionType.COR08));
//            Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(false);
//            Cookie cookie = new Cookie("token","123456985475");
//            Cookie documentNumber = new Cookie("documentNumber","96258741");
//            Cookie documentType = new Cookie("documentType","CC");
//            mockMvc.perform(
//                    MockMvcRequestBuilders.post("/core/customer_information/save")
//                            .cookie(cookie)
//                            .cookie(documentNumber)
//                            .cookie(documentType)
//                            .content(asJsonString(request))
//                            .contentType(MediaType.APPLICATION_JSON_VALUE)
//            ).andExpect(MockMvcResultMatchers.status().isBadRequest());;
//        }catch (Exception e){
//            if(e.getCause() instanceof BusinessException){
//                Assert.assertEquals("Request processing failed; nested exception is co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException: COR08 - Ocurrió un error validando las credenciales.",e.getMessage());
//            } else {
//                Assert.fail("unexpected exception");
//            }
//        }
//    }
}
