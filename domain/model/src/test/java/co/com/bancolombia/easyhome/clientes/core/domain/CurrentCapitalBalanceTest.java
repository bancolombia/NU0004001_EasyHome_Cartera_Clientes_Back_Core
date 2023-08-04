package co.com.bancolombia.easyhome.clientes.core.domain;

import co.com.bancolombia.easyhome.clientes.core.domain.CurrentCapitalBalance;
import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrentCapitalBalanceTest {
    private CurrentCapitalBalance currentCapitalBalance;
    private CurrentCapitalBalance currentCapitalBalanceInstance;
    @Before
    public void setUp(){
        currentCapitalBalance = new CurrentCapitalBalance();
        currentCapitalBalance.setCodigoMonedaISO4217Alfabetico("COP");
        currentCapitalBalance.setCurrentCapitalBalance(2.747926432E7);
    }

    @Test
    public void allArgumentsConstructor() {
        currentCapitalBalanceInstance = new CurrentCapitalBalance();
        assertEquals(currentCapitalBalance.getClass(), currentCapitalBalanceInstance.getClass());
    }
    @Test
    public void getCodigoMonedaISO4217Alfabetico(){
        String codigo="COP";
        assertEquals(codigo,currentCapitalBalance.getCodigoMonedaISO4217Alfabetico());
    }

    @Test
    public void getCurrentCapitalBalance(){
        Double currentCapital=2.747926432E7;
        assertEquals(currentCapital,currentCapitalBalance.getCurrentCapitalBalance());
    }
}
