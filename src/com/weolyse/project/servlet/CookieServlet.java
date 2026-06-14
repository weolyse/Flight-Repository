package com.weolyse.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    private static final String USER_ID_KEY = "user_id";
    private static AtomicInteger userIdCounter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getHeader("Cookie");
        Cookie[] cookies = req.getCookies();

        if (cookies == null || Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(USER_ID_KEY))
                .findFirst()
                .isEmpty()) {
            Cookie cookie = new Cookie(USER_ID_KEY, "12345");
            cookie.setPath("/cookies");
            resp.addCookie(cookie);
            userIdCounter.incrementAndGet();
        }
    }
}
