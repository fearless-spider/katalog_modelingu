/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.tag;

import domain.Range;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.List;
/**
 *
 * @author uniqueblackrose
 */
public class RangesTag extends TagSupport {
    private List<Range> ranges;
    private List<Range> userRanges;
    private String nameTag;

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }

    public void setUserRanges(List<Range> ranges) {
        this.userRanges = ranges;
    }

    public void setNameTag(String name) {
        this.nameTag = name;
    }

    @Override
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            boolean status;
            if(this.ranges != null) {
                for(Range range : this.ranges) {
                    status = false;
                    if(this.userRanges != null) {
                        for(Range rang : this.userRanges) {
                            if(range.getId() == rang.getId()) {
                                status = true;
                            }
                        }
                    }
                    out.print("<input id=\""+ this.nameTag + String.valueOf(range.getId()) +"\" name=\""+ this.nameTag + "\" type=\"checkbox\" value=\""+String.valueOf(range.getId())+"\" ");
                    if(status) {
                        out.print(" checked=\"checked\" ");
                    }
                    out.print("/>" + range.getName() + "<br />");
                }
            }
        } catch (IOException e) {}

        return(SKIP_BODY);
    }
}
