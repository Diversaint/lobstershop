package com.DAO;

import com.model.Product;

public class ProductDAO implements IDAO<Product> {
    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public Product read(Product product) {
        return null;
    }

    @Override
    public Product update(Product product, Product newT) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }
}
