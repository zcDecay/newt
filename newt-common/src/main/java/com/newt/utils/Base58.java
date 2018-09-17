package com.newt.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

public class Base58 {
	public static final char[] ALPHABET =
			"123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
	private static final int[] INDEXES = new int[128];

	static {
		for (int i = 0; i < INDEXES.length; i++) {
			INDEXES[i] = -1;
		}
		for (int i = 0; i < ALPHABET.length; i++) {
			INDEXES[ALPHABET[i]] = i;
		}
	}

	/**
	 * Encodes the given bytes in base58. No checksum is appended.
	 */
	public static String encode(byte[] input) {
		if (input.length == 0) {
			return "";
		}
		input = copyOfRange(input, 0, input.length);
		// Count leading zeroes.
		int zeroCount = 0;
		while (zeroCount < input.length && input[zeroCount] == 0) {
			++zeroCount;
		}
		// The actual encoding.
		byte[] temp = new byte[input.length * 2];
		int j = temp.length;

		int startAt = zeroCount;
		while (startAt < input.length) {
			byte mod = divmod58(input, startAt);
			if (input[startAt] == 0) {
				++startAt;
			}
			temp[--j] = (byte) ALPHABET[mod];
		}

		// Strip extra '1' if there are some after decoding.
		while (j < temp.length && temp[j] == ALPHABET[0]) {
			++j;
		}
		// Add as many leading '1' as there were leading zeros.
		while (--zeroCount >= 0) {
			temp[--j] = (byte) ALPHABET[0];
		}

		byte[] output = copyOfRange(temp, j, temp.length);
		try {
			return new String(output, "US-ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e); // Cannot happen.
		}
	}

	public static byte[] decode(String input) throws IllegalArgumentException {
		if (input.length() == 0) {
			return new byte[0];
		}
		byte[] input58 = new byte[input.length()];
		// Transform the String to a base58 byte sequence
		for (int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);

			int digit58 = -1;
			if (c >= 0 && c < 128) {
				digit58 = INDEXES[c];
			}
			if (digit58 < 0) {
				throw new IllegalArgumentException("Illegal character " + c + " at " + i);
			}

			input58[i] = (byte) digit58;
		}
		// Count leading zeroes
		int zeroCount = 0;
		while (zeroCount < input58.length && input58[zeroCount] == 0) {
			++zeroCount;
		}
		// The encoding
		byte[] temp = new byte[input.length()];
		int j = temp.length;

		int startAt = zeroCount;
		while (startAt < input58.length) {
			byte mod = divmod256(input58, startAt);
			if (input58[startAt] == 0) {
				++startAt;
			}

			temp[--j] = mod;
		}
		// Do no add extra leading zeroes, move j to first non null byte.
		while (j < temp.length && temp[j] == 0) {
			++j;
		}

		return copyOfRange(temp, j - zeroCount, temp.length);
	}

	public static BigInteger decodeToBigInteger(String input) throws IllegalArgumentException {
		return new BigInteger(1, decode(input));
	}

	//
	// number -> number / 58, returns number % 58
	//
	private static byte divmod58(byte[] number, int startAt) {
		int remainder = 0;
		for (int i = startAt; i < number.length; i++) {
			int digit256 = (int) number[i] & 0xFF;
			int temp = remainder * 256 + digit256;

			number[i] = (byte) (temp / 58);

			remainder = temp % 58;
		}

		return (byte) remainder;
	}

	//
	// number -> number / 256, returns number % 256
	//
	private static byte divmod256(byte[] number58, int startAt) {
		int remainder = 0;
		for (int i = startAt; i < number58.length; i++) {
			int digit58 = (int) number58[i] & 0xFF;
			int temp = remainder * 58 + digit58;

			number58[i] = (byte) (temp / 256);

			remainder = temp % 256;
		}

		return (byte) remainder;
	}

	private static byte[] copyOfRange(byte[] source, int from, int to) {
		byte[] range = new byte[to - from];
		System.arraycopy(source, from, range, 0, range.length);

		return range;
	}


	public static void main(String[] args) throws IOException {
		System.out.println(System.currentTimeMillis());
		System.out.println("9969592094710");

		send("15110130779", "【康宁益生】您的验证码是665544");
	}

	public static void send(String mobile, String content) throws IOException {
		BASE64Encoder encoder = new BASE64Encoder();

		Base64.encodeBase64(content.getBytes("UTF-8"));

		StringBuffer buffer = new StringBuffer();
		buffer.append("userid=600220");
		buffer.append("&pwd=83F9BE8FB50252E1080F4BBE4B15394A");
		buffer.append("&mobile=").append(mobile);
		buffer.append("&msgfmt=UTF8");
		buffer.append("&content=").append(new String(Base64.encodeBase64(content.getBytes("UTF-8"))));
		buffer.append("&encodeType=base64");

		URL url = new URL("http://hy.domsg.net:8090/domsg/smsSend.do");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(10 * 1000);
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		OutputStream out = conn.getOutputStream();
		out.write(buffer.toString().getBytes());
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder response = new StringBuilder();
		String result;
		while (null != (result = in.readLine())) {
			response.append(result);
		}
		in.close();
		System.out.println(response);
	}

}
