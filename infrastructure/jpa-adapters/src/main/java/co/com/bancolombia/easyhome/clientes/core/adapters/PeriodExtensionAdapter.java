package co.com.bancolombia.easyhome.clientes.core.adapters;
import co.com.bancolombia.easyhome.clientes.core.domain.PeriodExtension;
import co.com.bancolombia.easyhome.clientes.core.repositories.PeriodExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeriodExtensionAdapter implements PeriodExtensionRepository {

    @Override
    public Boolean savePeriodExtension(PeriodExtension periodExtension) {
        return null;
    }

    @Override
    public Boolean existsPeriodExtensionEntityByObligationNumber(String obligationNumber) {
        return null;
    }

    @Override
    public PeriodExtension findFirstByObligationNumber(String obligationNumber) {
        return null;
    }
}