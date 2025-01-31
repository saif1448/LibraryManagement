package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    /**
     * title
     * author
     * edition
     * genre
     */
    private long id;
    private String author;
    private int edition;
    private Genre genre;

    @Override
    public String toString() {
        return "Book{"+
                "author='" + author + '\'' +
                ", edition=" + edition +
                ", genre=" + genre.name() +
                '}';
    }
}
