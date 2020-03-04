/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
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
 * @author aevan
 */
@Entity
@Table(name = "LIBRARY_USERS", catalog = "", schema = "DBMS2")
@NamedQueries({
    @NamedQuery(name = "LibraryUsers.findAll", query = "SELECT l FROM LibraryUsers l")
    , @NamedQuery(name = "LibraryUsers.findByUserId", query = "SELECT l FROM LibraryUsers l WHERE l.userId = :userId")
    , @NamedQuery(name = "LibraryUsers.findByLoginId", query = "SELECT l FROM LibraryUsers l WHERE l.loginId = :loginId")
    , @NamedQuery(name = "LibraryUsers.findByFirstName", query = "SELECT l FROM LibraryUsers l WHERE l.firstName = :firstName")
    , @NamedQuery(name = "LibraryUsers.findByLastName", query = "SELECT l FROM LibraryUsers l WHERE l.lastName = :lastName")
    , @NamedQuery(name = "LibraryUsers.findByLoginPassword", query = "SELECT l FROM LibraryUsers l WHERE l.loginPassword = :loginPassword")
    , @NamedQuery(name = "LibraryUsers.findByAddress", query = "SELECT l FROM LibraryUsers l WHERE l.address = :address")
    , @NamedQuery(name = "LibraryUsers.findByLibrarian", query = "SELECT l FROM LibraryUsers l WHERE l.librarian = :librarian")
    , @NamedQuery(name = "LibraryUsers.findByUnpaidFines", query = "SELECT l FROM LibraryUsers l WHERE l.unpaidFines = :unpaidFines")})
public class LibraryUsers implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "LOGIN_ID")
    private String loginId;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "LOGIN_PASSWORD")
    private String loginPassword;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "LIBRARIAN")
    private Character librarian;
    @Column(name = "UNPAID_FINES")
    private BigInteger unpaidFines;

    public LibraryUsers() {
    }

    public LibraryUsers(Integer userId) {
        this.userId = userId;
    }

    public LibraryUsers(Integer userId, String loginId, String firstName, String lastName, String loginPassword, String address) {
        this.userId = userId;
        this.loginId = loginId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginPassword = loginPassword;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        Integer oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        String oldLoginId = this.loginId;
        this.loginId = loginId;
        changeSupport.firePropertyChange("loginId", oldLoginId, loginId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        String oldLoginPassword = this.loginPassword;
        this.loginPassword = loginPassword;
        changeSupport.firePropertyChange("loginPassword", oldLoginPassword, loginPassword);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public Character getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Character librarian) {
        Character oldLibrarian = this.librarian;
        this.librarian = librarian;
        changeSupport.firePropertyChange("librarian", oldLibrarian, librarian);
    }

    public BigInteger getUnpaidFines() {
        return unpaidFines;
    }

    public void setUnpaidFines(BigInteger unpaidFines) {
        BigInteger oldUnpaidFines = this.unpaidFines;
        this.unpaidFines = unpaidFines;
        changeSupport.firePropertyChange("unpaidFines", oldUnpaidFines, unpaidFines);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryUsers)) {
            return false;
        }
        LibraryUsers other = (LibraryUsers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.LibraryUsers[ userId=" + userId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
