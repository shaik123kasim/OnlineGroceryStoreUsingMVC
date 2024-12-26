package com.jsp.dao;

import com.jsp.dto.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class GroceryDao {
    @Autowired
    EntityManager manager;
    @Autowired
    EntityTransaction transaction;

    public void saveItem(Grocery grocery) {
        transaction.begin();
        manager.persist(grocery);
        transaction.commit();
    }

    public Grocery getProductById(Long productId) {
        return manager.find(Grocery.class, productId);
    }

    public void updateProduct(Grocery updatedProduct) {
        transaction.begin();
        manager.merge(updatedProduct);
        transaction.commit();
    }

    public void deleteProduct(Long productId) {
        Grocery product = manager.find(Grocery.class, productId);
        if (product != null) {
            transaction.begin();
            manager.remove(product);
            transaction.commit();
        }
    }

    public List<Grocery> getAllProducts() {
        Query query = manager.createQuery("SELECT p FROM Grocery p");
        return query.getResultList();
    }

    public List<Grocery> searchProducts(String name) {
        Query q = manager.createQuery("SELECT p FROM Grocery p WHERE p.name = :name");
        q.setParameter("name", name);
        return q.getResultList();
    }

    public String purchaseProduct(Long productId, int quantity) {
        Grocery product = getProductById(productId);
        if (product != null) {
            if (product.getStock() >= quantity) {
                product.setStock(product.getStock() - quantity);
                saveItem(product);
                return "Bill: " + (product.getPrice() * quantity);
            } else {
                return "Product not available not available in required quantity";
            }
        } else {
            return "Product not available";
        }
    }
}
