// package com.GerenciadoEstoque.DB;

// import java.io.FileInputStream;
// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.util.Properties;

// public class DbConnection {
//     private static Connection connection = null;

//     public static Connection getConnection() {

//         if (connection != null) {
//             try {
//                 Properties props = loadProperties();
//                 String url = props.getProperty("spring.datasource.url");
//                 connection = DriverManager.getConnection(url, props);

//             } catch (SQLException Erro) {
//                 throw new DbException(Erro.getMessage());
//             }
//         }
//         return connection;
//     }

//     private static Properties loadProperties() {
//         try (FileInputStream fs = new FileInputStream("src/main/resources/application.properties")) {

//             Properties props = new Properties();
//             props.load(fs);
//             return props;
//         } catch (IOException Erro) {
//             throw new DbException(Erro.getMessage());
//         }
//     }

//     public static void closeConnection() {
//         if (connection != null) {
//             try {
//                 connection.close();
//             } catch (SQLException Erro) {
//                 throw new DbException(Erro.getMessage());
//             }

//         }

//     }
// }
