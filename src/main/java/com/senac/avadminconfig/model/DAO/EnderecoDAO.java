package com.senac.avadminconfig.model.DAO;

import com.senac.avadminconfig.model.Endereco;
import jakarta.persistence.EntityManager;

public class EnderecoDAO {

    private EntityManager entityManager;

    public EnderecoDAO(EntityManager entityManager){

        this.entityManager = entityManager;
    }

    public void salvar(Endereco e) {
        entityManager.getTransaction().begin(); // vai startar utils e persistence e startar a transaçao e conecta com o banco

        entityManager.persist(e);

        entityManager.getTransaction().commit();
    }
}
