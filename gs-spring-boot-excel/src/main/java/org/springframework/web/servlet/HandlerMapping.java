package org.springframework.web.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Pattern;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/28
 */
@Data
@AllArgsConstructor
public class HandlerMapping {
    HandlerExecutionChain handler;
    Pattern pattern;
}
