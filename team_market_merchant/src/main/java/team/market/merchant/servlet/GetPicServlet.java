package team.market.merchant.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GetPicServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageName = request.getParameter("imageName");
        String imageType = imageName.split(".")[1];
        if(imageType.equals("png")) {
            response.setContentType("image/png");
        }else{
            response.setContentType("image/jpg");
        }
        String imagePath = this.getServletContext().getRealPath("/upload/");
        System.out.println("imagePath:"+imagePath);
        OutputStream outputStream = response.getOutputStream();
        InputStream inputStream = new FileInputStream(imagePath+imageName);
        byte[] buf = new byte[1024];
        int len = 0;
        while((len=inputStream.read(buf))!=-1){
            outputStream.write(buf,0,len);
        }
        inputStream.close();
        outputStream.close();
    }
}
