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
import com.shf.gulimail.modules.coupon.dto.SeckillSkuNoticeDTO;
import com.shf.gulimail.modules.coupon.excel.SeckillSkuNoticeExcel;
import com.shf.gulimail.modules.coupon.service.SeckillSkuNoticeService;
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
 * 秒杀商品通知订阅
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@RestController
@RequestMapping("coupon/seckillskunotice")
@Api(tags="秒杀商品通知订阅")
public class SeckillSkuNoticeController {
    @Autowired
    private SeckillSkuNoticeService seckillSkuNoticeService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<SeckillSkuNoticeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SeckillSkuNoticeDTO> page = seckillSkuNoticeService.page(params);

        return new Result<PageData<SeckillSkuNoticeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<SeckillSkuNoticeDTO> get(@PathVariable("id") Long id){
        SeckillSkuNoticeDTO data = seckillSkuNoticeService.get(id);

        return new Result<SeckillSkuNoticeDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    // @RequiresPermissions("coupon:seckillskunotice:save")
    public Result save(@RequestBody SeckillSkuNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        seckillSkuNoticeService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    // @RequiresPermissions("coupon:seckillskunotice:update")
    public Result update(@RequestBody SeckillSkuNoticeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        seckillSkuNoticeService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    // @RequiresPermissions("coupon:seckillskunotice:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        seckillSkuNoticeService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    // @RequiresPermissions("coupon:seckillskunotice:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SeckillSkuNoticeDTO> list = seckillSkuNoticeService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, SeckillSkuNoticeExcel.class);
    }

}