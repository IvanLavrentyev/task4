package controller;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserDao userService = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
//            user.setLogin("");
//            user.setPassword("");
            session.removeAttribute("user");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        User user = userService.getUserByData(userLogin, userPassword);

        if (user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",  user);

            String userRole = user.getRole();
            if (userRole.equalsIgnoreCase("admin")){
                resp.sendRedirect(req.getContextPath() + "/allUsers");
            }
            else if (userRole.equalsIgnoreCase("user")){
                resp.sendRedirect(req.getContextPath() + "/user");
            } else
                resp.sendRedirect(req.getContextPath() + "/login");
        }else resp.sendRedirect(req.getContextPath() + "/login");


    }
}
