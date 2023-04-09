package go.it.springlessons.entities;

public class Note {
    private Long id;
    private String tittle;
    private String content;

    public Note(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
