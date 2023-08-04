package co.com.bancolombia.easyhome.clientes.core.domain;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductResponseTest {

    private ProductResponse productResponse;
    private ProductResponse productResponseInstance;

    @Before
    public void setUp() {
        productResponse = new ProductResponse();
        productResponse.setNextPaymentDate("2020-06-25");
        productResponse.setPaymentNumber("35");
        productResponse.setAmortizationPayments("credito cuota fija");
        productResponse.setStatus(true);
        productResponse.setInterestRate(9.4);
        productResponse.setBalance(500000000.9);
        productResponse.setDueDate("2025-06-25");
        productResponse.setFee(1500000.0);
        productResponse.setAccountNumber(1234L);
        productResponse.setTerms(60);
        productResponse.setSure(0.12);
        productResponse.setProductType("Crédito Hipotecario");
        productResponse.setArrearsIndicator("M");
        productResponse.setGovernmentSubsidy("subsidy");
        productResponse.setLastRestructuringDate("2025-06-25");
        productResponse.setInAdvancePayments(12);
        productResponse.setLegalFee("N");
        productResponse.setFirstDisbursementDate("2020-06-20");
        productResponse.setInitialDisbursement(50.00000);
        productResponse.setFeeValueWithoutInsurance(10.000);
        productResponse.setTotalBalanceValue(100.000);
    }

    @Test
    public void allArgumentsConstructor() {
        productResponseInstance = new ProductResponse();
        assertEquals(productResponse.getClass(), productResponseInstance.getClass());
    }

    @Test
    public void getProductType(){
        String productType="Crédito Hipotecario";
        assertEquals(productType,productResponse.getProductType());
    }

    @Test
    public void setProductType(){
        productResponse.setProductType("Leasing Habitacional");
        assertEquals("Leasing Habitacional",productResponse.getProductType());
    }
    @Test
    public void getSure(){
        Double sure = 0.12;
        assertEquals(sure,productResponse.getSure());
    }
    @Test
    public void getNextFeeDate() {
        assertEquals("2020-06-25", productResponse.getNextPaymentDate());
    }


    @Test
    public void setNextFeeDate() {
        productResponse.setNextPaymentDate("2020-06-25");
        assertEquals("2020-06-25", productResponse.getNextPaymentDate());
    }


    @Test
    public void getNextFee() {
        String nextFee = "35";
        assertEquals(nextFee, productResponse.getPaymentNumber());
    }


    @Test
    public void setNextFee() {
        productResponse.setPaymentNumber("35");
        String nextFee = "35";
        assertEquals(nextFee, productResponse.getPaymentNumber());
    }

    @Test
    public void getProductDescription() {
        String productDescription = "credito cuota fija";
        assertEquals(productDescription, productResponse.getAmortizationPayments());
    }


    @Test
    public void getStatus() {
        assertEquals(true, productResponse.getStatus());
    }


    @Test
    public void setStatus() {
        productResponse.setStatus(true);
        assertEquals(true, productResponse.getStatus());
    }


    @Test
    public void getAnnualRate() {
        Double rate = 9.4;
        assertEquals(rate, productResponse.getInterestRate());
    }


    @Test
    public void setAnnualRate() {
        productResponse.setInterestRate(9.5);
        Double rate = 9.5;
        assertEquals(rate, productResponse.getInterestRate());
    }


    @Test
    public void getBalance() {
        Double balance = 500000000.9;
        assertEquals(balance, productResponse.getBalance());
    }


    @Test
    public void setBalance() {
        productResponse.setBalance(1000000.0);
        Double balance = 1000000.0;
        assertEquals(balance, productResponse.getBalance());
    }

    @Test
    public void getDueDate() {
        assertEquals("2025-06-25", productResponse.getDueDate());
    }


    @Test
    public void setDueDate() {
        productResponse.setDueDate("2020-06-25");
        assertEquals("2020-06-25", productResponse.getDueDate());
    }

    @Test
    public void getFee() {
        Double percent = 1500000.0;
        assertEquals(percent, productResponse.getFee());
    }

    @Test
    public void setFee() {
        productResponse.setFee(1500000.0);
        Double percent = 1500000.0;
        assertEquals(percent, productResponse.getFee());
    }

    @Test
    public void getProductNumber() {
        Long number = 1234L;
        assertEquals(number, productResponse.getAccountNumber());
    }

    @Test
    public void setProductNumber() {
        productResponse.setAccountNumber(1234L);
        Long number = 1234L;
        assertEquals(number, productResponse.getAccountNumber());
    }

    @Test
    public void getTerms() {
        Integer terms = 60;
        assertEquals(terms, productResponse.getTerms());
    }

    @Test
    public void setTerms() {
        productResponse.setTerms(35);
        Integer terms = 35;
        assertEquals(terms, productResponse.getTerms());
    }
    @Test
    public void testGetGovernmentSubsidy() {
        assertEquals("subsidy",productResponse.getGovernmentSubsidy());
    }
    @Test
    public void testGetLastRestructuringDate() {
        assertEquals("2025-06-25",productResponse.getLastRestructuringDate());
    }
    @Test
    public void testGetInAdvancePayments() {
        assertEquals(12,productResponse.getInAdvancePayments());
    }
    @Test
    public void testGetLegalFee() {
        assertEquals("N",productResponse.getLegalFee());
    }
    @Test
    public void testSetGovernmentSubsidy() {
        productResponse.setGovernmentSubsidy("SUBSIDIO");
        assertEquals("SUBSIDIO", productResponse.getGovernmentSubsidy());
    }
    @Test
    public void testSetLastRestructuringDate() {
        productResponse.setLastRestructuringDate("2035-06-25");
        assertEquals("2035-06-25",productResponse.getLastRestructuringDate());
    }
    @Test
    public void testSetInAdvancePayments() {
        productResponse.setInAdvancePayments(19);
        assertEquals(19,productResponse.getInAdvancePayments());
    }
    @Test
    public void testSetLegalFee() {
        productResponse.setLegalFee("Y");
        assertEquals("Y",productResponse.getLegalFee());
    }
    @Test
    public void testGetArrearsIndicator() {
        assertEquals("M",productResponse.getArrearsIndicator());

    }
    @Test
    public void testSetArrearsIndicator() {
        productResponse.setArrearsIndicator("D");
        assertEquals("D",productResponse.getArrearsIndicator());
    }
    @Test
    public void testGetFirstDisbursementDate() {
        assertEquals("2020-06-20", productResponse.getFirstDisbursementDate());
    }
    @Test
    public void testSetFirstDisbursementDate() {
        productResponse.setFirstDisbursementDate("2020-06-19");
        assertEquals("2020-06-19",productResponse.getFirstDisbursementDate());
    }

    @Test
    public void testGetInitialDisbursement() {
        Double initialDisbursement = 50.000000;

        assertEquals(initialDisbursement,productResponse.getInitialDisbursement());
    }
    @Test
    public void testSetInitialDisbursement() {
        productResponse.setInitialDisbursement(10.000000);
        Double initialDisbursement = 10.000000;
        assertEquals(initialDisbursement,productResponse.getInitialDisbursement());
    }

    @Test
    public void getFeeValueWithoutInsurance(){
        assertEquals(10.000,productResponse.getFeeValueWithoutInsurance(),10.000);
    }
    @Test
    public void getTotalBalanceValue(){
        assertEquals(100.000,productResponse.getTotalBalanceValue(),100.000);
    }
}
