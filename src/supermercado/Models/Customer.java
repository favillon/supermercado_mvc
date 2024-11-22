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
import java.util.List;


/**
 *
 * @author user
 */
public class Customer {
    private int Id, Identification, IdCategory;
    private String Name, LastName, CategoryDescription;

    public Customer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdentification() {
        return Identification;
    }

    public void setIdentification(int Identification) {
        this.Identification = Identification;
    }

    public int getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(int IdCategory) {
        this.IdCategory = IdCategory;
    }
    
    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    // Método para listar usuarios desde la base de datos
    public static List<Customer> allCustomer() {
        String sql = """
            SELECT
                c.id,
                c.name,
                c.last_name,
                c.identification,
                c.id_category,
                ca.description as category_description
            FROM
                customer c
            INNER JOIN category ca ON c.id_category = ca.id
            """;
        List<Customer> listCustomer = new ArrayList<>();
        Connection conexion = Conexion.getConnection();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Customer customer = new Customer();
                System.out.println("ID: " + resultSet.getInt("id"));
                customer.setId(resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("name"));
                customer.setName(resultSet.getString("name"));
                System.out.println("Apellido: " + resultSet.getString("last_name"));
                customer.setLastName(resultSet.getString("last_name"));
                System.out.println("CC: " + resultSet.getString("identification"));
                customer.setIdentification(resultSet.getInt("identification"));
                System.out.println("Id Categoria: " + resultSet.getInt("id_category"));
                customer.setIdCategory(resultSet.getInt("id_category"));
                System.out.println("Categoria Descripcion: " + resultSet.getString("category_description"));
                customer.setCategoryDescription(resultSet.getString("category_description"));
                System.out.println("---------------------");
                listCustomer.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           Conexion.closeConnection();
        }
        return listCustomer;
    }
    
     public static List<Customer> filterByCategory(int idCategory) {
         String sql = """
            SELECT
                c.id,
                c.name,
                c.last_name,
                c.identification,
                c.id_category,
                ca.description as category_description
            FROM
                customer c            
            INNER JOIN category ca ON c.id_category = ca.id
            WHERE
                ca.id = '%s'
            """.formatted(idCategory);
        Connection conexion = Conexion.getConnection();
        List<Customer> listCustomer = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                System.out.println("ID: " + resultSet.getInt("id"));
                customer.setId(resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("name"));
                customer.setName(resultSet.getString("name"));
                System.out.println("Apellido: " + resultSet.getString("last_name"));
                customer.setLastName(resultSet.getString("last_name"));
                System.out.println("CC: " + resultSet.getString("identification"));
                customer.setIdentification(resultSet.getInt("identification"));
                System.out.println("Id Categoria: " + resultSet.getInt("id_category"));
                customer.setIdCategory(resultSet.getInt("id_category"));
                System.out.println("Categoria Descripcion: " + resultSet.getString("category_description"));
                customer.setCategoryDescription(resultSet.getString("category_description"));
                System.out.println("---------------------");
                listCustomer.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           Conexion.closeConnection();
        }
        return listCustomer;
     }
    
}
