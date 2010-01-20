/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.UserDAO;
import domain.Grupa;
import domain.User;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class IndexController extends MultiActionController {

    private UserDAO userDAO;
    private JasperReportsPdfView pdfView;
    private JasperReportsXlsView xlsView;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public void setPdfView(JasperReportsPdfView view)
    {
        this.pdfView = view;
    }

    public void setXlsView(JasperReportsXlsView view)
    {
        this.xlsView = view;
    }

    public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
        List<Grupa> groups = userDAO.listGroupWithoutAdmin();
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        dataMap.put("groups", groups);
        dataMap.put("groupcount", groups.size());
        dataMap.put("usercount", userDAO.listUsersWithoutAdmin().size());
        return new ModelAndView("index", dataMap);
    }

    public ModelAndView about(HttpServletRequest request,HttpServletResponse response) {
        List<Grupa> groups = userDAO.listGroupWithoutAdmin();
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        dataMap.put("groups", groups);
        return new ModelAndView("about", dataMap);
    }

    public ModelAndView list(HttpServletRequest request,HttpServletResponse response) {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        if(request.getParameter("id") != null) {
            if(Integer.parseInt(request.getParameter("id")) > 1) {
                List<User> users = userDAO.getUsersByGroup(userDAO.getGroupById(Integer.parseInt(request.getParameter("id"))));
                dataMap.put("users", users);
                List<Grupa> groups = userDAO.listGroupWithoutAdmin();
                dataMap.put("groups", groups);
                dataMap.put("group", userDAO.getGroupById(Integer.parseInt(request.getParameter("id"))));
            }
        } else {
            return new ModelAndView(new RedirectView("/catalog/accessdenied.htm"));
        }
        return new ModelAndView("photo", dataMap);
    }

    public ModelAndView report(HttpServletRequest request,HttpServletResponse response) {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("generatedOn", new Date());
//      model.put("dataSource", new JRBeanCollectionDataSource(list));
      return new ModelAndView(pdfView,model);
    }

    public ModelAndView reportxls(HttpServletRequest request,HttpServletResponse response) {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("generatedOn", new Date());
//      model.put("dataSource", new JRBeanCollectionDataSource(list));
      return new ModelAndView(xlsView,model);
    }

}
