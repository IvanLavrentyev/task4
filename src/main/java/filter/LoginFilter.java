package filter;

import com.sun.deploy.net.HttpRequest;
import dao.UserDao;
import dao.UserDaoImpl;
import model.User;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private final UserDao userService = new UserDaoImpl();



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        boolean requestForLogin = (request.getContextPath() + "/login").equalsIgnoreCase(request.getRequestURI());
        boolean requestForUserPage = (request.getRequestURI()).contains(request.getContextPath() + "/user");
        boolean requestForAdminPage = (request.getRequestURI()).contains(request.getContextPath() + "/allUsers");

        if (requestForLogin || requestForUserPage) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if (user != null){
                String userRole = user.getRole();
                if (userRole.equalsIgnoreCase("admin")) filterChain.doFilter(servletRequest, servletResponse);
                else if (userRole.equalsIgnoreCase("user") && requestForAdminPage) {
                    request.getRequestDispatcher("accessDenied.jsp").forward(servletRequest,servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }



}
