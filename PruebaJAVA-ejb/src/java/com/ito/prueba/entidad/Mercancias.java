/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ito.prueba.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author itoadmin
 */
@Entity
@Table(name = "MERCANCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mercancias.findAll", query = "SELECT m FROM Mercancias m")
    , @NamedQuery(name = "Mercancias.findById", query = "SELECT m FROM Mercancias m WHERE m.id = :id")
    , @NamedQuery(name = "Mercancias.findByNombreProducto", query = "SELECT m FROM Mercancias m WHERE m.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Mercancias.findByCiudadDestino", query = "SELECT m FROM Mercancias m WHERE m.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Mercancias.findByDireccion", query = "SELECT m FROM Mercancias m WHERE m.direccion = :direccion")
    , @NamedQuery(name = "Mercancias.findByFechaSalida", query = "SELECT m FROM Mercancias m WHERE m.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Mercancias.findByPrecio", query = "SELECT m FROM Mercancias m WHERE m.precio = :precio")
    , @NamedQuery(name = "Mercancias.findByEstadoEnvio", query = "SELECT m FROM Mercancias m WHERE m.estadoEnvio = :estadoEnvio")
    , @NamedQuery(name = "Mercancias.findByDestinatarioId", query = "SELECT m FROM Mercancias m WHERE m.destinatarioId = :destinatarioId")
    , @NamedQuery(name = "Mercancias.findByUsuarioRegistroId", query = "SELECT m FROM Mercancias m WHERE m.usuarioRegistroId = :usuarioRegistroId")})
public class Mercancias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Size(max = 30)
    @Column(name = "CIUDAD_DESTINO")
    private String ciudadDestino;
    @Size(max = 80)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(name = "PRECIO")
    private Long precio;
    @Size(max = 10)
    @Column(name = "ESTADO_ENVIO")
    private String estadoEnvio;
    @Column(name = "DESTINATARIO_ID")
    private Integer destinatarioId;
    @Column(name = "USUARIO_REGISTRO_ID")
    private Integer usuarioRegistroId;

    public Mercancias() {
    }

    public Mercancias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Integer destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public Integer getUsuarioRegistroId() {
        return usuarioRegistroId;
    }

    public void setUsuarioRegistroId(Integer usuarioRegistroId) {
        this.usuarioRegistroId = usuarioRegistroId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercancias)) {
            return false;
        }
        Mercancias other = (Mercancias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ito.prueba.entidad.Mercancias[ id=" + id + " ]";
    }
    
}
