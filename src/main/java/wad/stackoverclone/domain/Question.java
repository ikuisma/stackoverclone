package wad.stackoverclone.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
public class Question extends AbstractPersistable<Long> {

    @NotEmpty
    @NotBlank
    @Length(min = 10, max = 100)
    private String title;

    @NotEmpty
    @NotBlank
    @Length( min = 10, max = 1000 )
    @Column( length = 1000 )
    private String content;

    @ManyToOne
    private Account author;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

}
