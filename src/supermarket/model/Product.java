/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supermarket.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author Duong
 */
@Entity
@Table(name = "product", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByCode", query = "SELECT p FROM Product p WHERE p.code = :code"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByProductor", query = "SELECT p FROM Product p WHERE p.productor = :productor"),
    @NamedQuery(name = "Product.findByAmountStock", query = "SELECT p FROM Product p WHERE p.amountStock = :amountStock"),
    @NamedQuery(name = "Product.findByDateExport", query = "SELECT p FROM Product p WHERE p.dateExport = :dateExport"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByTypeCode", query = "SELECT p FROM Product p WHERE p.typeCode = :typeCode")})
public class Product implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "productor")
    private String productor;
    @Basic(optional = false)
    @Column(name = "amount_stock")
    private int amountStock;
    @Basic(optional = false)
    @Column(name = "date_export")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExport;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "type_code")
    private int typeCode;

    public Product() {
    }

    public Product(String code) {
        this.code = code;
    }

    public Product(String code, String name, String productor, int amountStock, Date dateExport, float price, int typeCode) {
        this.code = code;
        this.name = name;
        this.productor = productor;
        this.amountStock = amountStock;
        this.dateExport = dateExport;
        this.price = price;
        this.typeCode = typeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        String oldCode = this.code;
        this.code = code;
        changeSupport.firePropertyChange("code", oldCode, code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        String oldProductor = this.productor;
        this.productor = productor;
        changeSupport.firePropertyChange("productor", oldProductor, productor);
    }

    public int getAmountStock() {
        return amountStock;
    }

    public void setAmountStock(int amountStock) {
        int oldAmountStock = this.amountStock;
        this.amountStock = amountStock;
        changeSupport.firePropertyChange("amountStock", oldAmountStock, amountStock);
    }

    public Date getDateExport() {
        return dateExport;
    }

    public void setDateExport(Date dateExport) {
        Date oldDateExport = this.dateExport;
        this.dateExport = dateExport;
        changeSupport.firePropertyChange("dateExport", oldDateExport, dateExport);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        float oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        int oldTypeCode = this.typeCode;
        this.typeCode = typeCode;
        changeSupport.firePropertyChange("typeCode", oldTypeCode, typeCode);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "supermarket.View.Admin.Product[ code=" + code + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
