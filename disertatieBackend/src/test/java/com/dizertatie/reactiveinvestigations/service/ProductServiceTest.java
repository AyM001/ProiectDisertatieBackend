package com.dizertatie.reactiveinvestigations.service;

import com.dizertatie.reactiveinvestigations.persistance.model.ProductModel;
import com.dizertatie.reactiveinvestigations.persistance.model.TargetModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dizertatie.reactiveinvestigations.common.Utils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void addProductTest() {
        ProductModel productModel = new ProductModel();
        productModel.setProductType(SMS);
        productModel.setFirstName("first");
        productModel.setLastName("last");
        productModel.setPhoneNr("0721212121");
        productModel.setCallDuration(NO_DURATION);
        productModel.setEmailAddress("first.last001@gmail.com");
        productModel.setCoordinates("[44.3126, 23.8005]");
        productModel.setDirection(OUTGOING);
        //productModel.setParticipant();
        productModel.setTargetModel(new TargetModel());

        ProductModel createdProduct = productService.addProducts(productModel);
        assertNotNull(createdProduct);
        assertEquals("first", createdProduct.getFirstName());
        // Add additional assertions based on your requirements
    }


    @Test
    void getProductByIdTest() {
        ProductModel productModel = new ProductModel();
        productModel.setProductId(1L);
        productModel.setProductType(SMS);
        productModel.setFirstName("first");
        productModel.setLastName("last");
        productModel.setPhoneNr("0721212121");
        productModel.setCallDuration(NO_DURATION);
        productModel.setEmailAddress("first.last001@gmail.com");
        productModel.setCoordinates("[44.3126, 23.8005]");
        productModel.setDirection(OUTGOING);
        //productModel.setParticipant();
        productModel.setTargetModel(new TargetModel());

        ProductModel createdProduct = productService.addProducts(productModel);
        Long userId = createdProduct.getProductId();

        ProductModel fetchedProduct = productService.findProductById(userId);
        assertNotNull(fetchedProduct);
        assertEquals("first", fetchedProduct.getFirstName());
        // Add additional assertions based on your requirements
    }

    @Test
    void areValidCoordinatesTest() {
        ProductModel productModel = new ProductModel();
        productModel.setProductId(1L);
        productModel.setProductType(SMS);
        productModel.setFirstName("first");
        productModel.setLastName("last");
        productModel.setPhoneNr("0721212121");
        productModel.setCallDuration(NO_DURATION);
        productModel.setEmailAddress("first.last001@gmail.com");
        productModel.setCoordinates("[44.3126, 23.8005]");
        productModel.setDirection(OUTGOING);
        //productModel.setParticipant();
        productModel.setTargetModel(new TargetModel());

        ProductModel createdProduct = productService.addProducts(productModel);
        Long userId = createdProduct.getProductId();

        ProductModel fetchedProduct = productService.findProductById(userId);
        assertNotNull(fetchedProduct);
        assertEquals("[44.3126, 23.8005]", fetchedProduct.getCoordinates());
        // Add additional assertions based on your requirements
    }

    @Test
    void generateReportTest(){
        ProductModel productModel = new ProductModel();
        productModel.setProductId(1L);
        productModel.setProductType(SMS);
        productModel.setFirstName("first");
        productModel.setLastName("last");
        productModel.setPhoneNr("0721212121");
        productModel.setCallDuration(NO_DURATION);
        productModel.setEmailAddress("first.last001@gmail.com");
        productModel.setCoordinates("[44.3126, 23.8005]");
        productModel.setDirection(OUTGOING);
        //productModel.setParticipant();
        productModel.setTargetModel(new TargetModel());

        ProductModel createdProduct = productService.addProducts(productModel);
        Long userId = createdProduct.getProductId();

        ProductModel fetchedProduct = productService.findProductById(userId);
        productService.addReport(fetchedProduct.getProductId());
        assertNotNull(fetchedProduct);

        // Add additional assertions based on your requirements
    }


}