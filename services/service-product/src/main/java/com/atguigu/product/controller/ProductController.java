package com.atguigu.product.controller;


import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.atguigu.product.bean.Product;
import com.atguigu.product.properties.ProductProperties;
import com.atguigu.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.Json;
import java.util.concurrent.TimeUnit;

//@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductProperties productProperties;


    @GetMapping("/config")
    public String config(){
        // 转成json 字符串
        return JSONUtil.toJsonPrettyStr(productProperties);
    }

    //查询商品
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId,
                              HttpServletRequest request){

        String header = request.getHeader("X-Token");
        System.out.println("hello .... token=【"+header+"】");
        return productService.getProductById(productId);
    }
}
