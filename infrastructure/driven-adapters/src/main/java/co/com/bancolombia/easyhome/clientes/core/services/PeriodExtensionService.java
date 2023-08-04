package co.com.bancolombia.easyhome.clientes.core.services;

import co.com.bancolombia.easyhome.clientes.core.domain.PeriodExtension;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessException;
import co.com.bancolombia.easyhome.clientes.core.exceptions.BusinessExeptionType;
import co.com.bancolombia.easyhome.clientes.core.gateways.SessionIdGateway;
import co.com.bancolombia.easyhome.clientes.core.json.PeriodExtensionRequest;
import co.com.bancolombia.easyhome.clientes.core.repositories.PeriodExtensionRepository;
import co.com.bancolombia.easyhome.clientes.core.status.StatusPeriodExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class PeriodExtensionService {

    private final PeriodExtensionRepository periodExtensionRepository;
    private final SessionIdGateway sessionIdGateway;

    public Long save(PeriodExtensionRequest information, String token) {
        Boolean sessionValid = sessionIdGateway.sessionIdValid(information.getDocumentType(),
                information.getDocumentNumber(),token);
        if(!sessionValid){
            throw new BusinessException(BusinessExeptionType.COR08);
        }
        if(periodExtensionRepository.existsPeriodExtensionEntityByObligationNumber
                (information.getObligationNumber())){
            throw new BusinessException(BusinessExeptionType.COR07);
        }
        if(information.getNewTerms()>information.getOldTerms()){
            PeriodExtension periodExtension = new PeriodExtension();
            periodExtension.setDocumentType(information.getDocumentType());
            periodExtension.setDocumentNumber(information.getDocumentNumber());
            periodExtension.setCustomerName(information.getCustomerName());
            periodExtension.setObligationNumber(information.getObligationNumber());
            periodExtension.setNewTerms(information.getNewTerms());
            periodExtension.setOldTerms(information.getOldTerms());
            periodExtension.setStatus(StatusPeriodExtension.SOLICITADO.getStatus());
            LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Bogota"));
            periodExtension.setRequestDate(now);
            boolean objSave = periodExtensionRepository.savePeriodExtension(periodExtension);
            if(objSave){
                PeriodExtension aux = periodExtensionRepository.findFirstByObligationNumber
                        (information.getObligationNumber());
                return aux.getRegistrationNumber();
            }else{
                throw new BusinessException(BusinessExeptionType.COR17);
            }
        }else{
            throw new BusinessException(BusinessExeptionType.COR18);
        }
    }
}
