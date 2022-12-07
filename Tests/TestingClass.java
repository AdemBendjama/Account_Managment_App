package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import Controller.AppController;
import Model.AdminManager;
import Model.User;
import Model.UserManager;

public class TestingClass {
    //
    private static UserManager userManager = new UserManager();
    private static AdminManager adminManager = new AdminManager();
    private static AppController appController = new AppController();

    @Nested
    @DisplayName("TESTS")
    class Tests {

        // Add Multiple Accounts before the tests
        @BeforeAll
        static void addTestUsers() {
            //
            Assert.assertTrue(
                    userManager
                            .addUser(new User("adambendjamaa2013@gmail.com", "adamo", "Adamo Bendjamaa", "student")));
            Assert.assertTrue(userManager.addUser(new User("bbbbbb", "bbbbbbb", "bbbbbbb", "student")));
            Assert.assertTrue(userManager.addUser(new User("dawnson@gmail.com", "dawnson", "dawnson", "student")));
        }

        // Remove the Added Accounts before the tests
        @AfterAll
        static void removeTestUsers() {
            //
            Assert.assertTrue(userManager.deleteUser("adambendjamaa2013@gmail.com"));
            Assert.assertTrue(userManager.deleteUser("bbbbbb"));
            Assert.assertTrue(userManager.deleteUser("dawnson@gmail.com"));
            Assert.assertTrue(userManager.deleteUser("tracymcgrady@gmail.com"));
        }

        @Nested
        @DisplayName("UserManager Class")
        class UserManager {

            @Nested
            @DisplayName("testConnection() Method")
            class testConnection {
                //
                @Tag("connection")
                @Test
                void connection() {
                    //
                    Assert.assertTrue(userManager.testConnection());
                }
            }

            @Nested
            @DisplayName("checkUser() Method")
            class checkUser {

                @Tag("DataBase")
                @Test
                void checkUserWithValidEmail() {
                    //
                    boolean result = userManager.checkUser("adambendjamaa2013@gmail.com");
                    Assert.assertTrue(result);
                }

                @Tag("DataBase")
                @Test
                void checkUserWithUnvalidEmail() {
                    // "bbbbbb" is an unvalid email so the test fails
                    boolean result = userManager.checkUser("bbbbbb");
                    Assert.assertFalse(result);
                }
            }

            @Nested
            @DisplayName("getUser() Method")
            class getUser {

                @Tag("DataBase")
                @Test
                void getTestUserPassword() {
                    // The Test Fails Because the Information Fetched From the Databased Is Saved
                    // Incorrectly in the getUser Class
                    User user = userManager.getUser("adambendjamaa2013@gmail.com");
                    String originalPassword = user.getPassword();
                    Assert.assertEquals("adamo", originalPassword);
                }

            }

            @Nested
            @DisplayName("addUser() Method")
            class addUser {

                @Tag("DataBase")
                @Test
                void compareAddedUser() {
                    // The Error Here Is Also Related to The GetUser() method
                    User user = new User("tracymcgrady@gmail.com", "tmac404", "T-Mac", "student");
                    boolean resultOfAddition = userManager.addUser(user);
                    Assert.assertTrue(resultOfAddition);
                    //
                    User userFromDatabase = userManager.getUser("tracymcgrady@gmail.com");
                    Assert.assertEquals(user, userFromDatabase);
                }

                @Tag("DataBase")
                @Test
                void addExistantUser() {
                    User user = new User("adambendjamaa2013@gmail.com", "adamo", "Adamo Bendjamaa", "student");
                    Assert.assertFalse(userManager.addUser(user));
                }

            }

            @Nested
            @DisplayName("updateUser() Method")
            class updateUser {

                @Tag("DataBase")
                @Test
                void updateRankToTeacher() {
                    //
                    User user = new User("dawnson@gmail.com", "dawnson", "dawnson", "student");
                    user.setRank("teacher");
                    Assert.assertTrue(userManager.updateUser("dawnson@gmail.com", user));
                }

                @Tag("DataBase")
                @Test
                void updateRankToUnvalidValue() {
                    // Test Fails Because You Should not be Able to Enter an unvalid Rank
                    // Rank Should be "student" or "teacher"
                    User user = new User("dawnson@gmail.com", "dawnson", "dawnson", "student");
                    user.setRank("afegsdgresgdwfgsfd");
                    Assert.assertFalse(userManager.updateUser("dawnson@gmail.com", user));
                }

                @Tag("DataBase")
                @Test
                void updateNonExistantUser() {
                    User user = new User("65sb4h6d5m", "dahkghwnson", "dagkgjhgkwnson", "kjfhkjh");
                    Assert.assertFalse(userManager.updateUser("hdfdguyutrdhd", user));

                }

            }

            @Nested
            @DisplayName("deleteUser() Method")
            class deleteUser {
                //
                @Tag("DataBase")
                @Test
                void deleteExistantUser() {
                    //
                    Assert.assertTrue(userManager.addUser(new User("david@gmail.com", "david", "david", "student")));
                    Assert.assertTrue(userManager.deleteUser("david@gmail.com"));

                }

                //
                @Tag("DataBase")
                @Test
                void deleteNonExistantUser() {
                    //
                    Assert.assertFalse(userManager.deleteUser("hdfdgtrsghfhdgfdhd"));

                }

            }

        }

        @Nested
        @DisplayName("AdminManager Class")
        class AdminManager {

            @Nested
            @DisplayName("testConnection() Method")
            class testConnection {
                //
                @Tag("connection")
                @Test
                void connection() {
                    //
                    Assert.assertTrue(adminManager.testConnection());
                }
            }

            @Nested
            @DisplayName("checkCredentials() Method")
            class checkCredentials {
                //
                @Tag("DataBase")
                @Test
                void enterCorrectAdminEmailPassword() {
                    //
                    Assert.assertTrue(adminManager.checkCredentials("stevenking@gmail.com", "stevio800"));
                }

                //
                @Tag("DataBase")
                @Test
                void enterUncorrectAdminEmailPassword() {
                    //
                    Assert.assertFalse(adminManager.checkCredentials("qsdqsdqsd@gmail.com", "stevisdgqgo800"));
                }
            }

        }

        @Nested
        @DisplayName("AppController Class")
        class AppController {

            @Nested
            @DisplayName("formatDouble() Method")
            class formatDouble {

                @Tag("App_Logic")
                @Test
                void testFormatDouble(){
                    //
                    double originalNumber   = 1.959561959;
                    double expectedNumber   = 1.959561;
                    double formattedNumber  = Double.parseDouble(appController.formatDouble(originalNumber));

                    //
                    Assert.assertEquals(expectedNumber, formattedNumber,0);
                }
            }

            @Nested
            @DisplayName("getVariance() Method")
            class getVariance {

                @Tag("App_Logic")
                @Test
                void testFormatDouble(){
                    //
                    double avg = 5.0;
                    double count = 9.0 ; 
                    double variance = appController.getVariance(avg, count);
                    double expectedVariance = 6.666666666666667;

                    //
                    Assert.assertEquals(expectedVariance, variance,0);
                }
            }

            @Nested
            @DisplayName("getStandardDeviation() Method")
            class getStandardDeviation {

                @Tag("App_Logic")
                @Test
                void testFormatDouble(){
                    //
                    double avg = 5.0;
                    double count = 9.0 ; 
                    double variance = appController.getStandardDeviation(avg, count);
                    double expectedVariance = 2.581988897471611;

                    //
                    Assert.assertEquals(expectedVariance, variance,0);
                }
            }

        }

    }

}
