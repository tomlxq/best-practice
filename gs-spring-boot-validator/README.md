# Bean Validation

Java 2009 年就提出了 Bean Validation 规范，并且已经历经 JSR303、JSR349、JSR380 三次标准的置顶，发展到了 2.0 

目前实现 Bean Validation 规范的数据校验框架，主要有：

Hibernate Validator
Apache BVal
# 注解
## 2.1 空和非空检查
* @NotBlank ：只能用于字符串不为 null ，并且字符串 #trim() 以后 length 要大于 0 。
* @NotEmpty ：集合对象的元素不为 0 ，即集合不为空，也可以用于字符串不为 null 。
* @NotNull ：不能为 null 。
* @Null ：必须为 null 。

## 2.2 数值检查

* @DecimalMax(value) ：被注释的元素必须是一个数字，其值必须小于等于指定的最大值。
* @DecimalMin(value) ：被注释的元素必须是一个数字，其值必须大于等于指定的最小值。
* @Digits(integer, fraction) ：被注释的元素必须是一个数字，其值必须在可接受的范围内。
* @Positive ：判断正数。
* @PositiveOrZero ：判断正数或 0 。
* @Max(value) ：该字段的值只能小于或等于该值。
* @Min(value) ：该字段的值只能大于或等于该值。- @Negative ：判断负数。
* @NegativeOrZero ：判断负数或 0 。

## 2.3 Boolean 值检查

* @AssertFalse ：被注释的元素必须为 true 。
* @AssertTrue ：被注释的元素必须为 false 。

## 2.4 长度检查
* @Size(max, min) ：检查该字段的 size 是否在 min 和 max 之间，可以是字符串、数组、集合、Map 等。

## 2.5 日期检查

* @Future ：被注释的元素必须是一个将来的日期。
* @FutureOrPresent ：判断日期是否是将来或现在日期。
* @Past ：检查该字段的日期是在过去。
* @PastOrPresent ：判断日期是否是过去或现在日期。

## 2.6 其它检查

* @Email ：被注释的元素必须是电子邮箱地址。
* @Pattern(value) ：被注释的元素必须符合指定的正则表达式。

## 2.7 Hibernate Validator 附加的约束注解

org.hibernate.validator.constraints 包下，定义了一系列的约束( constraint )注解。如下：

* @Range(min=, max=) ：被注释的元素必须在合适的范围内。
* @Length(min=, max=) ：被注释的字符串的大小必须在指定的范围内。
* @URL(protocol=,host=,port=,regexp=,flags=) ：被注释的字符串必须是一个有效的 URL 。
* @SafeHtml ：判断提交的 HTML 是否安全。例如说，不能包含 javascript 脚本等等。

## 2.8 @Valid 和 @Validated

* @Valid 注解，是 Bean Validation 所定义，可以添加在普通方法、构造方法、方法参数、方法返回、成员变量上，表示它们需要进行约束校验。
* @Validated 注解，是 Spring Validation 锁定义，可以添加在类、方法参数、普通方法上，表示它们需要进行约束校验。同时，@Validated 有 value 属性，支持分组校验。

> @Valid（javax.validation包下） 和 @Validated （org.springframework.validation.annotation包下）注解。两者大致有以下的区别：

|名称|	spring Validation是否实现了声明式校验	|是否支持嵌套校验|	是否支持分组校验|
| -- | -- | -- | -- |
|@Validated|	是|	否|	是|
|@Valid|	否|	是|	否|
|@Valid| 有嵌套对象校验功能|