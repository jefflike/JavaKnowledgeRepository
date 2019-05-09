package com.jeff_code.estudy.bean;

import lombok.*;
import lombok.experimental.Accessors;


/**
 * @Author: jefflike
 * @create: 2018/10/23
 * @describe:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TestLombok {
    private @NonNull Integer id;
    private String name;
}
