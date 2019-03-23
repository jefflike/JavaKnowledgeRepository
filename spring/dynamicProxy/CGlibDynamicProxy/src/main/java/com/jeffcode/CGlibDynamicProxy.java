package com.jeffcode;

import com.jeffcode.entity.HouseAgency;
import com.jeffcode.entity.Jefflike;
import org.junit.Test;

/**
 * @Author: jefflike
 * @create: 2019/3/24
 * @describe:
 */
public class CGlibDynamicProxy {
    @Test
    public void TestProxy() {
        HouseAgency houseAgency = new HouseAgency();
        // 注意此处必须强转成People，无法直接转成jefflike类
        Jefflike jeffProxy = (Jefflike) houseAgency.getInstance(Jefflike.class);

        // 此时会调用invoke方法
        jeffProxy.setName("Jefflike");
        jeffProxy.findHouse();

    }

}
