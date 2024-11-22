/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado.Controllers;


import java.util.List;
import supermercado.Models.Category;

/**
 *
 * @author user
 */
public class CategoryController {
    
    public static List<Category> allCategory() {
        System.out.println("Controller - allCategory:");
        return Category.allCategory();
    }
}
