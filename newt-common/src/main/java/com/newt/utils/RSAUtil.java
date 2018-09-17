package com.newt.utils;


import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <p>Title: RSAUtils </p>
 * <p>Description: RSA加密工具类</p>
 * <p>Company: 康宁益生医药科技有限公司 </p>
 * @author mz
 * 时间: 2018-03-08 13:51:30
 *
 */
public class RSAUtil {

	/**
	* 加密算法RSA
	*/
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * 获取公钥的key
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * 获取私钥的key
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	private static final String CHARSET = "UTF-8";

	/**
	 * 生成密钥对
	 *
	 * 2018-03-08 13:52:58
	 * @author mz
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> genKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	/**
	 * 公钥加密
	 *
	 * 2018-03-08 14:57:42
	 * @author mz
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data, String publicKey) throws Exception {
		String base64Data = Base64.getEncoder().encodeToString(data.getBytes(CHARSET));
		byte[] keyBytes = Base64.getDecoder().decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		// 加密数据长度 <= 模长（模长为最大加密字节除以8）-11
		String[] datas = splitString(base64Data, MAX_ENCRYPT_BLOCK);
		String encrypt = "";
		// 如果明文长度大于模长-11则要分组加密
		for (String s : datas) {
			encrypt += bcd2Str(cipher.doFinal(s.getBytes(CHARSET)));
		}
		return encrypt;
	}

	/**
	 * 私钥加密
	 *
	 * 2018-03-08 14:57:42
	 * @author mz
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPrivateKey(String data, String privateKey) throws Exception {
		String base64Data = Base64.getEncoder().encodeToString(data.getBytes(CHARSET));
		byte[] keyBytes = Base64.getDecoder().decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		// 加密数据长度 <= 模长（模长为最大加密字节除以8）-11
		String[] datas = splitString(base64Data, MAX_ENCRYPT_BLOCK);
		String encrypt = "";
		// 如果明文长度大于模长-11则要分组加密
		for (String s : datas) {
			encrypt += bcd2Str(cipher.doFinal(s.getBytes(CHARSET)));
		}
		return encrypt;
	}

	/**
	 * 公钥解密
	 *
	 * 2018-03-08 16:58:21
	 * @author mz
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPublicKey(String data, String publicKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		byte[] bcd = ASCII_To_BCD(data.getBytes(CHARSET));
		// 如果密文长度大于模长则要分组解密
		String decrypt = "";
		byte[][] arrays = splitArray(bcd, MAX_DECRYPT_BLOCK);
		for (byte[] arr : arrays) {
			decrypt += new String(cipher.doFinal(arr));
		}
		byte[] decode = Base64.getDecoder().decode(decrypt.getBytes(CHARSET));
		return new String(decode, CHARSET);
	}

	/**
	 * 私钥解密
	 *
	 * 2018-03-08 15:03:18
	 * @author mz
	 * @param encryptedData
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		byte[] bcd = ASCII_To_BCD(data.getBytes(CHARSET));
		// 如果密文长度大于模长则要分组解密
		String decrypt = "";
		byte[][] arrays = splitArray(bcd, MAX_DECRYPT_BLOCK);
		for (byte[] arr : arrays) {
			decrypt += new String(cipher.doFinal(arr));
		}
		byte[] decode = Base64.getDecoder().decode(decrypt.getBytes(CHARSET));
		return new String(decode, CHARSET);
	}

  /**
   * 私钥解密
   *
   * @param data
   * @param privateKey
   * @return
   * @throws Exception
   */
  public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey)
    throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    //模长
    int key_len = privateKey.getModulus().bitLength() / 8;
    byte[] bytes = Base64.getDecoder().decode(data.getBytes("UTF-8"));

    //如果密文长度大于模长则要分组解密
    String ming = "";
    byte[][] arrays = splitArray(bytes, key_len);
    for (byte[] arr : arrays) {
      ming += new String(cipher.doFinal(arr),"utf-8");
    }
    return ming;
  }
	/**
	 *  私钥签名
	 *
	 * 2018-03-19 09:59:36
	 * @author mz
	 * @param data 待签名数据
	 * @param privateKey 私钥
	 * @return
	 * @throws Exception
	 */
	public static String sign(String data, String privateKey) throws Exception {
		// 解密由base64编码的私钥
		byte[] keyBytes = Base64.getDecoder().decode(privateKey);
		// 构造PKCS8EncodedKeySpec对象
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 取私钥对象
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);

		// 用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		// 将待签名数据base64编码
		String base64Data = Base64.getEncoder().encodeToString(data.getBytes(CHARSET));
		signature.update(base64Data.getBytes(CHARSET));
		byte[] sign = signature.sign();
		// 签名结果转换为BCD编码
		return bcd2Str(sign);
	}

	/**
	 * 验证签名
	 *
	 * @param data
	 * @param publicKey
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(String data, String publicKey, String sign) throws Exception {
		// 解密由base64编码的公钥
		byte[] keyBytes = Base64.getDecoder().decode(publicKey);
		// 构造X509EncodedKeySpec对象
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 取公钥对象
		PublicKey pubKey = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);

		// 将待验证数据base64编码
		byte[] base64Data = Base64.getEncoder().encode(data.getBytes(CHARSET));
		signature.update(base64Data);
		// 将签名转换为ASCII码
		byte[] ascii = ASCII_To_BCD(sign.getBytes(CHARSET));
		// 验证签名是否有效
		return signature.verify(ascii);
	}

	/**
	* ASCII码转BCD码
	*
	*/
	public static byte[] ASCII_To_BCD(byte[] ascii) {
		int asc_len = ascii.length;
		byte[] bcd = new byte[asc_len / 2];
		int j = 0;
		for (int i = 0; i < (asc_len + 1) / 2; i++) {
			bcd[i] = asc_to_bcd(ascii[j++]);
			bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
		}
		return bcd;
	}

	public static byte asc_to_bcd(byte asc) {
		byte bcd;
		if ((asc >= '0') && (asc <= '9'))
			bcd = (byte) (asc - '0');
		else if ((asc >= 'A') && (asc <= 'F'))
			bcd = (byte) (asc - 'A' + 10);
		else if ((asc >= 'a') && (asc <= 'f'))
			bcd = (byte) (asc - 'a' + 10);
		else
			bcd = (byte) (asc - 48);
		return bcd;
	}

	/**
	 * BCD转字符串
	 */
	public static String bcd2Str(byte[] bytes) {
		char temp[] = new char[bytes.length * 2], val;
		for (int i = 0; i < bytes.length; i++) {
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}

	/**
	* 拆分字符串
	*/
	public static String[] splitString(String string, int len) {
		int x = string.length() / len;
		int y = string.length() % len;
		if (y != 0) {
			x++;
		}
		String[] strings = new String[x];
		String str = "";
		for (int i = 0; i < x; i++) {
			if (i == x - 1 && y != 0) {
				str = string.substring(i * len, i * len + y);
			} else {
				str = string.substring(i * len, i * len + len);
			}
			strings[i] = str;
		}
		return strings;
	}

	/**
	 *拆分数组
	 */
	public static byte[][] splitArray(byte[] data, int len) {
		int x = data.length / len;
		int y = data.length % len;
		if (y != 0) {
			x++;
		}
		byte[][] arrays = new byte[x][];
		byte[] arr;
		for (int i = 0; i < x; i++) {
			arr = new byte[len];
			if (i == x - 1 && y != 0) {
				System.arraycopy(data, i * len, arr, 0, y);
			} else {
				System.arraycopy(data, i * len, arr, 0, len);
			}
			arrays[i] = arr;
		}
		return arrays;
	}

	public static void main(String[] args) throws Exception {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8ib8bEiPzU8rMRvKMBO+b5glZhVDnKmQV63vSAf+UUPv0t+XvwWWt7o1/z5Wem/up7qpW+CppZA5ZUFjlDcRhPYESpXpnT3HJ3XMhJjkJcCdnTyiEUM+koaXKPRz20NScAJMsoDp9BQWY0Zc3KPvzKl7ggMPSB12GKujO//QDBQIDAQAB";
		String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALyJvxsSI/NTysxG8owE75vmCVmFUOcqZBXre9IB/5RQ+/S35e/BZa3ujX/PlZ6b+6nuqlb4KmlkDllQWOUNxGE9gRKlemdPccndcyEmOQlwJ2dPKIRQz6Shpco9HPbQ1JwAkyygOn0FBZjRlzco+/MqXuCAw9IHXYYq6M7/9AMFAgMBAAECgYEAiS2gQs4cIjthXuhwKbidrkzdmKkLiGark9dWrCKQFxYlfJUhVCTfGoJrqgcb0d+kaKwifEzsbupCFnIDfAVcUDRy6T47v4kECqxBHeOdpwlSCLk/0YDCW/fvgD3jQxlaAn66lKbh1qrRZ5QiuCG5yPMPVTn6SSC7rTjAyxsK67ECQQDfxukVZkMb+YvemY5O0cLyvT0+XAeYVkBAtvPrpr+fnpbTj6EWnzQInpfH+7Lc4VedGQr87WTrFXvy8ml4VDY3AkEA16/S7X0DryqR38bxinvE+0AxF3l5AJvE6qcyVHMNsyYFuu82O2zetD84U55UGwugGZZG2fmrx2i2w/z9dtdyowJAdMze1gOVXaGoBt0BcVR9O7PYppbkg/fo+55CvKpBdLATK4PZYfRg9WrJ8GEI389iqqXqnU/PkACbvJgYwuy5iwJACmL5MV6X0tOl+rTF5PlY3xCUTKEY5qKZtQMgNVjlC/+Evx/N6MaxYtS4ja5ONo80woauGskfMJcmVgHU4ug1KQJASvzDDAr+rv8jf6QB2WInDf2vLaDqa9QA1+UfEOngi4xY5zpybd5+QG/V6fT/iN5ADoo8gSFX3u2Nt7ZcYganeg==";

		// String data = "{code:json,name:json21sagjkf";
		// String result = encryptByPublicKey(data, publicKey);
		// System.out.println(result);
		// String json = decryptByPrivateKey(result, privateKey);
		// System.out.println(json);

		// String result2 = encryptByPrivateKey(data, privateKey);
		// System.out.println(result2);
		// String s =
		// "5CF49382F3B226C3325A281FBACEABA1D8BC2F2CA983D2A3498653500C05BF5AD79A85BEAC060CFC8F8A670DF1A7ABEE363E9FC9F688E387A155B25CDCEB1BF99C16798737F666CB9818EC8EF2C807E2909BF4060DC1E59FEBB1A607A2A53A6C6150AD3F11488361053C9AA9F3268CAFC51225A6F0D4BD9200BC442C33B05EFA";
		// String json2 = decryptByPublicKey(s, publicKey);
		// System.out.println("公钥解密后的结果：" + json2);
		// Map<String, Object> genKeyPair = genKeyPair();
		// RSAPublicKey object = (RSAPublicKey)genKeyPair.get(PUBLIC_KEY);
		// System.out.println(object.getModulus().bitLength() / 8 -11);

		// for (int i = 0; i < 9; i++) {
		// System.out.println(IDUtils.getUUID());
		// }
		String data = "更深邃的规划dsj";
//		data = "0A07AF7FFDAEDCE13A2C266E700384E56E27199EBF3D3D4E4E74E1633A0A42A474AB25D95E62E90C9DF912D7B39801F692EEE69E4DE62B8DDF5ACD6A09A49B0444347042B163EDD021FF3ED022757C7B9F9D41F906525F016CCB3654C6FDCB29E8ECD2F98E29A42C971F143BE7624E2C4598EE445377D76C1169C4FD25F2D5415E749F0F49EA2EFD73B875F4332C3861C4D3AB4CEF43C7FD1C156E9097C50059EC32A85528F97FB11B00245A7A2C13043874C24C4C617065A27FE8EEA7ED82512E7011879CC8BCED68EEE743062D37F2467E66ECFA569C54136DA66BFA0E66D4826DFB80D62A959E1A801CB486682325E84BE9A5B2C3EA455728814134B5A6C16C1AEFC2AAD578299703DB959FD7D476188105738B2F2684F9D73C4DFFA9AA784FA5EFF40425FD5694B65A0D272BC7CF493B35616D79648028768B6A574F64078A5275BD3A73739CA2FA286DB95201657F0CCABA9F09F98E668CDCCD665B8A49016A9BDFC70187D604018428E2BFFA2B4B47637416BAD11EE249DF2214460D91";
		String sign = sign(data, privateKey);
//		sign = "ntdUnLDlobN3YyB9q6Tj0hkPxVIq3UuhuQ4rILsouHL+OkL9SXPQM5EQIMEnjLhLaTOeceX7Q4BsQNImhC4YO6JDJq1WIM03CHq9Bwp+ZjrCLBeaJpmyoA+V6ecKMjqhrI4fKV6kZ1ReXSl7+Sy3zmtz2rnUr8Ng46HNWahoE4o=";
		System.out.println(sign);
		System.out.println(verify(data, publicKey, sign));

//		Map<String, String> map = new HashMap<>();
//		map.put("billId", "3718022710332523901");
//		map.put("payWay", "wechat");
//		map.put("payNo", "3718032010212498901");
//		map.put("payTime", DateUtil.format(new Date(), DateUtil.YYYYMMDDHHMMSS));
//		map.put("payAmount", "6.40");
//		String json = JSONObject.toJSONString(map);
//		String data_rsa = RSAUtils.encryptByPublicKey(json, publicKey);
//		Map<String, String> reqData = new HashMap<>();
//		reqData.put("data_rsa", data_rsa);
//		String result = PaymentUtil.sendRequest("http://192.168.1.59:8080/gy-web-portal/payment/returnOrder", reqData);
//		System.out.println(result);
	}

  /**
   * 从字符串中加载私钥<br>
   * 加载时使用的是PKCS8EncodedKeySpec（PKCS#8编码的Key指令）。
   *
   * @param privateKeyStr
   * @return
   * @throws Exception
   */
  public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
    try {
      byte[] buffer = Base64Utils.decode(privateKeyStr.getBytes());
      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    } catch (NoSuchAlgorithmException e) {
      throw new Exception("无此算法");
    } catch (InvalidKeySpecException e) {
      throw new Exception("私钥非法");
    } catch (NullPointerException e) {
      throw new Exception("私钥数据为空");
    }

  }
}
