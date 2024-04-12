package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;

@Data //Getter, Setter 분리해서 쓰는걸 추천
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; //수량이 0일 수 있음

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
