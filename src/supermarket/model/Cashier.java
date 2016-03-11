/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supermarket.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Duong
 */
@Entity
@Table(name = "cashier", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cashier.findAll", query = "SELECT c FROM Cashier c"),
    @NamedQuery(name = "Cashier.findByCashierID", query = "SELECT c FROM Cashier c WHERE c.cashierID = :cashierID"),
    @NamedQuery(name = "Cashier.findByFullName", query = "SELECT c FROM Cashier c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "Cashier.findByPassword", query = "SELECT c FROM Cashier c WHERE c.password = :password"),
    @NamedQuery(name = "Cashier.findByAdminadminID", query = "SELECT c FROM Cashier c WHERE c.adminadminID = :adminadminID")})
public class Cashier implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cashier_ID")
    private Integer cashierID;
    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "admin_admin_ID")
    private int adminadminID;

    public Cashier() {
    }

    public Cashier(Integer cashierID) {
        this.cashierID = cashierID;
    }

    public Cashier(Integer cashierID, String fullName, String password, int adminadminID) {
        this.cashierID = cashierID;
        this.fullName = fullName;
        this.password = password;
        this.adminadminID = adminadminID;
    }

    public Integer getCashierID() {
        return cashierID;
    }

    public void setCashierID(Integer cashierID) {
        Integer oldCashierID = this.cashierID;
        this.cashierID = cashierID;
        changeSupport.firePropertyChange("cashierID", oldCashierID, cashierID);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        String oldFullName = this.fullName;
        this.fullName = fullName;
        changeSupport.firePropertyChange("fullName", oldFullName, fullName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public int getAdminadminID() {
        return adminadminID;
    }

    public void setAdminadminID(int adminadminID) {
        int oldAdminadminID = this.adminadminID;
        this.adminadminID = adminadminID;
        changeSupport.firePropertyChange("adminadminID", oldAdminadminID, adminadminID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cashierID != null ? cashierID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cashier)) {
            return false;
        }
        Cashier other = (Cashier) object;
        if ((this.cashierID == null && other.cashierID != null) || (this.cashierID != null && !this.cashierID.equals(other.cashierID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "supermarket.View.Admin.Cashier[ cashierID=" + cashierID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
