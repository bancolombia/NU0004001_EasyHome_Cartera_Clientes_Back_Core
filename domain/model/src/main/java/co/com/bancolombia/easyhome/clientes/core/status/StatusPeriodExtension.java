package co.com.bancolombia.easyhome.clientes.core.status;

public enum StatusPeriodExtension {

    SOLICITADO(1),
    APROBADO(2);

    private int status;

    private StatusPeriodExtension(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}