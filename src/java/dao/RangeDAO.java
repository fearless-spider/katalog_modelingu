/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Range;
import java.util.List;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public interface RangeDAO {

    public void saveRange(Range range);
    public void deleteRange(Range range);
    public void updateRange(Range range);
    public List<Range> listRange();
    public Range getRangeById(int rangeId);
}
