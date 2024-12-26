package com.jsp.controller;

import com.jsp.dao.GroceryDao;
import com.jsp.dto.Grocery;
import com.jsp.dto.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Controller
public class GroceryController {
    @Autowired
    GroceryDao dao;

    @RequestMapping("/ITEMS")
    public ModelAndView getProductDetails(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("product" ,new Grocery());
        mv.setViewName("add.jsp");
        return mv;
    }
    @RequestMapping("/save")
    @ResponseBody
        public String saveProduct(@ModelAttribute Grocery product) {
        dao.saveItem(product);
        return "Product added Successfully....";
    }

    @RequestMapping("/SEARCH")
    public ModelAndView searchProduct() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", new Grocery());
        mv.setViewName("get.jsp");
        return mv;
    }
    @RequestMapping("/view")
    public ModelAndView findProduct(@ModelAttribute Grocery product){
        Grocery item = dao.getProductById(product.getProductId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", item);
        mv.setViewName("display.jsp");
        return mv;
    }
    @RequestMapping("/PURCHASE")
    public ModelAndView purchaseGrocery(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", new Purchase());
        mv.setViewName("purchase.jsp");
        return mv;
    }
    @RequestMapping("/bill")
    public ModelAndView purchaseItem(@ModelAttribute Purchase product){
        String result = dao.purchaseProduct(product.getProductId(), product.getQuantity());
        ModelAndView mv = new ModelAndView();
        if (result.startsWith("Bill")) {
            mv.addObject("bill", result);
            mv.setViewName("billl.jsp");
        } else {
            mv.addObject("error", result);
            mv.setViewName("purchaseFail.jsp");
        }

        return mv;
    }
    @RequestMapping("/SEARCH_BY_NAME")
    public ModelAndView searchByName(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("product", new Grocery());
        mv.setViewName("getByName.jsp");
        return mv;
    }
    @RequestMapping("/viewByName")
    public ModelAndView viewByName(@ModelAttribute Grocery product){
        ModelAndView mv =new ModelAndView();
        List<Grocery> list = dao.searchProducts(product.getName());
        if(list.isEmpty()){
            mv.addObject("error", "No product found.. ");
            mv.setViewName("message.jsp");
        } else {
            mv.addObject("productsList", list);
            mv.setViewName("searchResults.jsp");
        }
        return mv;
    }
    @RequestMapping("/GET_ALL_ITEMS")
    public ModelAndView getAllProducts(){
        ModelAndView mv = new ModelAndView();
        List<Grocery> list = dao.getAllProducts();
        mv.addObject("Productlist",list);
        mv.setViewName("displayAll.jsp");
        return mv;
    }
}

