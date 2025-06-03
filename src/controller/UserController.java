package controller;

import dao.UserDAO;
import model.User;
import util.Validator;
import view.Login;
import view.UserDashboard;
import javax.swing.JOptionPane;
import config.Connector;

public class UserController {
    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }
    
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
    
    public boolean registerUser(User user) {
        if (userDAO.getUserByUsername(user.getUsername()) != null) {
            return false; // username sudah ada
        }
        try {
            userDAO.tambahUser(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error saat register: " + e.getMessage());
            return false;
        }
    }



}