package co.com.bancolombia.easyhome.clientes.core.domain;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsuranceBalanceTest {

    private  InsuranceBalance insuranceBalance;
    private InsuranceBalance insuranceBalanceInstance;
    @Before
    public void setUp(){
        insuranceBalance = new InsuranceBalance();
        insuranceBalance.setCodigoMonedaISO4217Alfabetico("COP");
        insuranceBalance.setInsuranceBalance(11.572);
    }
    @Test
    public void allArgumentsConstructor() {
        insuranceBalanceInstance = new InsuranceBalance();
        assertEquals(insuranceBalance.getClass(), insuranceBalanceInstance.getClass());
    }

    @Test
    public void getCodigoMonedaISO4217Alfabetico() {
        String codigo="COP";
        assertEquals(codigo,insuranceBalance.getCodigoMonedaISO4217Alfabetico());

    }

    @Test
    public void getInsuranceBalance() {
        Double sure=11.572;
        assertEquals(sure,insuranceBalance.getInsuranceBalance());

    }
}
