package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Jogo;

public class JogoDaoJpa implements InterfaceDao<Jogo> {

    @Override
    public void incluir(Jogo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Jogo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Jogo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(Jogo.class, entidade.getId()));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Jogo pesquisarPorId(int id) throws Exception {
        Jogo j = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            j = em.find(Jogo.class, id);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return j;
    }

    @Override
    public List<Jogo> listar() throws Exception {
        List<Jogo> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Jogo j").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return lista;
    }

}
