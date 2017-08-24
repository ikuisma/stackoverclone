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
    private String title;

    @NotEmpty
    @NotBlank
    protected String content;

    @Length( max = 10000 )
    @Column( length = 100000 )
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

}
