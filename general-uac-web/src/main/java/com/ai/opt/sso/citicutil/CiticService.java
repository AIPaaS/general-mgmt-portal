package com.ai.opt.sso.citicutil;

public class CiticService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	/**
	 * 加密密码
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public  String entryptPassword(String plainPassword) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public  boolean validatePassword(String plainPassword, String password) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}

	/*@Test
	public  void passwordTest() {
//		String password="112334ddddd";//
		String password="123456";//
		
		String plainPassword=entryptPassword(password);
		System.out.println(plainPassword);
		System.out.println(validatePassword(password,plainPassword));
		Assert.assertEquals(true, validatePassword(password,plainPassword));

	}*/

}
