package co.com.bancolombia.easyhome.clientes.core.domain;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentValueTest {
    private PaymentValue paymentValue;
    private PaymentValue paymentValueInstance;
    @Before
    public void setUp(){
        paymentValue = new PaymentValue();
        paymentValue.setCodigoMonedaISO4217Alfabetico("COP");
        paymentValue.setPaymentValue(2.747926432E7);
    }

    @Test
    public void allArgumentsConstructor() {
        paymentValueInstance = new PaymentValue();
        assertEquals(paymentValue.getClass(), paymentValueInstance.getClass());
    }
    @Test
    public void getCodigoMonedaISO4217Alfabetico(){
        String codigo="COP";
        assertEquals(codigo,paymentValue.getCodigoMonedaISO4217Alfabetico());
    }

    @Test
    public void getCurrentCapitalBalance(){
        Double payment=2.747926432E7;
        assertEquals(payment,paymentValue.getPaymentValue());
    }
}
