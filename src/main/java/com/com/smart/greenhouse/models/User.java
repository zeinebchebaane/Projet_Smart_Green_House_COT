package com.com.smart.greenhouse.models;

import com.com.smart.greenhouse.Util.Argon2Utility;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

;

@Entity

public class User   implements Serializable {

    @Id
    @Column("email")
    private  String email ;
    @Column( "username")
    private  String username;

    @Column("password" )
    private String password ;


    @Column("role")
    private Set<Role> roles ;
    private Set<SmartGreenHouse> houses;


    /**
     *
     * All Getters
     */

    public   String getUsername(){
        return  username ;
    }
    public   String getEmail(){
        return  email ;
    }

    public   String getPassword(){
        return password ;
    }





    public Set<Role> getRoles() {
        return roles;
    }
    public void addHouse(Set<SmartGreenHouse> houses) {
        if (this.houses == null) {
            this.houses = new HashSet<>();
        }
        this.houses.addAll(houses);
    }
    public User(String username, String email, String password, Set<Role> roles) {
        this.username = getUsername();
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     *
     * ALl Setters
     */

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUsername(String username){
        this.username=username ;
    }

    public   void setEmail(String email){
        this.email=email ;
    }
    public   void setPassword(String password){
        this.password=password ;
    }


    /**
     * All Args  constructor  and No Args  constructor
     */



    public  User(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return username.equals(user.username) && email.equals(user.email) ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username ,email );
    }

    @Override
    public String toString() {
        return "{" +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + roles +
                '}';
    }

    public void updatePassword(String password, Argon2Utility argon2Utility) {
        this.password = argon2Utility.hash(password.toCharArray());
    }




}
