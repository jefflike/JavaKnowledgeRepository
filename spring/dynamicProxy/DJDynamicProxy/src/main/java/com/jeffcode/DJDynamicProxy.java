package com.jeffcode;

import com.jeffcode.entity.HouseAgency;
import com.jeffcode.entity.Jefflike;
import com.jeffcode.entity.People;
import org.junit.Test;

/**
 * @Author: jefflike
 * @create: 2019/3/23
 * @describe:
 * 测试类
 */
public class DJDynamicProxy {
    @Test
    public void TestProxy() {
        // 这个是我自己的动态代理对象（实现的是我自己的的DJInvocationHandler）
        HouseAgency houseAgency = new HouseAgency();
        // 注意此处必须强转成People，无法直接转成jefflike类
        People jeffProxy = (People) houseAgency.getInstance(new Jefflike("jefflike"));
        // 此时会调用invoke方法
        jeffProxy.findHouse();
/*        People xixiProxy = (People) houseAgency.getInstance(new Jefflike("fastXixi"));
        // 此时会调用invoke方法
        xixiProxy.findHouse();*/
    }
}
