package sunbeam.base.metadata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sunbeam.base.metadata.entity.BizAttr;
import sunbeam.base.metadata.entity.BizData;
import sunbeam.base.metadata.service.impl.BizAttrServiceImpl;
import sunbeam.base.metadata.service.impl.BizDataServiceImpl;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.util.Sqls;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName StudentController
 * @Author 王兆辉
 * @Date 2022/4/9 23:00
 * @Version 1.0
 * @Description
 */
@RequestMapping("/attr/{code}")
@RestController
@RequiredArgsConstructor
public class BizAttrController {
    private final BizDataServiceImpl bizDataService;
    private final BizAttrServiceImpl bizAttrService;

    @GetMapping("/list")
    public List getStuMeta(@PathVariable String code) {
        List<BizAttr> bizAttrs = bizAttrService.selectByCondition(Condition.builder(BizAttr.class).where(Sqls.custom().andEqualTo("fkBizFormCode", code)).build());
        if (CollectionUtils.isEmpty(bizAttrs)) {
            return Collections.EMPTY_LIST;
        } else {
            return bizAttrs.stream().map(BizAttr::getAttrCode).collect(Collectors.toList());
        }
    }

    @PostMapping
    public String add(@RequestBody @Validated BizAttr bizAttr) {
        bizAttrService.insertSelective(bizAttr);
        return "success";
    }
}
