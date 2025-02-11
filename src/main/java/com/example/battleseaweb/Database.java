package com.example.battleseaweb;

import java.sql.*;

public class Database {
    private void loadDataFromDatabase() {
       

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM battlesea";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                // Очищаем таблицу перед загрузкой новых данных
               // tableModel.setRowCount(0);

                // Заполняем таблицу данными из базы данных
                while (resultSet.next()) {
                    Object[] rowData = {
                            resultSet.getInt("id"),
                            resultSet.getString("winner"),
                            resultSet.getString("loser"),
                            resultSet.getTimestamp("gamedate")
                    };
                    //tableModel.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
