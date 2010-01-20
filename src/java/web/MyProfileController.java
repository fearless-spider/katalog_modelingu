/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.UserDAO;
import domain.Range;
import domain.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author uniqueblackrose
 */
public class MyProfileController extends MultiActionController {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ModelAndView show(HttpServletRequest request,HttpServletResponse response) {
        User user = userDAO.getUserByName(request.getUserPrincipal().getName());
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        dataMap.put("user", user);
        List<Range> ranges = userDAO.getUserRanges(user.getId());
        dataMap.put("ranges", ranges);
        dataMap.put("group", user.getGroups());
        dataMap.put("groups", userDAO.listGroupWithoutAdmin());
        return new ModelAndView("myProfile", dataMap);
    }

    public ModelAndView edit(HttpServletRequest request,HttpServletResponse response) {
        System.err.println(userDAO.getUserByName(request.getUserPrincipal().getName()).getId());
        return new ModelAndView(new RedirectView("/catalog/register.htm?id=" + userDAO.getUserByName(request.getUserPrincipal().getName()).getId()));
    }

}
