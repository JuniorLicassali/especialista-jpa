package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class FuncoesTest extends EntityManagerTest {

    @Test
    public void aplicarFuncaoAgregacao() {
//        avg, count, min, max, sum

        String jpql = "select avg(p.total) from Pedido p";

        TypedQuery<Number> typedQuery = entityManager.createQuery(jpql, Number.class);

        List<Number> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));

    }

    @Test
    public void aplicarFuncaoNativa() {

        String jpql = "select function('dayname', p.dataCriacao) from Pedido p where function('acima_media_faturamento', p.total) = 1 ";

        TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);

        List<String> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(obj -> System.out.println(obj));

    }

    @Test
    public void aplicarFuncaoColecao() {

        String jpql = "select size(p.itens) from Pedido p where size(p.itens) > 1 ";

        TypedQuery<Integer> typedQuery = entityManager.createQuery(jpql, Integer.class);

        List<Integer> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(size -> System.out.println(size));

    }

    @Test
    public void aplicarFuncaoNumero() {

        String jpql = "select abs(p.total), mod(p.id, 2), sqrt(p.total) from Pedido p";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " - " + arr[1]));

    }

    @Test
    public void aplicarFuncaoData() {
//        current_date, current_time, current_timestamp
//        year(p.dataCriacao ), month(p.dataCriacao), day(p.dataCriacao)

        String jpql = "select hour(p.dataCriacao ), minute(p.dataCriacao), second(p.dataCriacao) from Pedido p";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " - " + arr[1]));

    }


    @Test
    public void aplicarFuncaoString() {
        String jpql = "select c.nome, concat('Categoria:', c.nome) from Categoria c";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " - " + arr[1]));

    }

}
