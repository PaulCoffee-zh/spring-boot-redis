package com.akcomejf.cube.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import com.akcomejf.cube.service.SecurityMetadataSourceService;
import com.akcomejf.uranus.dto.ResourceDTO;
import com.akcomejf.uranus.dto.RoleDTO;
import com.akcomejf.uranus.service.ResourceApiService;
import com.akcomejf.uranus.service.RoleApiService;

/**
 * Created by SDD on 2016/12/6.
 */
@Service
public class SecurityMetadataSourceServiceImpl implements SecurityMetadataSourceService {

    @Autowired
    private RoleApiService roleService;
    @Autowired
    private ResourceApiService resourceService;

    private final String CACHE_NAME = "resourceAndRoleRelation";

    /**
     * 加载所有角色与权限的关系
     * @return
     */
    @Cacheable(value = CACHE_NAME)
    @Override
    public Map<String, Collection<ConfigAttribute>> loadResourceAndRoleRelation(){
        Map<String, Collection<ConfigAttribute>> relationMap = new HashMap<String, Collection<ConfigAttribute>>();
        // 查出所有角色
        List<RoleDTO> roles = roleService.getAll();
        if (roles != null) {
            for (RoleDTO role : roles) {
                // 查出某个角色可以访问的资源
                List<ResourceDTO> resources = resourceService.getByRoleId(role.getId());
                if (resources != null) {
                    for (ResourceDTO resource : resources) {
                        Collection<ConfigAttribute> configAttributes = null;
                        ConfigAttribute configAttribute = new SecurityConfig(role.getCode());
                        if (relationMap.containsKey(resource.getResourceContent())) {
                            configAttributes = relationMap.get(resource.getResourceContent());
                            configAttributes.add(configAttribute);
                        } else {
                            configAttributes = new ArrayList<>();
                            configAttributes.add(configAttribute);
                            relationMap.put(resource.getResourceContent(), configAttributes);
                        }
                    }
                }
            }
        }

        return relationMap;
    }

}
