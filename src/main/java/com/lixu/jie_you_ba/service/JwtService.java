package com.lixu.jie_you_ba.service;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

public interface JwtService {
	
	/**
	 * 创建token，自定义的Claim为person_id
	 * 使用场景：用户登录后，返回token，前端保存token
	 * @param person_id
	 * @return
	 * @throws JWTCreationException
	 */
	String create(String person_id) throws JWTCreationException;
	
	/**
	 * 验证前端提交的token
	 * 使用场景：需要验证用户身份，获取用户person_id的时候
	 * @param token
	 * @return 验证失败返回null，验证成功返回person_id
	 * @throws JWTVerificationException
	 */
	String getPersonId(String token) throws JWTVerificationException;
}
