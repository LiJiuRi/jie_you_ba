package com.lixu.jie_you_ba.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lixu.jie_you_ba.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

	/**
	 * 创建token，自定义的Claim为person_id
	 * 
	 * @param person_id
	 * @return
	 * @throws JWTCreationException
	 */
	@Override
	public String create(String person_id) throws JWTCreationException {
		String token = null;
		// 自定义的claim为person_id
		try {
			Algorithm algorithm = Algorithm.HMAC256("14-602");
			token = JWT.create().withClaim("person_id", person_id).sign(algorithm);
		} catch (JWTCreationException exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
			// 考虑给前端的状态码
		}
		return token;
	}

	/**
	 * 验证前端提交的token 使用场景：需要验证用户身份，获取用户person_id的时候
	 * 
	 * @param token
	 * @return 验证失败返回null，验证成功返回person_id
	 * @throws JWTVerificationException
	 */
	@Override
	public String getPersonId(String token) throws JWTVerificationException {
		String person_id = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256("14-602");
			JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token);
			Map<String, Claim> claim = jwt.getClaims();
			person_id = claim.get("person_id").asString();
		} catch (JWTVerificationException exception) {
			// Invalid signature/claims
		}
		return person_id;
	}
}
