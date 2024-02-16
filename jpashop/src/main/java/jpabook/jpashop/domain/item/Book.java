package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B") //저장 시 구분
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;

}
