/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ludia
 */
public class Model implements Serializable {
    
    dbBean db = new dbBean();
    
    public void setupDatabase() {
        db.createRecipeTable();
        db.createIngredientTable();
        db.createNutritionTable();
    }
    
    public void addIngredient(String name, String type, String description) throws ClassNotFoundException {
        db.addIngredient(name, type, description);
    }
    
    public void addRecipe(String ID, String Description, String Type, String Time) throws ClassNotFoundException {
        db.addRecipe(ID, Description, Type, Time);
    }
    
    public void addNutrition(String ID, String calories, String caloriesFat, String totalFat, String cholesterol, String sodium, String totalCarbohydrate, String protein) throws ClassNotFoundException {
        db.addNutrition(ID, calories, caloriesFat, totalFat, cholesterol, sodium, totalCarbohydrate, protein);
    }
    
    
    
}
