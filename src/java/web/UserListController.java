/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class UserListController implements Controller {
    private static Log log = LogFactory.getLog(UserController.class);

    UserDAO userDAO;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getParameter("id") != null) {
            if(Integer.parseInt(request.getParameter("id")) > 0) {
                userDAO.deleteUser(userDAO.getUserById(Integer.parseInt(request.getParameter("id"))));
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("entering 'handleRequest' method...");
        }

        String viewName = "userList";
        if (request != null && request.getParameter("report") != null) {
            viewName += request.getParameter("report");
        }
        return new ModelAndView(viewName, "users", this.userDAO.listUser());
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
