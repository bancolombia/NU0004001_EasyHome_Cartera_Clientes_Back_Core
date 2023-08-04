package co.com.bancolombia.easyhome.clientes.core.services.util;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProductResponseBuilder {

    private List list = new ArrayList<ProductResponse>();

    public List<ProductResponse> getData() {
        ProductResponse response = new ProductResponse();
        response.setInterestRate(Math.floor(Math.random()*10*100)/100);
        response.setBalance(Math.floor(Math.random()*10000000*1000)/1000);
        response.setTerms(1 + (new Random().nextInt(240)));
        response.setDueDate(LocalDate.now().plusMonths(48L).toString());
        response.setFee(Math.floor(Math.pow(Math.random()*10000.0,2)*100)/100);
        response.setNextPaymentDate(LocalDate.now().plusMonths(1L).toString());
        response.setPaymentNumber("21");
        response.setAmortizationPayments("Leasing cuota fija peso");
        response.setStatus(false);
        response.setAccountNumber(ThreadLocalRandom.current().nextLong(999999999));
        response.setProductType("Leasing Habitacional");
        list.add(response);
        return list;
    }
}
