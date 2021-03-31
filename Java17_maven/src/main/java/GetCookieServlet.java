import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //cookie的读取
        Cookie[] cookies = request.getCookies();
//        PrintWriter writer = response.getWriter();
        for (Cookie cookie:cookies) {
            response.getWriter().write(String.format("<h1>Cookie name:%s -> Cookie value:%s</h1>",
                    cookie.getName(),cookie.getValue()));
        }
    }
}

/**
 * cookie 的缺点
 * 因为cookie 是存储在客户端中的，有被篡改的风险
 * 因此，出现了session（会话）
 * session 是存储在服务器端的
 */
