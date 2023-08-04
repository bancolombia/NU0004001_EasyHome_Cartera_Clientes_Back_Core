package co.com.bancolombia.easyhome.clientes.core.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeriodExtension {
    private long id;
    private String documentType;
    private String documentNumber;
    private String customerName;
    private String obligationNumber;
    private long oldTerms;
    private long newTerms;
    private LocalDateTime requestDate;
    private int status;
    private long registrationNumber;
}
