/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercado;


import supermercado.Controllers.CustomerController;
import supermercado.Controllers.CategoryController;

import supermercado.Views.CustomerListView;
/**
 *
 * @author user
 */
public class Supermercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        System.out.println("Aplicacion Supermercado");        
                
        CustomerListView ventana = new CustomerListView();
        System.out.println("Mostrar Ventana");        
        ventana.show();
    }
    
}
