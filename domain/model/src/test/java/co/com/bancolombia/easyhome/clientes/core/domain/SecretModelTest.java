package co.com.bancolombia.easyhome.clientes.core.domain;

import co.com.bancolombia.easyhome.clientes.core.common.SecretModel;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SecretModelTest {

    private SecretModel model;
    private SecretModel modelInstance;

    @Before
    public void setUp() {
        model = SecretModel.builder().user("juan").password("1234").host("8080").dbName("easyhome").port("4006").build();

    }

    @Test
    public void getUser() {
        assertEquals("juan", model.getUser());
    }

    @Test
    public void getPaswword() {
        assertEquals("1234", model.getPassword());
    }

    @Test
    public void getHost() {
        assertEquals("8080", model.getHost());
    }

    @Test
    public void geDbName() {
        assertEquals("easyhome", model.getDbName());
    }

    @Test
    public void getPort() {
        assertEquals("4006", model.getPort());
    }


}
