package io.github.cnsukidayo.stock.entity;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:22
 */
public class Stock {

    private Integer id;
    private Integer productId;
    private Integer count;

    public Stock() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
