/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.UserDAO;
import domain.Grupa;
import domain.Range;
import domain.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class UserController extends SimpleFormController {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    protected Object formBackingObject (HttpServletRequest request) throws Exception {
        User user = new User();
        user.setCreated(new java.util.Date());
        user.setModified(new java.util.Date());
//                    try{
//                System.err.print(request.getUserPrincipal().getName());
//                user = userDAO.getUserByName(request.getUserPrincipal().getName());
//        } catch(Exception e) {}
        if(request.getParameter("id") != null) {
            user = userDAO.getUserById(Integer.parseInt(request.getParameter("id")));
        }
        return user;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
//                    try {
//                User user = userDAO.getUserByName(request.getUserPrincipal().getName());
//                dataMap.put("groupid", user.getGroup().getId());
//                dataMap.put("ranges", userDAO.getUserRanges(user.getId()));
//            } catch(Exception e) {}
        if(request.getParameter("id") != null) {
            dataMap.put("user", userDAO.getUserById(Integer.parseInt(request.getParameter("id"))));
            dataMap.put("ranges", userDAO.getUserRanges(Integer.parseInt(request.getParameter("id"))));
            if(userDAO.getUserById(Integer.parseInt(request.getParameter("id"))).getGroups().getAuthoritieses().getId() == 1) {
                dataMap.put("groupList", userDAO.listGroup());
            } else {
                dataMap.put("groupList", userDAO.listGroupWithoutAdmin());
            }
        } else {
            dataMap.put("groupList", userDAO.listGroupWithoutAdmin());
        }
        dataMap.put("groups", userDAO.listGroupWithoutAdmin());
        dataMap.put("rangeList", userDAO.listRange());
        return dataMap;
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.setDisallowedFields(new String[] {"groups","rangieses"});

        User user = (User)binder.getTarget();

        Integer groupId = null;
        Set<Range> range = new HashSet<Range>(0);
        Integer counter;
        System.err.println(user.getId());
        String [] str = request.getParameterValues("rangieses");
        if(str != null) {
            for(counter = 0; counter < str.length; counter++) {
                range.add(userDAO.getRangeById(Integer.parseInt(str[counter])));
            }
            user.setRangieses(range);
        }
        try {
            groupId = Integer.parseInt(request.getParameter("groups"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
            
        if(groupId != null) {
            System.err.println("grupa");
            Grupa group = userDAO.getGroupById(groupId);
            user.setGroups(group);
        }

    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        userDAO.saveUser((User)command);
        String message = "Zapisano użytkownika";
        dataMap.put("message", message);
        dataMap.put("groups", userDAO.listGroupWithoutAdmin());
        return new ModelAndView("message", dataMap);
    }
}
