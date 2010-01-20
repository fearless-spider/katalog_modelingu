package web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReportController extends MultiActionController {
    private Log log = LogFactory.getLog(ReportController.class);
    /**
     * Determine the view format (html, pdf, csv, xls) from the
     * extension the view will bind the datasource.
     */
    public ModelAndView viewReport(HttpServletRequest request,
                                   HttpServletResponse response)
    throws Exception {

        String uri = request.getRequestURI();
        String format = "html";
        try {
            format = uri.substring(uri.lastIndexOf(".") + 1);
        } catch (IndexOutOfBoundsException e) {
            // ignore - html format will be used
        }
        log.debug("using format: " + format);

        Map model = new HashMap();
        model.put("format", format);

        return new ModelAndView("reportView", model);
    }
}