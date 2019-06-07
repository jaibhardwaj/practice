package com.jai.practice.hibernate.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = :userId")
@Table(name = "USER_DETAILS")
public class UserDetails
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Temporal(TemporalType.DATE)
    @Column(name = "JOINED_DATE")
    private Date joinedDate;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Address> userAddresses = new HashSet<>();


    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "companyStreet")),
            @AttributeOverride(name = "pincode", column = @Column(name = "companyPincode")),
            @AttributeOverride(name = "state", column = @Column(name = "companystate")),
            @AttributeOverride(name = "city", column = @Column(name = "companyCity"))
    })
    private Address companyAddress;

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }*/

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Vehicle_ID")
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Set<Address> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(Set<Address> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
