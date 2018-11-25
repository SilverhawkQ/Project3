/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author Kryot
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    public void init(View v, Model m) throws SQLException {
        v.setVisible(true);

        m.getNutritionTable(v);


        v.addIngredient(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                m.addIngredient(v.getName(), v.getType(), v.getDescription());
                m.getTable(v);

            }
        });
        
        
        v.addRecipe(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              
                m.addRecipe(v.getID(), v.getDescription(), v.getType(), v.getTime);
                m.getTable(v);

            }
        });
        
        
        v.addNutrition(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                m.addNutrition(v.getID(), v.getCalorie(), v.getCalorieFat(), v.getTotalFat(), v.getCholesterol(), v.getSodium(), v.getTotalCarbohydrate(), v.getProtein());
                m.getTable(v);

            }
        });

//        v.getIngredients(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                m.getIngredients();
//                m.getTable(v);
//
//            }
//        });
//
//        v.getInstructions(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                m.getRecipe();
//                m.getTable(v);
//
//            }
//        });
//
//        v.getNutrition(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                m.getNutrition();
//                m.getTable(v);
//
//            }
//        });

//        v.removeAction(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                m.deleteGame(v.getIDAdd(), v.getNameAdd(), v.getDescriptionAdd(), v.getPriceAdd(), v.getQuantityAdd());
//                m.getTable(v);
//            }
//        });
    }

}
