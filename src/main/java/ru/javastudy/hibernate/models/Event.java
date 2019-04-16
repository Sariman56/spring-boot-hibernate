package ru.javastudy.hibernate.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event", schema = "", catalog = "x92176f5_inovat")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_event;
    @Column(name = "Site_event")
    private String site_event;
    @Column(name = "Name_event")
    private String name_event;
    @Column(name = "Importance_event")
    private String importance_event;
    @Column(name = "Scope_event")
    private String Scope_event;
    @Column(name = "Description")
    private String description;
//    @Column(name = "id_type_event")
//    private int id_type_event;
    @Column(name = "Phone_number")
    private String phone_number;
    @Column(name = "Date_event")
    private Date date_event;
    @Column(name = "Date_for_month")
    private Date date_for_month;
    @Column(name = "Date_for_the_week")
    private Date date_for_the_week;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "Prizes")
    private String prizes;
    @Column(name = "Location_event")
    private String location_event;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person_event",
            //foreign key for CarsEntity in employee_car table
            joinColumns = @JoinColumn(name = "id_event"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "id_person"))
    public Set<Person> persons = new HashSet<>();

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getsite_event() {
        return site_event;
    }

    public void setsite_event(String site_event) {
        this.site_event = site_event;
    }

    public String getname_event() {
        return name_event;
    }

    public void setname_event(String name_event) {
        this.name_event = name_event;
    }

    public String getimportance_event() {
        return importance_event;
    }

    public void setimportance_event(String importance_event) {
        this.importance_event = importance_event;
    }

    public String getScope_event() {
        return Scope_event;
    }

    public void setScope_event(String Scope_event) {
        this.Scope_event = Scope_event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getid_type_event() {
//        return id_type_event;
//    }
//
//    public void setid_type_event(int id_type_event) {
//        this.id_type_event = id_type_event;
//    }

    public String getphone_number() {
        return phone_number;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getdate_event() {
        return date_event;
    }

    public void setdate_event(Date date_event) {
        this.date_event = date_event;
    }

    public Date getdate_for_month() {
        return date_for_month;
    }

    public void setdate_for_month(Date date_for_month) {
        this.date_for_month = date_for_month;
    }

    public Date getdate_for_the_week() {
        return date_for_the_week;
    }

    public void setdate_for_the_week(Date date_for_the_week) {
        this.date_for_the_week = date_for_the_week;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPrizes() {
        return prizes;
    }

    public void setPrizes(String prizes) {
        this.prizes = prizes;
    }

    public String getLocation_event() {
        return location_event;
    }

    public void setLocation_event(String location_event) {
        this.location_event = location_event;
    }
}
