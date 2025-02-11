package com.example.battleseaweb;


import com.example.battleseaweb.Game.Coordinate;
import com.example.battleseaweb.Game.Ship;
import com.example.battleseaweb.Server.GameMessage;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Player extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println(name);
        out.println(password);

        try {
            // Подключение к игровому серверу
            Socket socket = new Socket("localhost", 5555);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Отправка сообщения о подключении
            output.writeObject(new GameMessage(GameMessage.MessageType.CONNECTED, name));







        } catch (Exception e) {
            throw new ServletException("Error connecting to game server", e);
        }

        // Перенаправление на страницу ожидания
        response.sendRedirect("game.html");
    }



}