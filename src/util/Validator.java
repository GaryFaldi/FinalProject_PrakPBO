/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author GaryFaldi
 */
public class Validator {
    
    // Cek apakah sebuah string kosong
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    // Cek apakah string adalah angka valid (integer)
    public static boolean isNumeric(String input) {
        if (isEmpty(input)) return false;
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Cek apakah string adalah angka desimal valid
    public static boolean isDecimal(String input) {
        if (isEmpty(input)) return false;
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validasi panjang minimum
    public static boolean hasMinLength(String input, int length) {
        return input != null && input.trim().length() >= length;
    }

    // Validasi username atau nama hanya huruf
    public static boolean isAlpha(String input) {
        return input != null && input.matches("[a-zA-Z ]+");
    }

    // Validasi plat nomor (contoh: AB1234CD)
    public static boolean isValidPlatNomor(String input) {
        return input != null && input.matches("^[A-Z]{1,2}[0-9]{1,4}[A-Z]{1,3}$");
    }
}

