package co.com.bancolombia.easyhome.clientes.core.exceptions;
public class BusinessException extends RuntimeException {
    private final BusinessExeptionType type;
    public BusinessException(BusinessExeptionType type) {
        super(type.getMessage());
        this.type = type;
    }
}
