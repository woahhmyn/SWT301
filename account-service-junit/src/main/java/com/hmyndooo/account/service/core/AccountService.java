/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.account.service.core;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author hmynd
 */
public class AccountService {

    // Kiểm tra định dạng email cơ bản
    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    
    // Kiểm tra email: không null, không rỗng và khớp với mẫu regex
    public boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && EMAIL_PATTERN.matcher(email).matches();
    }
    
    // Đăng ký tài khoản mới
    //@return true nếu username, password và email đều hợp lệ
    public boolean registerAccount(String username, String password, String email) {
        return isValidUsername(username)
                && isValidPassword(password)
                && isValidEmail(email);
    }

    // Kiểm tra username: không null và không rỗng
    private boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty();
    }

    // Kiểm tra password: không null và có độ dài > 6
    public boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }

    
}
