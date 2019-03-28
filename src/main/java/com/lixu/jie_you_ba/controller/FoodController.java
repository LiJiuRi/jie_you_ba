package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.dto.FoodDto;
import com.lixu.jie_you_ba.dto.LoginUserVo;
import com.lixu.jie_you_ba.entity.Admin;
import com.lixu.jie_you_ba.entity.Food;
import com.lixu.jie_you_ba.service.AdminService;
import com.lixu.jie_you_ba.service.FoodService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname FoodController
 * @Description TODO
 * @Date 2019-03-15 21:46
 * @Created by lixu
 */
@RestController
@RequestMapping("/food")
public class FoodController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodService foodService;

    @Autowired
    private AdminService adminService;

    /**
     * 插入一条菜品
     * @param foodDto
     * @return
     */
    @ApiOperation(value="插入一条菜品", notes="插入一条菜品")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public FoodDto insert(FoodDto foodDto, @CookieValue(value = "token", required = false) String token){
        logger.info("foodDto={}",foodDto);
        //获取操作人
        if(foodDto.getName() == ""){
            foodDto.setName(null);
        }
        if(foodDto.getImage() == ""){
            foodDto.setImage(null);
        }
        String personId = readCookie(token);
        Admin admin = adminService.select(Long.valueOf(personId));
        foodDto.setStoreId(admin.getStoreId());
        if(null != personId){
            foodDto.setCreatePerson(personId);
        }
        foodService.insert(foodDto);
        return foodDto;
    }

    /**
     * 更新一条菜品
     * @param foodDto
     * @return
     */
    @ApiOperation(value="更新一条菜品", notes="更新一条菜品")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public FoodDto update(FoodDto foodDto, @CookieValue(value = "token", required = false) String token){
        Assert.notNull(foodDto.getId(),"菜品id不能为空");
        //获取操作人
        if(foodDto.getName() == ""){
            foodDto.setName(null);
        }
        if(foodDto.getImage() == ""){
            foodDto.setImage(null);
        }
        String personId = readCookie(token);
        if(null != personId){
            foodDto.setUpdatePerson(personId);
        }
        foodService.update(foodDto);
        return foodDto;
    }

    /**
     * 删除一条菜品
     * @param id
     * @return
     */
    @ApiOperation(value="删除一条菜品", notes="删除一条菜品")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("id") Long id){
        Assert.notNull(id,"菜品id不能为空");
        int i = foodService.delete(id);
        return i;
    }

    /**
     * 获取一条菜品
     * @param id
     * @return
     */
    @ApiOperation(value="获取一条菜品", notes="获取一条菜品")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public FoodDto get(@RequestParam("id") Long id){
        Assert.notNull(id,"菜品id不能为空");
        return foodService.get(id);
    }

    /**
     * 根据对应分类id获取全部菜品
     * @param
     * @return
     */
    @ApiOperation(value="根据对应分类id获取全部菜品", notes="根据对应分类id获取全部菜品")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<FoodDto> list(@RequestParam("food_catalog_id") Long foodCatalogId){
        return foodService.list(foodCatalogId);
    }

    /**
     * 根据对应分类id或店铺id获取全部菜品，与上一个不一样
     * @param
     * @return
     */
    @ApiOperation(value="根据对应分类id或店铺id获取全部菜品", notes="根据对应分类id或店铺id获取全部菜品")
    @RequestMapping(value = "/listByStoreId", method = RequestMethod.POST)
    public List<Food> listByStoreId(@RequestParam("catalogId") Long foodCatalogId, @CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        Admin admin = adminService.select(Long.valueOf(personId));
        return foodService.listByStoreId(foodCatalogId,admin.getStoreId());
    }
}
