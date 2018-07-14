package team.market.administrator;

import org.junit.Assert;
import org.junit.Test;
import team.market.administrator.util.DBUtil;

import java.sql.SQLException;


/**
 * @author thomas
 */
public class testUtil {

    @Test
    public void testConnection() throws SQLException {
        Assert.assertTrue(DBUtil.getConnection().getAutoCommit());
    }

}
