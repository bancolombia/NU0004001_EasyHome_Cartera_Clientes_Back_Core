package co.com.bancolombia.easyhome.clientes.core.jpa.cofig;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = "co.com.bancolombia.easyhome.clientes.core.jpa.entities")
@EnableJpaRepositories(basePackages = "co.com.bancolombia.easyhome.clientes.core.jpa.repositories")
@EnableTransactionManagement
public class JpaTestConfig {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://%s:%s/%s");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }
}