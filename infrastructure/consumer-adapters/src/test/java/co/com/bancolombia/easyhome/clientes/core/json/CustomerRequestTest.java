package co.com.bancolombia.easyhome.clientes.core.json;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerRequestTest {

    CustomerRequest customerRequest;
    @Before
    public void setUp() throws Exception {
        customerRequest = new CustomerRequest();
        customerRequest.setCustomerId("123456");
        customerRequest.setCustomerIdType("1");

    }

    @Test
    public void getCustomerIdType() {
        String customerIdType="1";
        assertEquals(customerIdType,customerRequest.getCustomerIdType());
    }

    @Test
    public void getCustomerId() {
        String customerId="123456";
        assertEquals(customerId,customerRequest.getCustomerId());
    }
}
