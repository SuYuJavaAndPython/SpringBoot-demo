//Groovy 会根据对象的值来判断它的类型
/**
 * Grab是一个内嵌在Groovy里的Jar包依赖管理器。Grab让你可以快速添加maven仓库依赖到你的classpath
 * 里，使脚本运行更加简单。最简单的一种用法是只需要在你的脚本里添加一个注解 支持以下两种方式导入依赖:
 *      @Grab(group='org. springframework', module='spring-orm', version='3.2.5.RELEASE')
 *      @Grab('org.springframework:spring-orm:3.2.5.RELEASE')
 * cli的几个命令：
 *      spring --version 查看cli版本
 *      spring run HelloCli.groovy 运行groovy程序
 *      spring jar my-app（自己取的名字）.jar HelloCli.groovy 将groovy程序打成jar包
 * jar包执行命令：
 *      java -jar my-app.jar
 * 补充知识：客户提出功能 <----> 我们拿到形成需求：
 *                                  1.设计  2.编码  3.测试  4.上线  5.维护（监控，通过日志and so on）
 * springboot四大神器：
 *      1.自动配置
 *      2.starter
 *      3.CLI
 *      4.Actuator
 */
def value = "groovy"
value = 123
println(value)
println(value.class)