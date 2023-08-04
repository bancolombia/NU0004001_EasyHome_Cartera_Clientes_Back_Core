package co.com.bancolombia.easyhome.clientes.core.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)

public class SecretModel {

    private final String user;

    private final String password;

    private final String host;

    private final String dbName;

    private final String port;
}
