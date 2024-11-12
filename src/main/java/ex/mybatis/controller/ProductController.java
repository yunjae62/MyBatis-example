package ex.mybatis.controller;

import ex.mybatis.domain.Product;
import ex.mybatis.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productMapper.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productMapper.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("")
    public ResponseEntity<Product> insertProduct(@RequestBody ProductReq request) {
        Product product = request.toEntity();
        productMapper.insert(product);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductReq request) {
        Product product = productMapper.getProduct(id);
        product.update(request.toEntity());
        productMapper.update(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productMapper.delete(id);
        return ResponseEntity.ok().build();
    }
}
