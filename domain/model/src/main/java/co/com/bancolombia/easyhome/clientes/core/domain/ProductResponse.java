package co.com.bancolombia.easyhome.clientes.core.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    private Double balance;
    private Double fee;
    private String dueDate;
    private String productType;
    private Integer Terms;
    private  Boolean status;
    private Double sure;
    private String firstDisbursementDate;
    @JsonProperty("productNumber")
    private Long accountNumber;
    @JsonProperty("productDescription")
    private String amortizationPayments;
    @JsonProperty("annualRate")
    private Double interestRate;
    @JsonProperty("nextFee")
    private String paymentNumber;
    @JsonProperty("nextFeeDate")
    private String nextPaymentDate;
    @JsonProperty("moraIndicator")
    private String arrearsIndicator;
    private String governmentSubsidy;
    private String lastRestructuringDate;
    private int inAdvancePayments;
    private String legalFee;
    private Double initialDisbursement;
    private Double feeValueWithoutInsurance;
    private Double totalBalanceValue;
}
