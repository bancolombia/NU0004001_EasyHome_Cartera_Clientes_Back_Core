package co.com.bancolombia.easyhome.clientes.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;
@TestPropertySource(properties = {"databaseConfig.driver=org.postgresql.Driver", "databaseConfig.connectionString=jdbc:postgresql://%s:%s/%s"})
@ContextConfiguration(classes = JpaConfig.class)
public class JpaConfigTest {

    @Autowired
    private DataSource dataSource;
    public void getDataSource() throws Exception{
        assertNotNull(dataSource.getConnection());
    }
}