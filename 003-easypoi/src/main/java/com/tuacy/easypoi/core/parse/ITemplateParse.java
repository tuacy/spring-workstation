package com.tuacy.easypoi.core.parse;

import com.tuacy.easypoi.core.TemplateEntity;

/**
 * 模板表达式解析
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/24 15:07.
 */
public interface ITemplateParse {


    /**
     * 根据字符串解析模板信息
     *
     * @param templateStr 模板字符串
     * @return 模板对象
     */
    TemplateEntity parse(String templateStr);


}
