package co.com.bancolombia.easyhome.clientes.core.handler;

import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessExeptionType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class GeneralControlAdviceTest {

    private BusinessException businessException;
    private GeneralControlAdvice generalControlAdvice;
    private ResponseEntity responseEntityBadRequest;
    private ErrorMessage errorMessage;

    @Before
    public void setUp() {
        businessException = new BusinessException(BusinessExeptionType.INA);
        generalControlAdvice = new GeneralControlAdvice();
        errorMessage = new ErrorMessage();
        errorMessage.setCode("BE002");
        errorMessage.setDate(LocalDateTime.parse("2012-11-03T10:15:30"));
        responseEntityBadRequest = new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @Test
    public void badRequestException() {
        assertEquals(responseEntityBadRequest.getStatusCode(), generalControlAdvice.exception(businessException).getStatusCode());
    }
}
