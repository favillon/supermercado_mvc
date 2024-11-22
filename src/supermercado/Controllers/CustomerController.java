/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado.Controllers;


import java.util.List;
import supermercado.Models.Customer;
/**
 *
 * @author user
 */
public class CustomerController {
    
    public static List<Customer> allCustomer() {
        System.out.println("Controller - allCustomer:");
        return Customer.allCustomer();
    }
        
    public static List<Customer> filterCustomerByCategory(int idCategory) {
        System.out.println("Controller -  filterCustomerByCategory:");
        return Customer.filterByCategory(idCategory);
    }
}
