package co.com.bancolombia.easyhome.clientes.core.exceptions;
public enum BusinessExeptionType {
    INA("Invalid amount"),
    COR01("COR01-OCURRIO UN ERROR CONSUMIENDO EL SERVICIO"),
    COR02("COR02-ERROR AL CONVERTIR LA RESPUESTA OBTENIDA POR EL SERVICIO"),
    COR03("COR03-Mensaje enviado por el sistema consumidor no es valido"),
    COR04("COR04-La funcionalidad solicitada por el sistema consumidor no fue encontrada \n" +
            "bajo las credenciales suministradas."),
    COR05("COR05-Ha ocurrido un error interno controlado en el servidor."),
    COR06("COR06-El ESB ha detectado una expiración en el procesamiento de la solicitud."),
    COR07("COR07-YA EXISTE UNA SOLICITUD DE AMPLIACIÓN PARA ESTA OBLIGACIÓN"),
    COR08("COR08 - Ocurrió un error validando las credenciales."),
    COR10("COR10-ERROR AL CONSULTAR LA INFORMACIÓN DEL CLIENTE"),
    COR11("COR11-ERROR AL MOSTRAR LA INFORMACIÓN DE SIMULACIÓN"),
    COR12("COR12-NO SE SELECCIONÓ CORRECTAMENTE LA OPCIONES DE SIMULACIÓN"),
    COR13("COR13-NO SE CONFIRMÓ EL CAMBIO CORRECTAMENTE"),
    COR14("COR14-ERROR AL FIRMAR EL DOCUMENTO"),
    COR15("COR15-ERROR AL RADICAR LA SOLICITUD"),
    COR16("COR16-LOS DATOS INGRESADOS EN LA SOLICITUD SON INCORRECTOS"),
    COR17("COR17-ERROR AL GUARDAR LA SOLICITUD DE APLIACIÓN DE PLAZO"),
    COR18("COR18-EL VALOR DEL NUEVO PLAZO NO PUEDE SER MENOR AL ANTERIOR");

    private String message;
    private BusinessExeptionType(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}