package com.senac.avadminconfig.model.DAO;

import com.senac.avadminconfig.model.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Usuario usuario) {
        this.em.getTransaction().begin();
        this.em.persist(usuario);
        this.em.getTransaction().commit();
    }

    // No futuro, você pode adicionar outros métodos aqui, como:
    // public Usuario buscarPorId(Long id) { ... }
    // public void deletar(Usuario usuario) { ... }
}