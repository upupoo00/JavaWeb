import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyRequestServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        //获取请求方法名
        String method = req.getMethod();
        String uri = req.getRequestURI();
        String contentType = req.getContentType();
        //输出获取的参数信息
        resp.getWriter().write(String.format("<h1>method:%s</h1>",method));
        resp.getWriter().write(String.format("<h1>uri:%s</h1>",uri));
        resp.getWriter().write(String.format("<h1>contenType:%s</h1>",contentType));
    }
}
