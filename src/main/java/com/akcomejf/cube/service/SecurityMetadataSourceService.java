package com.akcomejf.cube.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

/**
 * Created by SDD on 2016/12/6.
 */
public interface SecurityMetadataSourceService {

    /**
     * 加载所有角色与权限的关系
     * @return
     */
    Map<String, Collection<ConfigAttribute>> loadResourceAndRoleRelation();
}
