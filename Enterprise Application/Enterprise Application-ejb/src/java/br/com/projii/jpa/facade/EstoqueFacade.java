/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projii.jpa.facade;


import br.com.projii.jpa.Estoque;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Calebe de Paula Bianchini
 */
//public class EstoqueFacade extends AsbstractFacade<Estoque> implements EstoqueFacadeRemote {
@Stateless(mappedName = "ejb/EstoqueFacade")
public class EstoqueFacade extends AbstractFacade<Estoque> implements EstoqueFacadeRemote {

    @PersistenceContext(unitName = "Enterprise_Application-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueFacade() {
        super(Estoque.class);
    }
    
    /**
     * Método usando a API de Criteria para gerar a seguinte consulta:
     * SELECT * FROM Estoque
     * WHERE id = :id
     *
     * @param idProduto - ID da Estoque
     * @return o objeto Estoque que possui o ID informado.
     */
//    public List<Estoque> csPorId(Long idProduto,Long idFilial) {
    public List<Estoque> csPorId(Long idProduto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Estoque> c = cb.createQuery(Estoque.class);
        /**
         *   A partir da CriteriaQuery podemos informar de qual tabela os dados serão consultados usando o método from(), que dado uma classe
         * ou tipo de entidade (EntityType) ele retorna um objeto do tipo Root<T>, que representa a clausula "from" da consulta.
         *
         *   Através do Root<T> é possível obter as colunas, fazer joins, usar a clausula "in" e outros.
         */
        Root<Estoque> estoque = c.from(Estoque.class);
        /**
         *   A partir do Root<T> é chamado o método where() que adiciona uma comparação se o campo "id" da entidade possui o valor do parametro "id".
         *
         *   Diferente do JPQL a passagem de parâmetro é fortemente tipada, a partir da CriteriaBuilder é necessário criar um parâmetro
         * (ParameterExpression<T>) que possui o tipo do parametro e seu nome.
         */
        c.where(cb.equal(estoque.get("idProduto"), cb.parameter(String.class, "idProduto")));

        TypedQuery q = em.createQuery(c);
        /* A passagem de parâmetros é igual ao do JPQL. */
        q.setParameter("idProduto", idProduto);

        return (List<Estoque>) q.getResultList();
    }
}
