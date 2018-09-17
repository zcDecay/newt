package com.newt.utils.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Token
 * @Author zcc
 * @Date 18/09/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenObject {

    private String userId;

    private String phone;

    private String pickName;

}
