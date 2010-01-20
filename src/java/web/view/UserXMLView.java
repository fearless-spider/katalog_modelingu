package web.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMWriter;
import org.springframework.web.servlet.view.xslt.AbstractXsltView;

/*
 * UserXMLView - generate the xml file from sources
 */
public class UserXMLView extends AbstractXsltView {
    @Override
    protected Source createXsltSource(Map model, String rootName,
                                      HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement(rootName);
        doc.setRootElement(root);

        List users = (List) model.get("users");
        for (Iterator it = users.iterator(); it.hasNext();) {
           User user = (User) it.next();
           Element element = root.addElement("user");
           element.addElement("username").setText(user.getUsername());
           element.addElement("firstname").setText(user.getFirstname());
           element.addElement("lastname").setText(user.getLastname());
           element.addElement("email").setText(user.getEmail());
        }

        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        return new DOMSource(new DOMWriter().write(doc));
    }
}