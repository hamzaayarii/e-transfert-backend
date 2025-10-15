package com.example.authservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
    private String token;
    private UserDTO user;

    public AuthResponse() {
    }

    public AuthResponse(String token, UserDTO user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    // Inner class for user data
    public static class UserDTO {
        private Long id;
        private String email;

        @JsonProperty("firstName")
        private String prenom;

        @JsonProperty("lastName")
        private String nom;

        @JsonProperty("phone")
        private String telephone;

        private String role;

        public UserDTO() {
        }

        public UserDTO(Long id, String email, String prenom, String nom, String telephone, String role) {
            this.id = id;
            this.email = email;
            this.prenom = prenom;
            this.nom = nom;
            this.telephone = telephone;
            this.role = role;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
