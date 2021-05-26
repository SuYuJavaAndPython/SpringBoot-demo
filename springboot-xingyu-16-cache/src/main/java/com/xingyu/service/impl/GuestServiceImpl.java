package com.xingyu.service.impl;

import com.xingyu.bean.Guest;
import com.xingyu.dao.GuestDao;
import com.xingyu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 当方法过多且设置缓存过多cacheNames = "guest"就会过多
 * @CacheConfig(cacheNames = "guest")就能省略该类下方法上缓存的cacheNames = "guest"
 */
@CacheConfig(cacheNames = "guest")
@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestDao guestDao;

    public List<Guest> list() {
        return guestDao.list();
    }

    /**
     * @Cacheable
     * 1.value@AliasFor("cacheNames") 缓存的名称，在 spring 配置文件中定义，必须指定至少一个
     * 2.key 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数值进行组合
     * 3.condition 缓存的条件，可以为空，使用SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存
     * 4.unless 缓存的条件，可以为空，使用SpEL 编写，返回 true 或者 false，只有为 false 才进行缓存
     * @param id
     * @return
     */
    @Cacheable(/*cacheNames = "guest", */key = "#id"/*, condition = "#id>1"*/)
    public Guest selectOne(Integer id) {
        System.out.println("查询第"+id+"位嘉宾");
        return guestDao.selectOne(id);
    }

    /**
     * @CachePut
     * 将方法的返回值放入缓存中，此时的返回值就不能是void 或 int
     * 设置key的值与@Cacheable的key值保持一致：
     *      方法一.  #guest.id       guest为参数
     *      方法二.  #result.id      result代表返回值
     * 注：上面的@Cacheable中的key值id为3但类型为Integer
     *     下面的@CachePut中的key值id为3但类型为Long
     *     两者值一致但类型不一致，导致存入了不同的缓存中
     *     （更正：已将Guest类中的属性id类型修改为Integer）
     * @param guest
     * @return
     */
    @CachePut(/*cacheNames = "guest", */key = "#guest.id")
    public Guest updateGuest(Guest guest) {
        System.out.println("更新第"+guest.getId()+"位嘉宾");
        guestDao.updateGuest(guest);
        return guest;
    }

    /**
     * @CacheEvict
     * 删除该缓存所对应的id的信息
     * @param id
     */
    @CacheEvict(/*cacheNames = "guest", */key = "#id")
    public void deleteGuest(Integer id) {
        System.out.println("删除第"+id+"位嘉宾");
        guestDao.deleteGuest(id);
    }

    /**
     * allEntries默认为false（true开启删除该缓存下的所有信息）
     * beforeInvocation默认为false（为true时，Spring会在调用该方法之前清除缓存中的指定元素）
     * （为false时若在方法结束前方法报错，则方法未成功结束，即不会执行缓存删除操作）
     */
    @CacheEvict(/*cacheNames = "guest", */allEntries = true, beforeInvocation = true)
    public void deleteAllGuest() {
        System.out.println("删除所有嘉宾");
        guestDao.deleteAllGuest();
        int end = 1/0;
    }

}
