package controller;

import dao.UserDAO;
import model.User;
import util.Validator;
import view.Login;
import view.UserDashboard;
import javax.swing.JOptionPane;
import config.Connector;
import java.util.*;

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

    public List<User> getAllUser() {
    return userDAO.getAllUser();
}

public List<User> cariUser(String keyword) {
    List<User> semuaUser = getAllUser();
    List<User> hasilPencarian = new ArrayList<>();
    
    String lowerKeyword = keyword.toLowerCase();
    
    for (User u : semuaUser) {
        if (u.getUsername().toLowerCase().contains(lowerKeyword) ||
            u.getRole().toLowerCase().contains(lowerKeyword)) {
            hasilPencarian.add(u);
        }
    }
    
    return hasilPencarian;
}

public void updateUser(User user) {
        // Cek apakah username sudah digunakan oleh user lain
        User existingUser = userDAO.getUserByUsername(user.getUsername());
        if (existingUser != null && existingUser.getId() != user.getId()) {
            throw new IllegalArgumentException("Username sudah digunakan oleh user lain");
        }
        
        userDAO.updateUser(user);
    }

public void hapusUser(int id) {
        userDAO.HapusUser(id);
    }

}