package com.tom.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import java.util.Objects;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月13日 5:17
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    private static final String X_VERSION = "X-VERSION";
    private final String version ;

    public ApiVersionCondition(String version) {
        this.version = version;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVersionCondition(other.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        String headerVersion = httpServletRequest.getHeader(X_VERSION);
        if(Objects.equals(version,headerVersion)){
            return this;
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return 0;
    }
    public String getApiVersion() {
        return version;
    }

}