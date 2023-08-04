package co.com.bancolombia.easyhome.clientes.core.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SignatureResponse {
//    private String city;
//    private int day;
//    private String month;
//    private int year;


    private String participantIdNumber;
    private String participantIdType;
    private String relationship;
    private String participantFullName;

}
