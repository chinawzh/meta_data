package sunbeam.base.metadata.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName BizData
 * @Author 王兆辉
 * @Date 2022/4/9 23:24
 * @Version 1.0
 * @Description
 */
@Data
@Table(name = "biz_attr")
@EqualsAndHashCode(callSuper = false)
public class BizAttr {

    /**
     * 主键
     */
    @Column(name = "id")
    @Id
    private Long id;

    @NotBlank(message = "表单编码不能为空")
    @Column(name = "fk_biz_form_code")
    private String fkBizFormCode;

    @NotBlank(message = "属性编码不能为空")
    @Column(name = "attr_code")
    private String attrCode;

    @NotBlank(message = "属性类型不能为空")
    @Column(name = "attr_type")
    private String attrType;

    @NotBlank(message = "属性名称不能为空")
    @Column(name = "attr_name")
    private String attrName;

    @Column(name = "remark")
    private String remark;
}
