package com.newt.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {

  /**
   * 密码加密
   * 
   * @param uid
   * @param password
   */
  public static String encryptPassword(String uid, String password) {
    return DigestUtils.md5Hex(DigestUtils.md5Hex(uid + password).toUpperCase()).toUpperCase();
  }

}
