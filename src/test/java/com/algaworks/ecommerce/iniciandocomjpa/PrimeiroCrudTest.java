package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro() {
        Cliente cliente = new Cliente();

        cliente.setId(3);
        cliente.setNome("Sebastião da Galera");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteInserido = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertNotNull(clienteInserido);
    }

    @Test
    public void buscarPorIdentificador() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("Fernando Medeiros", cliente.getNome());
    }

    @Test
    public void atualizarRegistro() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        cliente.setNome("Helon Musken");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteAtualizado =  entityManager.find(Cliente.class, 1);

        Assert.assertNotNull("Helon Musken", clienteAtualizado.getNome());
    }

    @Test
    public void removerRegistro() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 1);
        Assert.assertNull(clienteVerificacao);
    }

}
