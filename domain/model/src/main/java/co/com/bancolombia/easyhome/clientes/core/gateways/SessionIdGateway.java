package co.com.bancolombia.easyhome.clientes.core.gateways;

public interface SessionIdGateway {
    public boolean sessionIdValid(String customerIdType, String customerId, String sessionToken) ;

}