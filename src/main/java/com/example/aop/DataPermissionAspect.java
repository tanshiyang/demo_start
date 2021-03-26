/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.example.aop;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.annotation.RequiredDataPermission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据过滤，切面处理类
 *
 * @author Mark sunlightcs@gmail.com
 */
@Aspect
@Component
public class DataPermissionAspect {

    @Pointcut("@annotation(com.example.annotation.RequiredDataPermission)")
    public void dataPermissionCut() {

    }

    @Before("dataPermissionCut()")
    public void dataPermission(JoinPoint point) throws Throwable {
        Object param = point.getArgs()[0];
        if (param != null && param instanceof QueryWrapper) {
//            SysUserEntity user = ShiroUtils.getUserEntity();

            // todo: 如果不是超级管理员，则进行数据过滤
            QueryWrapper wrapper = (QueryWrapper) param;
            wrapper.apply(getSQLFilter("currentUser",point));

            return;
        }

    }

    /**
     * 获取数据过滤的SQL
     */
    private String getSQLFilter(String userId, JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        RequiredDataPermission dataFilter = signature.getMethod().getAnnotation(RequiredDataPermission.class);
        String tableAlias = dataFilter.moduleCode();

        Map<String, String> moduleRules = new HashMap<>();
        moduleRules.put("User", "userName in ('admin')");

        StringBuilder sqlFilter = new StringBuilder();
        sqlFilter.append(" (");

        for (String ruleSql :
                moduleRules.values()) {
            sqlFilter.append(ruleSql);
        }

        sqlFilter.append(")");

        if (sqlFilter.toString().trim().equals("()")) {
            return null;
        }

        return sqlFilter.toString();
    }
}
