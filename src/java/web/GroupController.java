/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.AuthorityDAO;
import dao.GroupDAO;
import domain.Grupa;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class GroupController extends SimpleFormController {

    private GroupDAO groupDAO;
    private AuthorityDAO authorityDAO;
    
    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public void setAuthorityDAO(AuthorityDAO authorityDAO) {
        this.authorityDAO = authorityDAO;
    }

    @Override
    protected Object formBackingObject (HttpServletRequest request) throws Exception {
        Grupa group = new Grupa();
        group.setCreated(new java.util.Date());
        group.setModified(new java.util.Date());
        if(request.getParameter("id") != null) {
            group = groupDAO.getGroupById(Integer.parseInt(request.getParameter("id")));
        }
        return group;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        if(request.getParameter("id") != null) {
            dataMap.put("authId", groupDAO.getGroupById(Integer.parseInt(request.getParameter("id"))).getId());
        }
        dataMap.put("authoritieses", authorityDAO.listAuthority());
        return dataMap;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.setDisallowedFields(new String[] {"authoritieses"});
        Grupa group = (Grupa)binder.getTarget();

        try {
            group.setAuthoritieses(authorityDAO.getAuthorityById(Integer.parseInt(request.getParameter("authoritieses"))));
        } catch (Exception e) {}
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
        groupDAO.saveGroup((Grupa)command);
        String message = "Zapisano grupe";
        return new ModelAndView("message", "message", message);
    }

}