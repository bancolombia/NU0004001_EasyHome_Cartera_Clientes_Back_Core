package co.com.bancolombia.easyhome.clientes.core.handler;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ErrorMessageTest {

    private ErrorMessage errorMessage;
    private ErrorMessage errorMessageInstance;

    @Before
    public void setUp(){
        errorMessage = new ErrorMessage();
        errorMessage.setCode("BE001");
        errorMessage.setMessage("Mensaje de error");
        errorMessage.setDate(LocalDateTime.parse("2007-12-03T10:15:30"));
    }

    @Test
    public void allArgumentsConstructorTest(){
        errorMessageInstance =new ErrorMessage();
        assertEquals(errorMessage.getClass(), errorMessageInstance.getClass());
    }

    @Test
    public void getCodeTest(){
        assertEquals("BE001",errorMessage.getCode());
    }

    @Test
    public void getDateTest(){
        assertEquals(LocalDateTime.parse("2007-12-03T10:15:30"),errorMessage.getDate());
    }

    @Test
    public void getMessageTest(){
        assertEquals("Mensaje de error",errorMessage.getMessage());
    }

    @Test
    public void setCodeTest(){
        errorMessage.setCode("BE002");
        assertEquals("BE002", errorMessage.getCode());
    }

    @Test
    public void setDateTest(){
        errorMessage.setDate(LocalDateTime.parse("2007-12-03T10:15:30"));
        assertEquals(LocalDateTime.parse("2007-12-03T10:15:30"),errorMessage.getDate());
    }

    @Test
    public void setMessageTest(){
        errorMessage.setMessage("Otro Error");
        assertEquals("Otro Error", errorMessage.getMessage());
    }


}
