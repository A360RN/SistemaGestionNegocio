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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity(name = "HistoricoDistribuidor")
@Table(name = "TSA_HISTORICO_DISTRIBUIDOR")
public class HistoricoDistribuidorTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico_distribuidor")
    private int idHistoricoDistribuidor;

    @Column(name = "puntos_historico")
    private int puntosHistorico;

    @Column(name = "venta_soles_historico")
    private BigDecimal ventaSolesHistorico;

    @Column(name = "mes_historico")
    private int mesHistorico;

    @Column(name = "anio_historico")
    private int anioHistorico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distribuidor")
    private DistribuidorTO distribuidor;

    public HistoricoDistribuidorTO() {
    }

    public int getIdHistoricoDistribuidor() {
        return idHistoricoDistribuidor;
    }

    public void setIdHistoricoDistribuidor(int idHistoricoDistribuidor) {
        this.idHistoricoDistribuidor = idHistoricoDistribuidor;
    }

    public int getPuntosHistorico() {
        return puntosHistorico;
    }

    public void setPuntosHistorico(int puntosHistorico) {
        this.puntosHistorico = puntosHistorico;
    }

    public BigDecimal getVentaSolesHistorico() {
        return ventaSolesHistorico;
    }

    public void setVentaSolesHistorico(BigDecimal ventaSolesHistorico) {
        this.ventaSolesHistorico = ventaSolesHistorico;
    }

    public int getMesHistorico() {
        return mesHistorico;
    }

    public void setMesHistorico(int mesHistorico) {
        this.mesHistorico = mesHistorico;
    }

    public int getAnioHistorico() {
        return anioHistorico;
    }

    public void setAnioHistorico(int anioHistorico) {
        this.anioHistorico = anioHistorico;
    }

    public DistribuidorTO getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(DistribuidorTO distribuidor) {
        this.distribuidor = distribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idHistoricoDistribuidor;
        hash = 97 * hash + this.puntosHistorico;
        hash = 97 * hash + Objects.hashCode(this.ventaSolesHistorico);
        hash = 97 * hash + this.mesHistorico;
        hash = 97 * hash + this.anioHistorico;
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
        final HistoricoDistribuidorTO other = (HistoricoDistribuidorTO) obj;
        if (this.idHistoricoDistribuidor != other.idHistoricoDistribuidor) {
            return false;
        }
        if (this.puntosHistorico != other.puntosHistorico) {
            return false;
        }
        if (this.mesHistorico != other.mesHistorico) {
            return false;
        }
        if (this.anioHistorico != other.anioHistorico) {
            return false;
        }
        if (!Objects.equals(this.ventaSolesHistorico, other.ventaSolesHistorico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistoricoDistribuidorTO{" + "idHistoricoDistribuidor=" + idHistoricoDistribuidor + ", puntosHistorico=" + puntosHistorico + ", ventaSolesHistorico=" + ventaSolesHistorico + ", mesHistorico=" + mesHistorico + ", anioHistorico=" + anioHistorico + '}';
    }

}
