package co.com.bancolombia.easyhome.clientes.core.services.util;

import co.com.bancolombia.easyhome.clientes.core.domain.PeriodExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PeriodExtensionBuilder {

    private String customer_name;

    public PeriodExtensionBuilder withCustomer_name(String name) {
        this.customer_name = name;
        return this;
    }

    public PeriodExtension getData() {
        PeriodExtension periodExtension = new PeriodExtension();
        periodExtension.setCustomerName(customer_name);
        periodExtension.setId((long) 1);
        periodExtension.setDocumentNumber("22445577");
        periodExtension.setDocumentType("CC");
        periodExtension.setNewTerms(2);
        periodExtension.setObligationNumber("435345675");
        periodExtension.setRequestDate(LocalDateTime.parse("2020-04-25 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        return periodExtension;
    }

    @Override
    public String toString() {
        return "ModelBuilder{" +
                "customer_name='" + customer_name + '\'' +
                '}';
    }
}
