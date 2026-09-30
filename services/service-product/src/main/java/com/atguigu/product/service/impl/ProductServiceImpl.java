package com.atguigu.product.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.atguigu.product.bean.Product;
import com.atguigu.product.properties.ProductProperties;
import com.atguigu.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductProperties productProperties;

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果-" + productId);
        product.setNum(2);
        log.info("aaaaaa");
        long t = productProperties.getTimeoutTest();

        if (t > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(t);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (StringUtils.equalsIgnoreCase(productProperties.getExceptionTest(), "T")) {
            int s = 10 / 0;
        }
        return product;
    }
}
