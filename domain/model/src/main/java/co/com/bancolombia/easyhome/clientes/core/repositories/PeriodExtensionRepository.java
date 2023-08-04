package co.com.bancolombia.easyhome.clientes.core.repositories;
import co.com.bancolombia.easyhome.clientes.core.domain.PeriodExtension;
public interface PeriodExtensionRepository {

    Boolean savePeriodExtension(PeriodExtension periodExtension);
    Boolean existsPeriodExtensionEntityByObligationNumber(String obligationNumber);
    PeriodExtension findFirstByObligationNumber(String obligationNumber);
}
