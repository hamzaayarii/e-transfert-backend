package com.example.authservice.services;

import com.example.authservice.dto.AuthResponse;
import com.example.authservice.dto.LoginRequest;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.entities.Utilisateur;
import com.example.authservice.repository.UtilisateurRepository;
import com.example.authservice.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UtilisateurRepository repo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UtilisateurRepository repo, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {
        if (repo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        Utilisateur user = new Utilisateur();
        user.setPrenom(request.getPrenom());
        user.setNom(request.getNom());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encode password

        // Set default role if not provided
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        } else {
            user.setRole(com.example.authservice.enums.Role.CLIENT); // Default role
        }

        repo.save(user);

        String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

        // Create user DTO for response
        AuthResponse.UserDTO userDTO = new AuthResponse.UserDTO(
                user.getId(),
                user.getEmail(),
                user.getPrenom(),
                user.getNom(),
                null, // phone is not stored in entity
                user.getRole().name());

        return new AuthResponse(token, userDTO);
    }

    public AuthResponse login(LoginRequest request) {
        Utilisateur user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) { // Use encoder
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

        // Create user DTO for response
        AuthResponse.UserDTO userDTO = new AuthResponse.UserDTO(
                user.getId(),
                user.getEmail(),
                user.getPrenom(),
                user.getNom(),
                null, // phone is not stored in entity
                user.getRole().name());

        return new AuthResponse(token, userDTO);
    }
}