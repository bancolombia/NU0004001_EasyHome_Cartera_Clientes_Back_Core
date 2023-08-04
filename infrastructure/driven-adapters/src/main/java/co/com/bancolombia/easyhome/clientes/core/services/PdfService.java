package co.com.bancolombia.easyhome.clientes.core.services;

import co.com.bancolombia.easyhome.clientes.core.domain.SignatureResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import lombok.RequiredArgsConstructor;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.print.PrintTranscoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfService {

    @Value("${paragraph0}")
    private String paragraphString0;
    @Value("${paragraph1}")
    private String paragraphString1;
    @Value("${paragraph2}")
    private String paragraphString2;
    @Value("${paragraph3}")
    private String paragraphString3;

    public void returnPDF(List<SignatureResponse> signatureResponse) throws IOException, DocumentException {
        Document documento = new Document();
        FileOutputStream ficheroPdf = new FileOutputStream("fileName.pdf");
        PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);
        writer.setInitialLeading(10);

        Paragraph paragraph0 = new Paragraph(paragraphString0);
        Paragraph paragraph1 = new Paragraph(paragraphString1);
        Paragraph paragraph2 = new Paragraph(paragraphString2);
        Paragraph paragraph3 = new Paragraph(paragraphString3);

        
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        paragraph3.setAlignment(Element.ALIGN_JUSTIFIED);

        paragraph1.setSpacingBefore(-30);
        paragraph2.setSpacingBefore(25);
        paragraph3.setSpacingBefore(25);

        documento.open();

        int width = 80;
        int height = 80;
        PdfContentByte cb = writer.getDirectContentUnder();
        PdfTemplate template = cb.createTemplate(width,height);
        Graphics2D g2 = template.createGraphics(width,height);

        PrintTranscoder prm = new PrintTranscoder();
        TranscoderInput ti = new TranscoderInput("logo-bancolombia-otrosi.svg");
        prm.transcode(ti, null);
        PageFormat pg = new PageFormat();
        Paper pp= new Paper();
        pp.setSize(width, height);
        pp.setImageableArea(0, 0,width,height);
        pg.setPaper(pp);
        prm.print(g2, pg, 0);
        g2.dispose();

        ImgTemplate img = new ImgTemplate(template);
        img.setAlignment(Element.ALIGN_RIGHT);
        documento.add(img);
        documento.add(paragraph1);
        documento.add(paragraph2);
        documento.add(paragraph3);

        documento.close();
    }
}
