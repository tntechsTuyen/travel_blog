package com.travel.server.entity;

import com.travel.server.common.utils.CryptoUtils;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", unique=true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "role")
    private String role;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    public void encryptData(User user){
        try {
            this.fullName = CryptoUtils.AES.encrypt(user.getFullName());
            this.phone = CryptoUtils.AES.encrypt(user.getPhone());
            this.email = CryptoUtils.AES.encrypt(user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decryptData(){
        try {
            this.fullName = CryptoUtils.AES.decrypt(this.fullName);
            this.phone = CryptoUtils.AES.decrypt(this.phone);
            this.email = CryptoUtils.AES.decrypt(this.email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
