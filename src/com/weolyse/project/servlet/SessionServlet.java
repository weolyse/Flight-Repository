package com.weolyse.project.servlet;

import com.weolyse.project.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    private static final String USER = "weolyse";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // default true - create new session if none
        UserDto userDto = (UserDto) session.getAttribute(USER);
        if (userDto == null) {
            userDto = UserDto.builder()
                    .id(12L)
                    .name("Abdunur")
                    .build();
            session.setAttribute(USER, userDto);
        }
    }
}
