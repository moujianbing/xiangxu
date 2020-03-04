package com.xiwei.xiangxu.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author limq7
 * @version 1.0
 * @date 2019/12/18 16:32
 */
/*
* 通过点击链接修改国际化语言
* */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language=httpServletRequest.getParameter("language");
        //System.out.println(language);
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] lanArr=language.split("_");
            locale=new Locale(lanArr[0],lanArr[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
