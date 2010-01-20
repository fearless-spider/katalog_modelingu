package web.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class UserPDFView extends AbstractPdfView {
    
    protected void buildPdfDocument(Map model, Document doc, PdfWriter writer,
                                    HttpServletRequest req,
                                    HttpServletResponse resp)
    throws Exception {
        doc.addTitle("Katalog modelingu");
        List users = (List) model.get("users");
        BaseFont helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250,
        BaseFont.EMBEDDED);
        Font font = new Font(helvetica, 12, Font.NORMAL);
        Table table = new Table(3,users.size());

        Cell c1 = new Cell(new Paragraph("Użytkownik", font));
	c1.setHeader(true);
	table.addCell(c1);
	c1 = new Cell(new Paragraph("Imię", font));
	table.addCell(c1);
	c1 = new Cell(new Paragraph("e-mail", font));
	table.addCell(c1);
	table.endHeaders();

        for (int i = 0; i < users.size(); i++) {
            String username = ((User) users.get(i)).getUsername();
            String firstname = ((User) users.get(i)).getUsername();
            String lastname = ((User) users.get(i)).getUsername();
            table.addCell(new Cell(new Paragraph(username,font)), i+1,0);
            table.addCell(new Cell(new Paragraph(firstname, font)), i+1,1);
            table.addCell(new Cell(new Paragraph(lastname, font)), i+1,2);
        }

        doc.add(table);
    }
}
