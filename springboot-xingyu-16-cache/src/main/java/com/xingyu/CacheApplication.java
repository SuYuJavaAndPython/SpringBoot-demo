package com.xingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

    /**
     * 缓存：
     * 缓存技术，用来存储不经常改变的数据，以提高系统性能和增加系统吞吐量。
     * 缓存有三大重要因素：命中率、缓存更新策略、缓存最大数据量。
     * 1 缓存命中率=当前缓存命中的总量/总查询量(命中的量和未命中的量) （期望85%）
     * 2 更新策略（除了随着数据更新而更新，当缓存存满时的处理方式）
     * 1）FIFO，最先记录缓存的最先被清理。
     * 2）LFU，最少使用的元素被清理。
     * 3）LRU，最近最少使用的元素被清理。
     * 3 最大数据量指缓存中能处理元素的最大个数或使用的最大存储空间。
     * 超过最大数据量，根据更新策略清除数据
     *
     * Spring缓存
     * Spring Cache，是一种基于注解的缓存技术，本质上不是缓存的实现方案，而是对缓存使用的抽象。
     * 既提供了基于内存实现的缓存管理器，可以用于单体应用系统，也集成了 EhCache、Redis 等缓存
     * 服务器，可以用于大型系统或者分布式系统。
     * 通过@EnableCaching注解自动化配置合适的缓存管理器（CacheManager），
     * Spring Boot根据下面的顺序去侦测缓存提供者：
     *  Generic     JCache ( JSR-107)   EhCache 2.x    Hazelcast    Infinispan
     *  Redis      Guava      Simple
     * 对应配置为：
     * spring.cache.type=SIMPLE(默认)
     *
     * 在 Spring 管理的 Bean 中使用缓存注解，通常放在 Ser v i ce 类上。 @CacheConfig，在类上设置当前缓存的一些公共设置，比如缓存名称；
     * @Cacheable 作用在方法上，触发缓存读取操作。表明该方法的结果是可以缓存的，如果缓存存在，则目
     * 标方法不会被调用，直接取出缓存。可以为方法声明多个缓存，如果至少有一个缓存有缓存项，则其缓存项将
     * 被返回；
     * @CacheEvict 作用在方法上，触发缓存失效操作，删除缓存项或者清空缓存；属性allEntries是boolean
     * 类型，表示是否需要清除缓存中的所有元素，默认为false。用beforeInvocation可以改变触发清除操作的时
     * 间，为true时，Spring会在调用该方法之前清除缓存中的指定元素
     * @CachePut 作用在方法上，触发缓存更新操作，添加该注解后总是会执行方法体，并且使用返回的结果更
     * 新缓存，同 Cacheable 一样，支持 condition、unless、key 选项，也支持 KeyGenerator；
     * @Caching 作用在方法上，综合上面的各种操作，在有些场景上，调用业务会触发多种缓存操作。
     * @Caching 集成@Cacheable @CachePut @CacheEvict
     * 注意，直接使用 SpEL 表达式来指定缓存项的 Key 比自定义一个 KeyGenerator 更为简单。
     *
     * 内容看com.xingyu.service.impl.GuestServiceImpl;
     * 注意：对于select语句，若没有查询到符合的数据，那么返回值为null
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

}
