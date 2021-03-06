package by.berdmival.derevenskoe.controller;

import by.berdmival.derevenskoe.entity.product.Product;
import by.berdmival.derevenskoe.service.product.CategoryService;
import by.berdmival.derevenskoe.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Products management system")
@RestController
public class ProductStorageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Get all products in the storage", response = List.class)
    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @ApiOperation(value = "Add new product in the storage", response = Product.class)
    @PostMapping(path = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveOne(product));
    }

    @ApiOperation(value = "Update product in the storage", response = Product.class)
    @PutMapping(path = "/products/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") Long bookId) {
        product.setId(bookId);
        return ResponseEntity.ok(productService.saveOne(product));
    }

    @ApiOperation(value = "Get product in the storage by it's id", response = Product.class)
    @GetMapping(path = "/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long bookId) {
        Product product = productService.findById(bookId);
        if (product.getId() == bookId) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Delete product in the storage by it's id", response = void.class)
    @DeleteMapping(path = "/products/{productId}")
    public void deleteProductById(@PathVariable("productId") Long bookId) {
        productService.deleteOneById(bookId);
    }

    @ApiOperation(value = "Delete product in the storage by it's json", response = void.class)
    @DeleteMapping(path = "/products")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteOne(product);
    }

    @ApiOperation(value = "Get all products in the storage by category name", response = List.class)
    @GetMapping(path = "/products/{categoryName}")
    public ResponseEntity<List<Product>> findByCategoryName(@PathVariable("categoryName") String categoryName) {
        return ResponseEntity.ok(productService.findByCategory(categoryService.findByName(categoryName)));
    }

    @ApiOperation(value = "Get all products in the storage by category id", response = List.class)
    @GetMapping(path = "/products/{categoryId}")
    public ResponseEntity<List<Product>> findByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(productService.findByCategory(categoryService.findById(categoryId)));
    }
}
