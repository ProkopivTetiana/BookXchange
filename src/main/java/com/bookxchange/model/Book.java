package com.bookxchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK")

public class Book {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String authorFullName;

    @Column(nullable = false)
    private Integer publicationYear;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;
}
