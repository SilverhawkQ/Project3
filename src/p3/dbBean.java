/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author Ludia
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbBean {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    String jdbc_drivers = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/recipe?verifyServerCertificate=false&useSSL=true";

    //User login
    String user = "root";
    String password = "abcd";

    int out = 0;

    public void createIngredientTable() {
        String stm = "CREATE TABLE IF NOT EXISTS Ingredients ("
                + "ID int(11) NOT NULL AUTO_INCREMENT,"
                + "Name varchar(45) NOT NULL,"
                + "Type varchar(45) NOT NULL,"
                + "Description varchar(45) NOT NULL,"
                + "PRIMARY KEY (ID))";

        try {
            System.setProperty("jdbcDriver", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(stm);

        } catch (SQLException e) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createNutritionTable() {
        String stm = "CREATE TABLE IF NOT EXISTS Nutrition ("
                + "ID int(11) NOT NULL,"
                + "Calories int(11) NOT NULL,"
                + "CaloriesFat int(11) NOT NULL,"
                + "TotalFat int(11) NOT NULL,"
                + "Cholesterol int(11) NOT NULL,"
                + "Sodium int(11) NOT NULL,"
                + "TotalCarbohydrate int(11) NOT NULL,"
                + "Protein int(11) NOT NULL,"
                + "KEY `Test_idx` (ID),"
                + "CONSTRAINT `Test` FOREIGN KEY (`ID`) REFERENCES `recipes` (`recipeid`))";
        try {
            System.setProperty("jdbcDriver", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(stm);

        } catch (SQLException e) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createRecipeTable() {
        String stm = "CREATE TABLE IF NOT EXISTS Recipes ("
                + "RecipeID int(11) NOT NULL AUTO_INCREMENT,"
                + "ID int(11) NOT NULL,"
                + "Description varchar(45) NOT NULL,"
                + "Type varchar(45) NOT NULL,"
                + "Time int(11) NOT NULL,"
                + "PRIMARY KEY (`RecipeID`),"
                + "KEY `ID_idx` (`ID`),"
                + "CONSTRAINT `ID` FOREIGN KEY (`ID`) REFERENCES `ingredients` (`id`))";

        try {
            System.setProperty("jdbcDriver", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(stm);

        } catch (SQLException e) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int addIngredient(String name, String type, String description) throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            String sql = "INSERT INTO Ingredients(Name, Type, Description) VALUES (?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, type);
            pst.setString(3, description);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return out;
    }

    public int addNutrition(String ID, String calories, String caloriesFat, String totalFat, String cholesterol, String sodium, String totalCarbohydrate, String protein) throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();


            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
            String sql = "INSERT INTO Nutrition(ID, Calories, CaloriesFat, TotalFat, Cholesterol, Sodium, TotalCarbohydrate, Protein) VALUES (?,?,?,?,?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, calories);
            pst.setString(3, caloriesFat);
            pst.setString(4, totalFat);
            pst.setString(5, cholesterol);
            pst.setString(6, sodium);
            pst.setString(7, totalCarbohydrate);
            pst.setString(8, protein);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return out;
    }

    public int addRecipe(String ID, String Description, String Type, String Time) throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.setProperty("jdbc.drivers", jdbc_drivers);
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();


            /*Create table
            //example
                insertString = "INSERT into [table_name] values (.., .., ..);
             */
            String sql = "INSERT INTO Recipes (ID, Description, Type, Time) VALUES (?,?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, Description);
            pst.setString(3, Type);
            pst.setString(4, Time);
            pst.executeUpdate();

        } catch (SQLException ex) {
            // Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
            Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return out;
    }

    // couldn't get a generic delete method working, delete is based on item code
    public void deleteIngredient(String Table, String col, String name) {

        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            //Delete table
            String sql = "DELETE FROM Ingredients WHERE Name = ?";

            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            System.out.println(Table);
            System.out.println(col);
            System.out.println(name);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void DeleteDescription(String Table, String col, String data) {

        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            //Delete table
            String sql = "DELETE FROM itemdescription WHERE name = ?";

            pst = con.prepareStatement(sql);
//            pst.setString(1, Table);
//            pst.setString(2, col);
            pst.setString(1, data);
            System.out.println(Table);
            System.out.println(col);
            System.out.println(data);
            pst.executeUpdate();

//            String dropTable = "delete from " + Table + " WHERE " + colu1 + " = " + data1;
//            st.executeUpdate(dropTable);
//            System.out.println("Deleted table in database...");
        } catch (SQLException ex) {
            // Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
            Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

    public void deleteRecipe(String Table, String ID) {

        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            //Delete table
            String sql = "DELETE FROM Recipes WHERE ID = ?";

            pst = con.prepareStatement(sql);
            pst.setString(1, ID);
            System.out.println(Table);
            System.out.println(ID);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(dbBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
