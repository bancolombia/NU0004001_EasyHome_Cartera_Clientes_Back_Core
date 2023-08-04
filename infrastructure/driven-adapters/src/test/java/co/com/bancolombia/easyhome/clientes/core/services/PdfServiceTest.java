package co.com.bancolombia.easyhome.clientes.core.services;

import co.com.bancolombia.easyhome.clientes.core.domain.SignatureResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
public class PdfServiceTest extends TestCase {

    private Document documento;
    private PdfService pdfService;

    @Before
    public void setUp() throws Exception {
        documento = Mockito.mock(Document.class);
        pdfService = new PdfService();
        super.setUp();
    }

    @Test
    public void testReturnPDF() throws IOException, DocumentException {
        pdfService = new PdfService();
        ArrayList<SignatureResponse> list = new ArrayList();
        SignatureResponse signatureResponse = new SignatureResponse();
        list.add(signatureResponse);
        pdfService.returnPDF(list);
        Mockito.verify(documento,Mockito.times(1));
    }
}