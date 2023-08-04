package co.com.bancolombia.easyhome.clientes.core.config;

import co.com.bancolombia.logging.technical.LoggerFactory;
import co.com.bancolombia.logging.technical.ObjectTechMsg;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import okhttp3.OkHttpClient;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class BeanConfig {

   @Bean
    public ObjectMapper objectMapperImpl(){
        return new ObjectMapperImp();
    }

    @Bean
    public TechLogger techLogger() {
        TechLogger techLogger = LoggerFactory.getLog("Core");
        Configurator.setLevel(techLogger.getName(), Level.INFO);
        return techLogger;
    }
    @Bean
    public ObjectTechMsg<Map<String, Object>> techMessage() {
        return new ObjectTechMsg<Map<String, Object>>(null, "Core", "Core", "NU0004001", Collections.emptyList(), new HashMap<>());
    }

    @Bean
    public OkHttpClient okHttpClient(){
       return new OkHttpClient();
    }
}
