package co.com.bancolombia.easyhome.clientes.core.common.gateways;

public interface SecretManagerConsumer<T> {
    T getSecrets(Class<T> cls, String secretRegion, String secretName) throws Exception;

}

