package controller;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (urlPatterns = "/user")
public class UserPageServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

        if (req.getQueryString() != null && req.getQueryString().contains("id")){
            long id = Long.parseLong(req.getParameter("id"));

            if (userService.getRoleById(id).equalsIgnoreCase("admin")){
                req.getRequestDispatcher("/accessDenied.jsp").forward(req,resp);
            }

            if (user.getRole().equalsIgnoreCase("admin") || user.getId() == id){
                User userU = userService.getUserById(id);
                req.setAttribute("user", userU);
                req.getRequestDispatcher("/userPage.jsp").forward(req,resp);
            }else
                req.getRequestDispatcher("/accessDenied.jsp").forward(req,resp);
        }else {
            req.setAttribute("user",user);
            req.getRequestDispatcher("/userPage.jsp").forward(req,resp);
        }
    }
}
