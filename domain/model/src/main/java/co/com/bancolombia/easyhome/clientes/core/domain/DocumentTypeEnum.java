package co.com.bancolombia.easyhome.clientes.core.domain;
public enum DocumentTypeEnum {
    CARNE_DIPLOMATICO("0"),
    CEDULA_DE_CIUDADANIA("1"),
    CEDULA_DE_EXTRANJERIA("2"),
    NIT("3"),
    TARJETA_DE_IDENTIDAD("4"),
    PASAPORTE("5"),
    ID_EXTRANJERO_PN_NO_RESIDENTE_EN_COLOMBIA("6"),
    ID_EXTRANJERO_PJ_NO_RESIDENTE_EN_COLOMBIA("7"),
    FIDEICOMISO("8"),
    REGISTRO_CIVIL("9");
    private String mensaje;
    private DocumentTypeEnum(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return this.mensaje;
    }
}
