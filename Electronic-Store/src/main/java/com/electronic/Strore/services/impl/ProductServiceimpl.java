package com.electronic.Strore.services.impl;

import com.electronic.Strore.dto.ProductDto;
import com.electronic.Strore.entities.Product;
import com.electronic.Strore.entities.User;
import com.electronic.Strore.exception.ResourceNotFoundException;
import com.electronic.Strore.repositories.ProductRepository;
import com.electronic.Strore.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    public ProductServiceimpl() {
        super();
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        String ProductId = UUID.randomUUID().toString();
        productDto.setProductId(ProductId);
        Product product = mapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);

        return mapper.map(savedProduct,ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto, String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found with this id"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setDiscount(productDto.getDiscount());
        Product updatedProduct = productRepository.save(product);

        return mapper.map(updatedProduct,ProductDto.class);
    }

    @Override
    public void delete(String productID) {
        Product product = productRepository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("product not found with this id"));
        productRepository.delete(product);
        System.out.println("product deleted successfully!!");

    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> list = productList.stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .toList();

        return list;

    }

    @Override
    public ProductDto getByPrice(double price) {
        Product product = productRepository.findByPrice(price).orElseThrow(() -> new ResourceNotFoundException("product not found with given price"));
        return mapper.map(product,ProductDto.class);

    }

    @Override
    public ProductDto getByDiscount(double discont) {
        Product product = productRepository.findByPrice(discont).orElseThrow(() -> new ResourceNotFoundException("product not found with given price"));
        return mapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> search(String keyword) {
        List<Product> products= productRepository.findByNameContaining(keyword);
        List<ProductDto> productDtoList = products.stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .toList();
        return productDtoList;
    }
}
