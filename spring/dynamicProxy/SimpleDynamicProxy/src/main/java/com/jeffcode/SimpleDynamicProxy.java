package com.jeffcode;

import com.jeffcode.entity.HouseAgency;
import com.jeffcode.entity.Jefflike;
import com.jeffcode.entity.People;
import org.junit.Test;

/**
 * @Author: Jefflike
 * @create: 2019/3/21
 * @describe:
 * 测试类
 */
public class SimpleDynamicProxy {
    @Test
    public void TestProxy() {
        HouseAgency houseAgency = new HouseAgency();
        // 注意此处必须强转成People，无法直接转成jefflike类
        People jeffProxy = (People) houseAgency.getInstance(new Jefflike("jefflike"));
        // 此时会调用invoke方法
        jeffProxy.findHouse();

        People xixiProxy = (People) houseAgency.getInstance(new Jefflike("fastXixi"));
        // 此时会调用invoke方法
        xixiProxy.findHouse();
    }

}
