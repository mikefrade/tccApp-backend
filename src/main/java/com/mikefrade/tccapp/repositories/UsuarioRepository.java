package com.mikefrade.tccapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikefrade.tccapp.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer > {




}
