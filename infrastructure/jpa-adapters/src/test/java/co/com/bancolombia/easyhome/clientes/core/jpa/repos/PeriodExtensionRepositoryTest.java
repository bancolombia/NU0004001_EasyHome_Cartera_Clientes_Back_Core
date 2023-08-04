package co.com.bancolombia.easyhome.clientes.core.jpa.repos;

import co.com.bancolombia.easyhome.clientes.core.jpa.cofig.JpaTestConfig;
import co.com.bancolombia.easyhome.clientes.core.jpa.entities.PeriodExtensionEntity;
import co.com.bancolombia.easyhome.clientes.core.jpa.repositories.PeriodExtensionJpaRepository;
import co.com.bancolombia.easyhome.clientes.core.status.StatusPeriodExtension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaTestConfig.class })
@DataJpaTest
@Sql({"classpath:data-h2.sql"})
public class PeriodExtensionRepositoryTest {

    @Autowired
    private PeriodExtensionJpaRepository periodExtensionJpaRepository;

    @Test
    public void saveTest(){
        PeriodExtensionEntity periodExtensionEntity= new PeriodExtensionEntity();
        periodExtensionEntity.setId((long) 1);
        periodExtensionEntity.setCustomerName("Antonio gomez");
        periodExtensionEntity.setDocumentNumber("22445577");
        periodExtensionEntity.setDocumentType("CC");
        periodExtensionEntity.setNewTerms(2);
        periodExtensionEntity.setOldTerms(1);
        periodExtensionEntity.setObligationNumber("435345675");
        periodExtensionEntity.setRequestDate(LocalDateTime.parse("2020-04-24 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        periodExtensionEntity.setStatus(StatusPeriodExtension.SOLICITADO.getStatus());
        periodExtensionEntity.setRegistrationNumber(35l);
        PeriodExtensionEntity periodExtensionEntitySave = periodExtensionJpaRepository.save(periodExtensionEntity);
        if(periodExtensionEntitySave.getId()!=null){
            Assert.assertNotNull(periodExtensionEntity.getCustomerName());
            Assert.assertEquals("Antonio gomez",periodExtensionEntity.getCustomerName());
            Assert.assertEquals("22445577",periodExtensionEntity.getDocumentNumber());
            Assert.assertEquals("CC",periodExtensionEntity.getDocumentType());
            Assert.assertEquals(2,periodExtensionEntity.getNewTerms());
            Assert.assertEquals(1,periodExtensionEntity.getOldTerms());
            Assert.assertEquals("435345675",periodExtensionEntity.getObligationNumber());
            Assert.assertEquals(35l,periodExtensionEntity.getRegistrationNumber());
            Assert.assertEquals(StatusPeriodExtension.SOLICITADO.getStatus(),periodExtensionEntity.getStatus());
        }else{
            Assert.fail();
        }
    }

    @Test
    public void findAllTest(){
        Optional<PeriodExtensionEntity> periodExtensionEntityOpt = periodExtensionJpaRepository.findAll().stream().findFirst();
        if(periodExtensionEntityOpt.isPresent()){
            PeriodExtensionEntity periodExtensionEntity = periodExtensionEntityOpt.get();
            Assert.assertNotNull(periodExtensionEntity.getId());
            Assert.assertNotNull(periodExtensionEntity.getCustomerName());
            Assert.assertNotNull(periodExtensionEntity.getDocumentNumber());
            Assert.assertNotNull(periodExtensionEntity.getDocumentType());
            Assert.assertNotNull(periodExtensionEntity.getNewTerms());
            Assert.assertNotNull(periodExtensionEntity.getObligationNumber());
            Assert.assertNotNull(periodExtensionEntity.getRequestDate());
            Assert.assertNotNull(periodExtensionEntity.getRegistrationNumber());
        }else{
            Assert.fail();
        }
    }
}
