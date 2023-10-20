package com.gfelix.demo.domain;



public class CadastroDTO {
    private String email;
    private String password;


    CadastroDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
}
