package cabanas.garcia.ismael.msproduct.domain.service;

/**
 * Created by ismaelcabanas on 21/6/17.
 */
public class ProductNotExistException extends RuntimeException {
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product %d not found";
    private Long productId;

    public ProductNotExistException() {
        super();
    }

    public ProductNotExistException(String message) {
        super(message);
    }

    public ProductNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotExistException(Throwable cause) {
        super(cause);
    }

    protected ProductNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductNotExistException(Long productId) {
        super(String.format(PRODUCT_NOT_FOUND_MESSAGE, productId));
        this.productId = productId;
    }


    public Long getProductId() {
        return productId;
    }
}
