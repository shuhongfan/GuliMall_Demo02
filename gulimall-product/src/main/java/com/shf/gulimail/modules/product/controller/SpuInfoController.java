package com.shf.gulimail.modules.product.controller;

import com.shf.gulimail.common.annotation.LogOperation;
import com.shf.gulimail.common.constant.Constant;
import com.shf.gulimail.common.page.PageData;
import com.shf.gulimail.modules.product.dto.SpuInfoDTO;
import com.shf.gulimail.modules.product.excel.SpuInfoExcel;
import com.shf.gulimail.modules.product.service.SpuInfoService;
import com.shf.gulimail.common.utils.ExcelUtils;
import com.shf.gulimail.common.utils.Result;
import com.shf.gulimail.common.validator.AssertUtils;
import com.shf.gulimail.common.validator.ValidatorUtils;
import com.shf.gulimail.common.validator.group.AddGroup;
import com.shf.gulimail.common.validator.group.DefaultGroup;
import com.shf.gulimail.common.validator.group.UpdateGroup;
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
 * spu信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@RestController
@RequestMapping("product/spuinfo")
@Api(tags="spu信息")
public class SpuInfoController {
    @Autowired
    private SpuInfoService spuInfoService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<SpuInfoDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SpuInfoDTO> page = spuInfoService.page(params);

        return new Result<PageData<SpuInfoDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<SpuInfoDTO> get(@PathVariable("id") Long id){
        SpuInfoDTO data = spuInfoService.get(id);

        return new Result<SpuInfoDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    // @RequiresPermissions("gulimail:spuinfo:save")
    public Result save(@RequestBody SpuInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        spuInfoService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    // @RequiresPermissions("gulimail:spuinfo:update")
    public Result update(@RequestBody SpuInfoDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        spuInfoService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    // @RequiresPermissions("gulimail:spuinfo:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        spuInfoService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    // @RequiresPermissions("gulimail:spuinfo:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<SpuInfoDTO> list = spuInfoService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, SpuInfoExcel.class);
    }

}