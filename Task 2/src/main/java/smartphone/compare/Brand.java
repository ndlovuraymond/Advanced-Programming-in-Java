package smartphone.compare;

import jakarta.persistence.*;

@Entity(name = "brand")
@Table(name = "brand")
public class Brand<B> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "brand")
    private String brand;

    public Brand(){}
    public Brand(String brand) {
        this.brand = brand;
    }

}
