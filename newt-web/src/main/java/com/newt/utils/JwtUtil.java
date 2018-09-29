

package com.newt.utils;

import com.newt.pojo.partial.User;
import com.newt.pojo.vo.UserVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import java.util.ArrayList;
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
	public static String generateToken(User r) {
		return generateToken(r, JwtUtil.JWT_TTL);
	}

	/**
	 * 根据接收对象生成TOKEN,并指定有效时间
	 *
	 * @param user
	 * @param ttlMillis
	 * @return
	 */
	public static String generateToken(User user, long ttlMillis) {
		long nowMillis = System.currentTimeMillis();
//		Claims claims = Jwts.claims().setSubject(user.getShopId()).setIssuedAt(new Date(nowMillis));
//		claims.put("UserVo", JsonUtil.objectToJson(user));
//		JwtBuilder builder = Jwts.builder().setId(id).setClaims(claims).signWith(SignatureAlgorithm.HS512, secret);
//		if (ttlMillis >= 0) {
//			long expMillis = nowMillis + ttlMillis;
//			Date exp = new Date(expMillis);
//			builder.setExpiration(exp);
//		}
//		return builder.compact();
        return "";
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
//			r.setShopId(body.getSubject());
			if (body.get("UserVo") != null) {
				r = JsonUtil.jsonToPojo(body.get("UserVo").toString(), UserVo.class);
			}
			/*
			r.setUserId((String) body.get("userId"));
			r.setBizCenterId((String) body.get("bizCenterId"));
			r.setCompanyName((String) body.get("companyName"));
			*/
			// TODO
			List<String> roles = new ArrayList<>();
			roles.add("admin");
			// r.setRoles(roles);
			return r;
		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}
}
