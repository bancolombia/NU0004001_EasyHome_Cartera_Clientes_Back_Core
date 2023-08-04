package co.com.bancolombia.easyhome.clientes.core.domain;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DocumentTypeEnumTest {

    DocumentType documentType;

    @After
    public void setUp() {
        DocumentTypeEnum documentType = null;
    }

    @Test
    public void errorER01() {
        documentType = new DocumentType(DocumentTypeEnum.CARNE_DIPLOMATICO);
        assertEquals("0", documentType.getMessage());
    }

}
