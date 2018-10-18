

package com.newt.utils;

import com.newt.pojo.vo.UserVo;
import io.jsonwebtoken.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JwtUtil {

	// key
	private static final String secret = "newt";
	// jwt builder ID
	private static final String id = "newt_jwt";
	// millisecond
	public static final long JWT_TTL = 60 * 60 * 1000 * 30;
	public static final long JWT_REFRESH_INTERVAL = 55 * 60 * 1000;
	public static final long JWT_REFRESH_TTL = 12 * 60 * 60 * 1000;

	/**
	 * 根据接收到的信息生成TOKEN
	 *
	 * @param r
	 * @return
	 */
	public static String generateToken(UserVo r) {
		return generateToken(r, JwtUtil.JWT_TTL);
	}

	/**
	 * 根据接收对象生成TOKEN,并指定有效时间
	 *
	 * @param user
	 * @param ttlMillis
	 * @return
	 */
	public static String generateToken(UserVo user, long ttlMillis) {
		long nowMillis = System.currentTimeMillis();
		Claims claims = Jwts.claims().setSubject(String.valueOf(user.getId())).setIssuedAt(DateTimeUtil.nowTimeStamp());
		claims.put("user", JsonUtil.objectToJson(user));
		JwtBuilder builder = Jwts.builder().setId(id).setClaims(claims).signWith(SignatureAlgorithm.HS512, secret);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * 验证TOKEN并返回解析后的对象
	 *
	 * @param token
	 * @return
	 */
	public static UserVo parseToken(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			UserVo r = new UserVo();
			r.setId(Integer.getInteger(body.getSubject()));
			if (body.get("user") != null) {
				r = JsonUtil.jsonToPojo(body.get("user").toString(), UserVo.class);
			}
			List<String> roles = new ArrayList<>();
			roles.add("admin");
			return r;
		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}
}
