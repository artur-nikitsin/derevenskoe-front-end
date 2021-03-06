package by.berdmival.derevenskoe.entity.product;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private String pictureUri;
    private double coefficient;
    private String description;

    @OneToOne
    private Category category;
}
