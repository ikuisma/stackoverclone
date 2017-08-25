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
    @Length( max = 1000 )
    @Column( length = 1000 )
    private String content;

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
