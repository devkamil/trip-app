package com.project.domain;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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


//    @Override
//    public String toString() {
//        return "Todo: "  + name + ", dateFrom: " + dateFormat.format(dateFrom) + ", done: " + done + "." + "\n";
//    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Todo todo = (Todo) o;
//
//        if (done != todo.done) return false;
//        if (id != null ? !id.equals(todo.id) : todo.id != null) return false;
//        if (name != null ? !name.equals(todo.name) : todo.name != null) return false;
//        return date != null ? date.equals(todo.date) : todo.date == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (done ? 1 : 0);
//        result = 31 * result + (date != null ? date.hashCode() : 0);
//        return result;
//    }

}
