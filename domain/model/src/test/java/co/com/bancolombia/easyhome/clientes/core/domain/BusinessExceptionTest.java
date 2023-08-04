package co.com.bancolombia.easyhome.clientes.core.domain;

import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessExeptionType;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessExceptionTest {

    BusinessException error;

    @After
    public void setUp() {
        BusinessException error = null;
    }

    @Test
    public void errorER02() {
        error = new BusinessException(BusinessExeptionType.COR10);
        assertEquals("COR10-ERROR AL CONSULTAR LA INFORMACIÓN DEL CLIENTE", error.getMessage());
    }

    @Test
    public void errorER03() {
        error = new BusinessException(BusinessExeptionType.COR11);
        assertEquals("COR11-ERROR AL MOSTRAR LA INFORMACIÓN DE SIMULACIÓN", error.getMessage());
    }

    @Test
    public void errorER04() {
        error = new BusinessException(BusinessExeptionType.COR12);
        assertEquals("COR12-NO SE SELECCIONÓ CORRECTAMENTE LA OPCIONES DE SIMULACIÓN", error.getMessage());
    }

    @Test
    public void errorER05() {
        error = new BusinessException(BusinessExeptionType.COR13);
        assertEquals("COR13-NO SE CONFIRMÓ EL CAMBIO CORRECTAMENTE", error.getMessage());
    }

    @Test
    public void errorER06() {
        error = new BusinessException(BusinessExeptionType.COR14);
        assertEquals("COR14-ERROR AL FIRMAR EL DOCUMENTO", error.getMessage());
    }

    @Test
    public void errorER07() {
        error = new BusinessException(BusinessExeptionType.COR15);
        assertEquals("COR15-ERROR AL RADICAR LA SOLICITUD", error.getMessage());
    }

    @Test
    public void errorER08() {
        error = new BusinessException(BusinessExeptionType.COR16);
        assertEquals("COR16-LOS DATOS INGRESADOS EN LA SOLICITUD SON INCORRECTOS", error.getMessage());
    }

    @Test
    public void errorER09() {
        error = new BusinessException(BusinessExeptionType.COR17);
        assertEquals("COR17-ERROR AL GUARDAR LA SOLICITUD DE APLIACIÓN DE PLAZO", error.getMessage());
    }

    @Test
    public void errorER10() {
        error = new BusinessException(BusinessExeptionType.COR18);
        assertEquals("COR18-EL VALOR DEL NUEVO PLAZO NO PUEDE SER MENOR AL ANTERIOR", error.getMessage());
    }

}
