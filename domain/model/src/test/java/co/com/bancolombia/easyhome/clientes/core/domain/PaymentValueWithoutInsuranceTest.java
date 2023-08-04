package co.com.bancolombia.easyhome.clientes.core.domain;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentValueWithoutInsuranceTest {
    private PaymentValueWithoutInsurance paymentValue;
    private PaymentValueWithoutInsurance paymentValueInstance;

    @Before
    public void setUp() throws Exception {
        paymentValue = new PaymentValueWithoutInsurance();
        paymentValue.setPaymentValueWithoutInsurance(2.747926432E7);
    }
    @Test
    public void allArgumentsConstructor() {
        paymentValueInstance = new PaymentValueWithoutInsurance();
        assertEquals(paymentValue.getClass(), paymentValueInstance.getClass());
    }

    @Test
    public void getCurrentCapitalBalance() {
        Double payment = 2.747926432E7;
        assertEquals(payment, paymentValue.getPaymentValueWithoutInsurance());
    }
}
