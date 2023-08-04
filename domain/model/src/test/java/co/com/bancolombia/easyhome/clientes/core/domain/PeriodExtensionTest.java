package co.com.bancolombia.easyhome.clientes.core.domain;

import co.com.bancolombia.easyhome.clientes.core.domain.PeriodExtension;
import co.com.bancolombia.easyhome.clientes.core.status.StatusPeriodExtension;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class PeriodExtensionTest {

    private PeriodExtension periodExtension;
    private PeriodExtension periodExtensionInstance;

    @Before
    public void setUp() {
        periodExtension = new PeriodExtension();
        periodExtension.setId(1234);
        periodExtension.setCustomerName("juan");
        periodExtension.setDocumentNumber("22445577");
        periodExtension.setDocumentType("CC");
        periodExtension.setNewTerms(2);
        periodExtension.setOldTerms(0);
        periodExtension.setObligationNumber("435345675");
        periodExtension.setRequestDate(LocalDateTime.parse("2020-04-25 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        periodExtension.setStatus(StatusPeriodExtension.SOLICITADO.getStatus());
        periodExtension.setRegistrationNumber(1l);
    }
    @Test
    public void allArgumentsConstructor(){
        periodExtensionInstance = new PeriodExtension();
        assertEquals(periodExtension.getClass(),periodExtensionInstance.getClass());
    }

    @Test
    public void getId(){
        assertEquals(1234, periodExtension.getId());
    }

    @Test
    public void setId(){
        periodExtension.setId(1234);
        assertEquals(1234,periodExtension.getId());
    }

    @Test
    public void getCustomer_name(){
        assertEquals("juan", periodExtension.getCustomerName());
    }

    @Test
    public void setCustomer_name(){
        periodExtension.setCustomerName("juan");
        assertEquals("juan",periodExtension.getCustomerName());
    }

    @Test
    public void getDocument_number(){
        assertEquals("22445577", periodExtension.getDocumentNumber());
    }

    @Test
    public void setDocument_number(){
        periodExtension.setDocumentNumber("1234");
        assertEquals("1234",periodExtension.getDocumentNumber());
    }

    @Test
    public void getDocument_type(){
        assertEquals("CC", periodExtension.getDocumentType());
    }

    @Test
    public void setDocument_type(){
        periodExtension.setDocumentType("NI");
        assertEquals("NI",periodExtension.getDocumentType());
    }

    @Test
    public void getNewTerms(){
        assertEquals(2, periodExtension.getNewTerms());
    }

    @Test
    public void setNewTerms(){
        periodExtension.setNewTerms(1);
        assertEquals(1,periodExtension.getNewTerms());
    }

    @Test
    public void getObligation_number(){
        assertEquals("435345675", periodExtension.getObligationNumber());
    }

    @Test
    public void setObligation_number(){
        periodExtension.setObligationNumber("444433");
        assertEquals("444433",periodExtension.getObligationNumber());
    }

    @Test
    public void getRequest_date(){
        assertEquals(LocalDateTime.parse("2020-04-25 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), periodExtension.getRequestDate());
    }

    @Test
    public void setRequest_date(){
        periodExtension.setRequestDate(LocalDateTime.parse("2020-04-28 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        assertEquals(LocalDateTime.parse("2020-04-28 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),periodExtension.getRequestDate());
    }

    @Test
    public void getOldTerms(){
        assertEquals(0, periodExtension.getOldTerms());
    }

    @Test
    public void setOldTerms(){
        periodExtension.setOldTerms(1);
        assertEquals(1,periodExtension.getOldTerms());
    }

    @Test
    public void getStatus(){
        assertEquals(1, periodExtension.getStatus());
    }

    @Test
    public void setStatus(){
        periodExtension.setRegistrationNumber(2l);
        assertEquals(2l,periodExtension.getRegistrationNumber());
    }
    @Test
    public void getRegistrationNumber(){

        assertEquals(1l, periodExtension.getRegistrationNumber());
    }

    @Test
    public void setRegistrationNumber(){
        periodExtension.setRegistrationNumber(2l);
        assertEquals(2l,periodExtension.getRegistrationNumber());
    }
}
