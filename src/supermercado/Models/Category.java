/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Category {
    private int Id;
    private String Description;
    private Date DateCreated, DateUdpate;

    public Category() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public Date getDateUdpate() {
        return DateUdpate;
    }

    public void setDateUdpate(Date DateUdpate) {
        this.DateUdpate = DateUdpate;
    }
 
    
     public static List<Category>  allCategory() {
        String sql = """
            SELECT
                ca.id,
                ca.description,
                ca.date_created,
                ca.date_udpate
            FROM
                category ca
            """;
        Connection conexion = Conexion.getConnection();
        List<Category> listCategory = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {                
                Category category = new Category();
                System.out.println("ID: " + resultSet.getInt("id"));
                category.setId(resultSet.getInt("id"));
                System.out.println("Descripcion : " + resultSet.getString("description"));
                category.setDescription(resultSet.getString("description"));
                System.out.println("Fecha Creacion: " + resultSet.getString("date_created"));
                category.setDateCreated(resultSet.getDate("date_created"));
                System.out.println("Fecha Actualizacion: " + resultSet.getString("date_udpate"));
                category.setDateCreated(resultSet.getDate("date_udpate"));
                System.out.println("---------------------");
                listCategory.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           Conexion.closeConnection();
        }
         return listCategory;
    }
}
