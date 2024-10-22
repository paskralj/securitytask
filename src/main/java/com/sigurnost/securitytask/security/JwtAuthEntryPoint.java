package com.sigurnost.securitytask.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * JwtAuthEntryPoint je klasa koja implementira {@link AuthenticationEntryPoint}.
 * Ova klasa služi kao točka ulaza za neautenticirane korisnike prilikom pokušaja pristupa
 * zaštićenim resursima aplikacije.
 *
 * Kada korisnik pokuša pristupiti resursima koji zahtijevaju autentifikaciju,
 * a nije autentificiran, metoda {@link #commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
 * će se pozvati.
 *
 * Ova metoda šalje HTTP odgovor s statusom 401 (Unauthorized) i uključuje
 * poruku o iznimci koja objašnjava razlog neuspjele autentifikacije.
 */
@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
