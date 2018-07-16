package team.market.merchant.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class StaticResourceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName = req.getRequestURL().substring(req.getRequestURL().lastIndexOf("/") + 1);
        File file = new File(new File((String) this.getServletContext().getAttribute("upload")), fileName);

        InputStream is = new FileInputStream(file);
        OutputStream os = resp.getOutputStream();

        int len = -1;
        byte[] buff = new byte[1024];
        while ((len = is.read(buff)) != -1) {
            os.write(buff, 0, len);
        }

        is.close();
        os.flush();
    }


}
