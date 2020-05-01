package com.page.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.page.ssm.domain.Orders;
import com.page.ssm.domain.Product;
import com.page.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productLIst",ps);
        mv.setViewName("product-list1");
        return mv;
    }

    @RequestMapping("/saveProduct.do")
    public String saveProduct(Product product) throws Exception {
        System.out.println("控制层：保存产品信息。。。。。。。。。。。。");
        productService.saveProduct(product);
        return "redirect:/product/findAll.do";
    }

    @RequestMapping("toProdectaddPage.do")
    public String toProdectaddPage(){

        return "product-add";
    }

    @RequestMapping("testPage.do")
    public ModelAndView  testPage(@RequestParam(name="page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "2")int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.testPage(page,size);

       // List<Product> list = PageHelper.startPage(page, size);

        PageInfo pageInfo = new PageInfo(productList);

        mv.addObject("pageInfo",pageInfo);

        mv.setViewName("product-page-list1");
        return mv;
    }
    @RequestMapping("/toSavePage.do")
    public String toSavePage(){

        return "product-add";
    }

}
