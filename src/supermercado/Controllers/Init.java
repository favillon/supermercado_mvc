/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado.Controllers;

import java.util.List;
import supermercado.Controllers.CategoryController;
import supermercado.Controllers.CustomerController;
import supermercado.Models.Category;
import supermercado.Models.Customer;

import supermercado.Views.CustomerListView;
import supermercado.Views.ErrorView;

/**
 *
 * @author user
 */
public class Init {
    public void runApp () {
        
        List<Category> categories = CategoryController.allCategory();
        List<Customer> customers  = CustomerController.allCustomer();
        
        if ( categories.size() > 0 || customers.size() > 0 ) {
            CustomerListView ventana = new CustomerListView();
            System.out.println("Mostrar Ventana Funcional"); 
            ventana.setLocationRelativeTo(null);
            ventana.setTitle("Mis Cliente");
                
            ventana.loadDataInitial(categories, customers);
            ventana.show();
            
        } else {
            ErrorView ventana = new ErrorView();
            System.out.println("Mostrar Ventana Error"); 
            ventana.setTitle("Error");
            ventana.jLabel1.setText("Sin data, Carga informacion de Clientes y Categorias");
            ventana.setLocationRelativeTo(null);
            ventana.show();
        }
    }
}
