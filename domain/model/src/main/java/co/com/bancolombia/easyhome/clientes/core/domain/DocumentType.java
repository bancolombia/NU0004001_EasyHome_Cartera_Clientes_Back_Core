package co.com.bancolombia.easyhome.clientes.core.domain;
public class DocumentType extends RuntimeException {
    private final DocumentTypeEnum documentTypeEnum;
    public DocumentType(DocumentTypeEnum documentTypeEnum){
        super(documentTypeEnum.getMensaje());
        this.documentTypeEnum = documentTypeEnum;
    }
}
