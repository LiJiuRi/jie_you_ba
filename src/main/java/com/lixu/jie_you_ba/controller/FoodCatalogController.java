package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.FoodCatalogDto;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.entity.FoodCatalog;
import com.lixu.jie_you_ba.service.AdminService;
import com.lixu.jie_you_ba.service.FoodCatalogService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname FoodCatalogController
 * @Description TODO
 * @Date 2019-03-14 23:37
 * @Created by lixu
 */
@RestController
@RequestMapping("/foodCatalog")
public class FoodCatalogController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(FoodCatalogController.class);

    @Autowired
    private FoodCatalogService foodCatalogService;

    @Autowired
    private AdminService adminService;

    /**
     * 插入一条菜品分类
     * @return
     */
    @ApiOperation(value="插入一条菜品分类", notes="插入一条菜品分类")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public FoodCatalog insert(HttpServletRequest request, @CookieValue(value = "token", required = false) String token){
        //获取菜单目录名称
        String catalogName = request.getParameter("CatalogName");
        String personId = readCookie(token);
        Admin admin = adminService.select(Long.valueOf(personId));
        FoodCatalog foodCatalog = new FoodCatalog();
        foodCatalog.setName(catalogName);
        foodCatalog.setCreatePerson(personId);
        foodCatalog.setStoreId(admin.getStoreId());
        foodCatalogService.insert(foodCatalog);
        return foodCatalog;
    }

    /**
     * 更新一条菜品分类
     * @param foodCatalogDto
     * @return
     */
    @ApiOperation(value="更新一条菜品分类", notes="更新一条菜品分类")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public FoodCatalogDto update(FoodCatalogDto foodCatalogDto, @CookieValue(value = "token", required = false) String token){
        Assert.notNull(foodCatalogDto.getId(),"菜品分类id不能为空");
        //获取操作人
        String personId = readCookie(token);
        if(null != personId){
            foodCatalogDto.setUpdatePerson(personId);
        }
        foodCatalogService.update(foodCatalogDto);
        return foodCatalogDto;
    }

    /**
     * 删除一条菜品分类
     * @param id
     * @return
     */
    @ApiOperation(value="删除一条菜品分类", notes="删除一条菜品分类")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("id") Long id){
        Assert.notNull(id,"菜品分类id不能为空");
        int i = foodCatalogService.delete(id);
        return i;
    }

    /**
     * 获取一条菜品分类
     * @param id
     * @return
     */
    @ApiOperation(value="获取一条菜品分类", notes="获取一条菜品分类")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public FoodCatalogDto get(@RequestParam("id") Long id){
        Assert.notNull(id,"菜品分类id不能为空");
        return foodCatalogService.get(id);
    }

    /**
     * 获取全部菜品分类
     * @param
     * @return
     */
    @ApiOperation(value="获取全部菜品分类", notes="获取全部菜品分类")
    @RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
    public List<FoodCatalogDto> list(HttpServletRequest request,@CookieValue(value = "token", required = false) String token){
        if(null != token){
            String personId = readCookie(token);
            Admin admin = adminService.select(Long.valueOf(personId));
            return foodCatalogService.list(admin.getStoreId());
        }
        String storeId = request.getParameter("storeId");
        return foodCatalogService.list(Long.valueOf(storeId));
    }
}

