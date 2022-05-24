package com.shf.gulimail.modules.coupon.controller;

import com.shf.gulimail.common.annotation.LogOperation;
import com.shf.gulimail.common.constant.Constant;
import com.shf.gulimail.common.page.PageData;
import com.shf.gulimail.common.utils.ExcelUtils;
import com.shf.gulimail.common.utils.Result;
import com.shf.gulimail.common.validator.AssertUtils;
import com.shf.gulimail.common.validator.ValidatorUtils;
import com.shf.gulimail.common.validator.group.AddGroup;
import com.shf.gulimail.common.validator.group.DefaultGroup;
import com.shf.gulimail.common.validator.group.UpdateGroup;
import com.shf.gulimail.modules.coupon.dto.MemberPriceDTO;
import com.shf.gulimail.modules.coupon.excel.MemberPriceExcel;
import com.shf.gulimail.modules.coupon.service.MemberPriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 商品会员价格
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@RestController
@RequestMapping("coupon/memberprice")
@Api(tags="商品会员价格")
public class MemberPriceController {
    @Autowired
    private MemberPriceService memberPriceService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<MemberPriceDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<MemberPriceDTO> page = memberPriceService.page(params);

        return new Result<PageData<MemberPriceDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<MemberPriceDTO> get(@PathVariable("id") Long id){
        MemberPriceDTO data = memberPriceService.get(id);

        return new Result<MemberPriceDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    // @RequiresPermissions("coupon:memberprice:save")
    public Result save(@RequestBody MemberPriceDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberPriceService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    // @RequiresPermissions("coupon:memberprice:update")
    public Result update(@RequestBody MemberPriceDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberPriceService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    // @RequiresPermissions("coupon:memberprice:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberPriceService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    // @RequiresPermissions("coupon:memberprice:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<MemberPriceDTO> list = memberPriceService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, MemberPriceExcel.class);
    }

}