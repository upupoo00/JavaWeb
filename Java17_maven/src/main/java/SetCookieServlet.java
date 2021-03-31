import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //给客户端写入Cookie
        Cookie namecookie = new Cookie("username","java");
        //设置cookie 的最大存活时间 60s
        namecookie.setMaxAge(60);
        //将cookie 信息写入客户端（浏览器）
        response.addCookie(namecookie);


        //多cookie存储
        Cookie pwdcookie = new Cookie("password","root");
        // -1表时cookie永不过期
        pwdcookie.setMaxAge(-1);
        response.addCookie(pwdcookie);

        response.getWriter().write("<h1>Cookie写入成功</h1>");
    }
}
