package co.com.bancolombia.easyhome.clientes.core.services;

import co.com.bancolombia.easyhome.clientes.core.domain.PeriodExtension;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.gateways.SessionIdGateway;
import co.com.bancolombia.easyhome.clientes.core.json.PeriodExtensionRequest;
import co.com.bancolombia.easyhome.clientes.core.repositories.PeriodExtensionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
public class PeriodExtensionServiceTest {

    private PeriodExtensionService periodExtensionService;
    private PeriodExtensionRepository periodExtensionRepository;
    private PeriodExtensionRequest request;
    private PeriodExtension periodExtension;
    private SessionIdGateway sessionIdGateway;
    @Before
    public void setUp() {
        periodExtensionRepository = Mockito.mock(PeriodExtensionRepository.class);
        periodExtension = new PeriodExtension();
        periodExtension.setRegistrationNumber(35L);
        sessionIdGateway = Mockito.mock(SessionIdGateway.class);
    }

    @Test
    public void save() {
        request = new PeriodExtensionRequest();
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setNewTerms(2);
        request.setObligationNumber("435345675");
        request.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Mockito.when(periodExtensionRepository.savePeriodExtension(ArgumentMatchers.any(PeriodExtension.class))).thenReturn(true);
        Mockito.when(periodExtensionRepository.findFirstByObligationNumber("435345675")).thenReturn(periodExtension);
        periodExtensionService = new PeriodExtensionService(periodExtensionRepository, sessionIdGateway);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
        assertNotNull(periodExtensionService.save(request,"125874693"));
    }

    @Test (expected = BusinessException.class)
    public void whenExceptionThrown_COR18(){
        request = new PeriodExtensionRequest();
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setNewTerms(6);
        request.setOldTerms(5);
        request.setObligationNumber("435345675");
        request.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Mockito.when(periodExtensionRepository.savePeriodExtension(ArgumentMatchers.any(PeriodExtension.class))).thenReturn(false);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
        periodExtensionService = new PeriodExtensionService(periodExtensionRepository,sessionIdGateway);
        periodExtensionService.save(request,"1234656789");
    }

    @Test (expected = BusinessException.class)
    public void whenExceptionThrown_COR07(){
        request = new PeriodExtensionRequest();
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setNewTerms(2);
        request.setOldTerms(5);
        request.setObligationNumber("435345675");
        request.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Mockito.when(periodExtensionRepository.existsPeriodExtensionEntityByObligationNumber(any())).thenReturn(true);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
        periodExtensionService = new PeriodExtensionService(periodExtensionRepository,sessionIdGateway);
        periodExtensionService.save(request,"1234656789");
    }

    @Test (expected = BusinessException.class)
    public void whenExceptionThrown_COR08(){
        request = new PeriodExtensionRequest();
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setNewTerms(2);
        request.setOldTerms(5);
        request.setObligationNumber("435345675");
        request.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setNewTerms(2);
        request.setOldTerms(5);
        request.setObligationNumber("435345675");
        request.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(false);
        periodExtensionService = new PeriodExtensionService(periodExtensionRepository,sessionIdGateway);
        periodExtensionService.save(request,"1234656789");
    }
    @Test (expected = BusinessException.class)
    public void whenExceptionThrown_COR17(){
        request = new PeriodExtensionRequest();
        request.setCustomerName("Antonio gomez");
        request.setDocumentNumber("22445577");
        request.setDocumentType("CC");
        request.setNewTerms(8);
        request.setOldTerms(5);
        request.setObligationNumber("435345675");
        request.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Mockito.when(periodExtensionRepository.savePeriodExtension(ArgumentMatchers.any(PeriodExtension.class))).thenReturn(false);
        Mockito.when(sessionIdGateway.sessionIdValid(any(),any(),any())).thenReturn(true);
        periodExtensionService = new PeriodExtensionService(periodExtensionRepository,sessionIdGateway);
        periodExtensionService.save(request,"1234656789");
    }
}
