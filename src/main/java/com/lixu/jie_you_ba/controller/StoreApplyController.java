package com.lixu.jie_you_ba.controller;

import com.lixu.jie_you_ba.entity.StoreApply;
import com.lixu.jie_you_ba.service.StoreApplyService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname StoreApplyController
 * @Description TODO
 * @Date 2019-03-25 16:15
 * @Created by lixu
 */
@RestController
@RequestMapping("/storeApply")
public class StoreApplyController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(StoreApplyController.class);

    @Autowired
    private StoreApplyService storeApplyService;

    /**
     * 普通用户申请开通一个店铺
     * @return
     */
    @ApiOperation(value="普通用户申请开通一个店铺", notes="普通用户申请开通一个店铺")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(HttpServletRequest request){

        String applyPersonId = request.getParameter("applyPersonId");
        String applyPersonName = request.getParameter("applyPersonName");
        String storeName = request.getParameter("storeName");
        String storeType = request.getParameter("storeType");
        String storePhone = request.getParameter("storePhone");
        String storeAddress = request.getParameter("storeAddress");
        String storeDescription = request.getParameter("storeDescription");
        String storeReason = request.getParameter("storeReason");

        StoreApply storeApply = new StoreApply();
        storeApply.setApplyPersonId(Long.valueOf(applyPersonId));
        storeApply.setApplyPersonName(applyPersonName);
        if(null != storeName && storeName != ""){
            storeApply.setName(storeName);
        }
        if(null != storeType && storeType != ""){
            storeApply.setType(storeType);
        }
        if(null != storePhone && storePhone != ""){
            storeApply.setPhone(storePhone);
        }
        if(null != storeAddress && storeAddress != ""){
            storeApply.setAddress(storeAddress);
        }
        if(null != storeDescription && storeDescription != ""){
            storeApply.setDescription(storeDescription);
        }
        if(null != storeReason && storeReason != ""){
            storeApply.setReason(storeReason);
        }
        storeApply.setCreatePerson(applyPersonId);

        storeApplyService.insert(storeApply);

        return true;
    }

    /**
     * 超级管理员点击通过或不通过按钮弹出
     * @return
     */
    @ApiOperation(value="超级管理员点击通过或不通过按钮弹出", notes="超级管理员点击通过或不通过按钮弹出")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(HttpServletRequest request,@CookieValue(value = "token", required = false) String token){

        String personId = readCookie(token);
        String applyId = request.getParameter("applyId");
        String applyStatus = request.getParameter("applyStatus");
        String resultOpinion = request.getParameter("resultOpinion");

        //更改店铺申请表对应记录
        StoreApply storeApply = new StoreApply();
        if(null != applyId && applyId != ""){
            storeApply.setId(Long.valueOf(applyId));
        }
        if(null != applyStatus && applyStatus != ""){
            storeApply.setStatus(Integer.valueOf(applyStatus));
        }
        if(null != resultOpinion && resultOpinion != ""){
            storeApply.setResultOpinion(resultOpinion);
        }
        storeApply.setUpdatePerson(personId);
        storeApplyService.update(storeApply);

        return true;
    }

    /**
     * 超级管理员获取当前所有未审核记录
     * @return
     */
    @ApiOperation(value="超级管理员获取当前所有未审核记录", notes="超级管理员获取当前所有未审核记录")
    @RequestMapping(value = "/nowNotDeal", method = RequestMethod.POST)
    public List<StoreApply> nowNotDeal(){
        List<StoreApply> storeApplies = storeApplyService.nowNotDeal();
        return storeApplies;
    }

    /**
     * 普通用户获取其当前店铺申请记录
     * @return
     */
    @ApiOperation(value="普通用户获取其当前店铺申请记录", notes="普通用户获取其当前店铺申请记录")
    @RequestMapping(value = "/now", method = RequestMethod.POST)
    public List<StoreApply> now(@CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        List<StoreApply> storeApplies = storeApplyService.nowApply(Long.valueOf(personId));
        return storeApplies;
    }

    /**
     * 超级管理员获取其所有已审核记录
     * @return
     */
    @ApiOperation(value="超级管理员获取其所有已审核记录", notes="超级管理员获取其所有已审核记录")
    @RequestMapping(value = "/adminHistory", method = RequestMethod.POST)
    public List<StoreApply> adminHistory(@CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        List<StoreApply> storeApplies = storeApplyService.adminHistory(personId);
        return storeApplies;
    }

    /**
     * 普通用户获取其历史店铺申请记录
     * @return
     */
    @ApiOperation(value="普通用户获取其历史店铺申请记录", notes="普通用户获取其历史店铺申请记录")
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public List<StoreApply> history(@CookieValue(value = "token", required = false) String token){
        String personId = readCookie(token);
        List<StoreApply> storeApplies = storeApplyService.history(Long.valueOf(personId));
        return storeApplies;
    }



}
