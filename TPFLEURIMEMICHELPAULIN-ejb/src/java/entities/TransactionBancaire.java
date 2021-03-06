/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author dmichel
 */
@Entity
public class TransactionBancaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int montant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public CompteBancaire getComptebancaire() {
        return comptebancaire;
    }

    public void setComptebancaire(CompteBancaire comptebancaire) {
        this.comptebancaire = comptebancaire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
    @ManyToOne
    private CompteBancaire comptebancaire;
    
    @ManyToOne
    private Client client;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTransaction;

    @Override
    public String toString() {
        return "entity.Transaction[ id=" + id + " ]";//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TransactionBancaire)) {
            return false;
        }
        TransactionBancaire other = (TransactionBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash; //To change body of generated methods, choose Tools | Templates.
    }
    
}
