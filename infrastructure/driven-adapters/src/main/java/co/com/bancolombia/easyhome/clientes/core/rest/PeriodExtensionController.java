package co.com.bancolombia.easyhome.clientes.core.rest;

import co.com.bancolombia.easyhome.clientes.core.domain.ProductResponse;
import co.com.bancolombia.easyhome.clientes.core.domain.SignatureResponse;
import co.com.bancolombia.easyhome.clientes.core.json.PeriodExtension;
import co.com.bancolombia.easyhome.clientes.core.json.PeriodExtensionRequest;
import co.com.bancolombia.easyhome.clientes.core.json.ProductRequest;
import co.com.bancolombia.easyhome.clientes.core.services.PdfService;
import co.com.bancolombia.easyhome.clientes.core.services.PeriodExtensionService;
import co.com.bancolombia.easyhome.clientes.core.services.ProductService;
import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/core/customer_information", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PeriodExtensionController {

    private final PeriodExtensionService service;
    private final ProductService productService;
    @Autowired
    private PdfService pdfService;
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> save(@Valid HttpServletRequest request,
                                     @RequestBody PeriodExtension requestBody) {
        Cookie[] cookies = request.getCookies();
        Cookie token = Arrays.asList(cookies).stream().filter(t -> t.getName().equals("token")).findAny().
                orElse(null);
        Cookie documentType =
                Arrays.asList(cookies).stream().filter(t -> t.getName().equals("documentType")).findFirst().
                        orElse(null);
        Cookie documentNumber =
                Arrays.asList(cookies).stream().filter(t -> t.getName().equals("documentNumber")).
                        findFirst().orElse(null);
        PeriodExtensionRequest periodExtensionRequest = new PeriodExtensionRequest();
        periodExtensionRequest.setDocumentNumber(documentNumber.getValue());
        periodExtensionRequest.setDocumentType(documentType.getValue());
        periodExtensionRequest.setObligationNumber(requestBody.getObligationNumber());
        periodExtensionRequest.setRequestDate(requestBody.getRequest_Date());
        periodExtensionRequest.setNewTerms(requestBody.getNewTerms());
        periodExtensionRequest.setOldTerms(requestBody.getOldTerms());
        periodExtensionRequest.setCustomerName(requestBody.getCustomerName());
        return new ResponseEntity<>(service.save(periodExtensionRequest, token.getValue()),
                new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ProductResponse> getProducts(HttpServletRequest request) {
        Cookie token = Arrays.asList(request.getCookies()).stream().filter(t -> t.getName().equals(
                "token")).findFirst().orElse(null);
        Cookie documentType = Arrays.asList(request.getCookies()).stream().filter(t -> t.getName().equals(
                "documentType")).findFirst().orElse(null);
        Cookie documentNumber = Arrays.asList(request.getCookies()).stream().filter(t -> t.getName().equals(
                "documentNumber")).findFirst().orElse(null);
        ProductRequest productRequest = new ProductRequest(documentNumber.getValue(), documentType.getValue());
        return productService.getProducts(productRequest, token.getValue());
    }

    @PostMapping("/pdf")
    public void downloadPdf( @RequestBody List<SignatureResponse> signatureResponse) throws IOException, DocumentException {
        pdfService.returnPDF(signatureResponse);
    }

}