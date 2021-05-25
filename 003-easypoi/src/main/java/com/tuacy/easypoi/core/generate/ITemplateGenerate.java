package com.tuacy.easypoi.core.generate;

import com.tuacy.easypoi.core.TemplateEntity;

/**
 *
 * 模板表达式生成
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/24 15:07.
 */
public interface ITemplateGenerate {

    /**
     * 根据字符串解析模板信息
     *
     * @param templateEntity 模板字符串
     * @return 模板对象
     */
    String parse(TemplateEntity templateEntity);

}
