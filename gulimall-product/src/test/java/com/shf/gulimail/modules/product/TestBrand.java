package com.shf.gulimail.modules.product;

import com.shf.gulimail.modules.product.dto.BrandDTO;
import com.shf.gulimail.modules.product.entity.BrandEntity;
import com.shf.gulimail.modules.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TestBrand {
    @Autowired
    private BrandService brandService;

    @Test
    public void testSave(){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName("apple");
        brandService.save(brandDTO);
    }

    @Test
    public void testUpdate(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("武汉");
        brandEntity.setId(2L);
        brandService.updateById(brandEntity);
    }

    @Test
    public void testGet(){
        HashMap<String, Object> map = new HashMap<>();
        List<BrandDTO> list = brandService.list(map);
        System.out.println(list);
    }
}
