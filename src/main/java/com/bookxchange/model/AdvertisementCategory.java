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
@Table(name = "ADVERTISEMENT_CATEGORY")

public class AdvertisementCategory {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_category_book"))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "advertisement_id", foreignKey = @ForeignKey(name = "fk_advertisement_category"))
    private Advertisement advertisement;
}