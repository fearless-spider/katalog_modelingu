/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.UserDAO;
import domain.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author uniqueblackrose
 */

public class LoginController extends SimpleFormController {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        dataMap.put("groups", userDAO.listGroupWithoutAdmin());
        return dataMap;
    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
        return new ModelAndView(new RedirectView("/catalog/users/myprofile/show.htm"));
    }

}