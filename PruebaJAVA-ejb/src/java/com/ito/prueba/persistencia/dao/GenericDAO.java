/*
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */
package com.ito.prueba.persistencia.dao;

import java.util.List;
import javax.ejb.LocalBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * DAO Generico con las operaciones basicas de persistencia.
 *
 * @author itoadmin
 */
@LocalBean
public class GenericDAO<T> {

    /**
     * Entity Manager
     */
    @PersistenceContext(unitName = "PruebaJAVA-ejbPU")
    protected EntityManager em;

    /**
     * Nombre del DAO (hijo)
     */
    protected String daoName;
    private Class<T> clase;

    /**
     * Constructor.
     */
    public GenericDAO() {
    }

    /**
     * Constructor.
     *
     * @param clase - Clase correspondiente a la Entidad que se toma como base
     * para la construcci&oacute;n del DAO Gen&eacute;rico.
     */
    public GenericDAO(Class<T> clase) {
        this.clase = clase;
        this.daoName = getMyClass() != null && clase != null ? getMyClass().getSimpleName() + "<" + clase.getSimpleName() + ">" : GenericDAO.class.getSimpleName();
    }

    /**
     * Constructor.
     *
     * @param clase - Clase correspondiente a la Entidad que se toma como base
     * para la construcci&oacute;n del DAO Gen&eacute;rico.
     * @param daoName - Nombre del DAO (nodo hijo) que ser&aacute; mostrado en
     * las Excepciones.
     */
    public GenericDAO(Class<T> clase, String daoName) {
        this.clase = clase;
        this.daoName = daoName;
    }

    /**
     * Obtiene el objeto Class correspondiente al DAO instanciador.
     *
     * @return GenericDAO<T>.class
     */
    private Class<GenericDAO<T>> getMyClass() {
        return (Class<GenericDAO<T>>) (Class<?>) GenericDAO.class;
    }

    /**
     * Realiza la consulta de la Entidad a traves del identificador de la misma.
     *
     * @param id
     * @return entidad de tipo "T"
     */
    public T buscarPorCodigo(Object id) {
        return em.find(clase, id);

    }

    /**
     * Realiza la Inserci&oacute;n de un registro de la Entidad.
     *
     * @param entidad
     * @return entidad de tipo "T"
     */
    public T insertar(T entidad) {
        em.persist(entidad);
        em.flush();
        return entidad;
    }

    /**
     * Realiza la Actualizaci&oacute;n del registro de la Entidad.
     *
     * @param entidad
     * @return entidad de tipo "T"
     */
    public T actualizar(T entidad) {
        T result = em.merge(entidad);
        em.flush();
        return result;
    }

    /**
     * Realiza la Eliminacion del registro de la Entidad.
     *
     * @param id
     * @throws ExcepcionDAO
     */
    public void eliminar(Object id) {
        T entidadBorrar = null;
        entidadBorrar = em.find(clase, id);
        if (entidadBorrar != null) {
            em.remove(entidadBorrar);
            em.flush();
        }
    }

    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la
     * Entidad base.
     *
     * @return List of "T"
     * @throws ExcepcionDAO
     */
    public List<T> buscarTodo() {
        List<T> lista = null;
        String className = clase != null ? clase.getSimpleName() : null;
        if (className != null) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM ");
            sql.append(className);
            sql.append(" o");
            Query query = em.createQuery(sql.toString());
            // Oracle Hint para obtener con mayor eficiencia los primeros 20 registros
            query.setHint("openjpa.hint.OracleSelectHint", "/*+ FIRST_ROWS(20) */");
            lista = query.getResultList();
        }
        return lista;
    }

}
