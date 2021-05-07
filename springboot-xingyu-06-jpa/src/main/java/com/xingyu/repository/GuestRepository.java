package com.xingyu.repository;

import com.xingyu.bean.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Repository注解用于dao层接口上   映射 一个数据库
 * 要证明我们写的GuestRepository是一个Repository，继承或实现JpaRepository，通过泛型匹配实体类
 * <Guest,Long> 前者为对应的实体类，后者为对应的主键类型    这样一来GuestRepository跟以前的GuestDao就差不多了
 * hibernate将单表的一些基本的crud方法已经写好了，不用再自己去写sql了
 * 但对于多表关联复杂的表关系，适合mybatis自己写sql
 * Hibernate: select guest0_.id as id1_0_, guest0_.name as name2_0_, guest0_.role as role3_0_ from guest guest0_
 */
public interface GuestRepository extends JpaRepository<Guest,Long> {
}
