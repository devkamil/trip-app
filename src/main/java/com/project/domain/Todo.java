package com.project.domain;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
public class Todo {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_id")
    private Long id;
    private String name;
    private int routeLength;
    private String startsFrom;
    private String finish;
    private boolean difficult;
    private Date dateFrom;
    private Date dateTo;
    private int days;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRouteLength(){
        return routeLength;
    }

    public void setRouteLength(int routeLength){
        this.routeLength = routeLength;
    }

    public String getStartsFrom() {
        return startsFrom;
    }

    public void setStartsFrom(String startsFrom) {
        this.startsFrom = startsFrom;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isDifficult() {
        return difficult;
    }

    public void setDifficult(boolean difficult) {
        this.difficult = difficult;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", routeLength=" + routeLength +
                ", startsFrom='" + startsFrom + '\'' +
                ", finish='" + finish + '\'' +
                ", difficult=" + difficult +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", days=" + days +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return getRouteLength() == todo.getRouteLength() && isDifficult() == todo.isDifficult() && getDays() == todo.getDays() && getId().equals(todo.getId()) && getName().equals(todo.getName()) && getStartsFrom().equals(todo.getStartsFrom()) && getFinish().equals(todo.getFinish()) && getDateFrom().equals(todo.getDateFrom()) && getDateTo().equals(todo.getDateTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRouteLength(), getStartsFrom(), getFinish(), isDifficult(), getDateFrom(), getDateTo(), getDays());
    }
}
