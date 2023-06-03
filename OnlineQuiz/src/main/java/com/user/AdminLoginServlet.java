package com.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.validateAdmin(email, password);

        if (admin != null) {
            request.getSession().setAttribute("adminAuthenticated", true);
            response.sendRedirect("Admindashboardpage.jsp");
        } else {
            // Invalid admin credentials, display an error message or redirect to login page
            response.sendRedirect("Adminlogin.jsp?error=invalidAdminCredentials");
        }
    }
}