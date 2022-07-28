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
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName StudentController
 * @Author 王兆辉
 * @Date 2022/4/9 23:00
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/data/{code}")
@RequiredArgsConstructor
public class BizDataController {
    private final BizDataServiceImpl bizDataService;
    private final BizAttrServiceImpl bizAttrService;

    @GetMapping("/list")
    public List<Map> listStudent(@PathVariable String code) {
        List<BizData> bizDataList = bizDataService.selectByCondition(
                Condition.builder(BizData.class).where(Sqls.custom().andEqualTo("formCode", code)).build());
        return meta2Obj(bizDataList);
    }

    @GetMapping("/{id}")
    public Map getStu(@PathVariable String code, @PathVariable Long id) {
        List<Map> result = meta2Obj(bizDataService.selectByCondition(
                Condition.builder(BizData.class).where(Sqls.custom().andEqualTo("formCode", code).andEqualTo("dataId", id)).build()));
        if (CollectionUtils.isEmpty(result)) {
            return new HashMap(16) {{
                put("error", "数据不存在");
            }};
        }
        return result.get(0);
    }

    private List<Map> meta2Obj(List<BizData> bizDataList) {
        Map<Long, List<BizData>> map = bizDataList.parallelStream().collect(Collectors.groupingBy(meta -> meta.getDataId()));
        List<Map> result = new ArrayList<>(25);
        map.entrySet().stream().forEach(e -> {
            HashMap<String, Object> obj = new HashMap<>(16);
            List<BizData> attrs = e.getValue();
            attrs.stream().forEach(attr -> obj.put(attr.getAttrCode(), attr.getDataValue()));
            result.add(obj);
        });
        return result;
    }
}
