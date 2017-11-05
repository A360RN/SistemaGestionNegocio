/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity
@Table(name = "TSA_CATEGORIA")
public class CategoriaTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "desc_categoria")
    private String descCategoria;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<ProductoTO> productos;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<OfertaTO> ofertas;

    public CategoriaTO() {
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public List<ProductoTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTO> productos) {
        this.productos = productos;
    }

    public List<OfertaTO> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaTO> ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idCategoria;
        hash = 37 * hash + Objects.hashCode(this.nombreCategoria);
        hash = 37 * hash + Objects.hashCode(this.descCategoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaTO other = (CategoriaTO) obj;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (!Objects.equals(this.nombreCategoria, other.nombreCategoria)) {
            return false;
        }
        if (!Objects.equals(this.descCategoria, other.descCategoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriaTO{" + "idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", descCategoria=" + descCategoria + '}';
    }

}
