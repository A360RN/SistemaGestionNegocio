/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity
@Table(name = "TSA_POLITICAS")
public class PoliticaTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_politica")
    private int idPolitica;

    @Column(name = "desc_politica")
    private String descPolitica;

    @Column(name = "min_puntos")
    private int minPuntos;

    @Column(name = "max_puntos")
    private int maxPuntos;

    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;

    public PoliticaTO() {
    }

    public int getIdPolitica() {
        return idPolitica;
    }

    public void setIdPolitica(int idPolitica) {
        this.idPolitica = idPolitica;
    }

    public String getDescPolitica() {
        return descPolitica;
    }

    public void setDescPolitica(String descPolitica) {
        this.descPolitica = descPolitica;
    }

    public int getMinPuntos() {
        return minPuntos;
    }

    public void setMinPuntos(int minPuntos) {
        this.minPuntos = minPuntos;
    }

    public int getMaxPuntos() {
        return maxPuntos;
    }

    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idPolitica;
        hash = 89 * hash + this.minPuntos;
        hash = 89 * hash + this.maxPuntos;
        hash = 89 * hash + Objects.hashCode(this.porcentajeDescuento);
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
        final PoliticaTO other = (PoliticaTO) obj;
        if (this.idPolitica != other.idPolitica) {
            return false;
        }
        if (this.minPuntos != other.minPuntos) {
            return false;
        }
        if (this.maxPuntos != other.maxPuntos) {
            return false;
        }
        if (!Objects.equals(this.porcentajeDescuento, other.porcentajeDescuento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PoliticaTO{" + "idPolitica=" + idPolitica + ", minPuntos=" + minPuntos + ", maxPuntos=" + maxPuntos + ", porcentajeDescuento=" + porcentajeDescuento + '}';
    }

}
