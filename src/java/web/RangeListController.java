/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.RangeDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class RangeListController implements Controller {

    RangeDAO rangeDAO;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("rangeList");
        if(request.getParameter("id") != null) {
            if(Integer.parseInt(request.getParameter("id")) > 0) {
                rangeDAO.deleteRange(rangeDAO.getRangeById(Integer.parseInt(request.getParameter("id"))));
            }
        }
        modelAndView.addObject("rangeList", this.rangeDAO.listRange());

        return modelAndView;
    }

    public RangeDAO getRangeDAO() {
        return rangeDAO;
    }

    public void setRangeDAO(RangeDAO rangeDAO) {
        this.rangeDAO = rangeDAO;
    }

}
