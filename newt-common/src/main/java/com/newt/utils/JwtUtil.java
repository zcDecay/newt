

package com.newt.utils;

import com.alibaba.fastjson.JSON;
import com.newt.utils.pojo.TokenObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

	public static Claims parseJWT(String jsonWebToken, String base64Security) {
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
					.parseClaimsJws(jsonWebToken).getBody();
			return claims;
		} catch (Exception ex) {
			return null;
		}
	}

	// 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
	public static String createJWT(TokenObject tokenObject, long TTLMillis, String base64Security) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		// 生成签名密钥 就是一个base64加密后的字符串？
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setIssuedAt(now) // 创建时间
				.setSubject(JSON.toJSONString(tokenObject)) // 主题，也差不多是个人的一些信息
				/*
				 * .setIssuer(issuer) // 发送谁 .setAudience(audience) // 个人签名
				 */ .signWith(signatureAlgorithm, signingKey); // 估计是第三段密钥
		// 添加Token过期时间
		if (TTLMillis >= 0) {
			// 过期时间
			long expMillis = nowMillis + TTLMillis;
			// 现在是什么时间
			Date exp = new Date(expMillis);
			// 系统时间之前的token都是不可以被承认的
			builder.setExpiration(exp).setNotBefore(now);
		}
		// 生成JWT
		return builder.compact();
	}
}
