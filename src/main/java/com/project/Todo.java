package com.project;


import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_id")
    private Long id;
    private String content;
    private String done;
    private String date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done='" + done + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        if (content != null ? !content.equals(todo.content) : todo.content != null) return false;
        if (done != null ? !done.equals(todo.done) : todo.done != null) return false;
        return date != null ? date.equals(todo.date) : todo.date == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
