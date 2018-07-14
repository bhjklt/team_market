package team.market.administrator;

import org.junit.Assert;
import org.junit.Test;
import team.market.administrator.util.DBUtil;

import java.sql.SQLException;

public class testUtil {

    @Test
    public void testConnection() throws SQLException {
        Assert.assertTrue(DBUtil.getConnection().getAutoCommit());
    }

}
