package sunbeam.base.metadata.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sunbeam.base.metadata.base.BaseMapper;
import sunbeam.base.metadata.base.BaseServiceImpl;
import sunbeam.base.metadata.entity.BizAttr;
import sunbeam.base.metadata.mapper.BizAttrMapper;

/**
 * @ClassName BizDataServiceImpl
 * @Author 王兆辉
 * @Date 2022/4/9 23:37
 * @Version 1.0
 * @Description
 */
@Service
@RequiredArgsConstructor
public class BizAttrServiceImpl extends BaseServiceImpl<BizAttr> {
    private final BizAttrMapper bizDataMapper;

    @Override
    public BaseMapper<BizAttr> getMapper() {
        return bizDataMapper;
    }

}
