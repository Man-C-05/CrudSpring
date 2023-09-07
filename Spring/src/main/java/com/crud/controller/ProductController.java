/*
 * package com.crud.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.crud.entity.Product; import com.crud.service.ProductService;
 * 
 * @RestController
 * 
 * @RequestMapping("/prod")
 * 
 * public class ProductController {
 * 
 * @Autowired private ProductService service;
 * 
 * @RequestMapping(method = RequestMethod.GET) public void show1() {
 * System.out.println("hello"); }
 * 
 * @PostMapping("/addProduct") public Product addProduct(@RequestBody Product
 * product) { return service.saveProduct(product); }
 * 
 * @PostMapping("/addProducts") public List<Product> addProducts(@RequestBody
 * List<Product> products) { return service.saveProducts(products); }
 * 
 * @PostMapping("/products") public List<Product> findAllProducts() { return
 * service.getProducts(); }
 * 
 * }
 */