import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class catchNumber extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码的 两步
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String num1 = req.getParameter("num1");
        int num = Integer.parseInt(num1);
        resp.getWriter().write(String.format("<h1>获得的数字是:%d</h1>",num));
    }
}
