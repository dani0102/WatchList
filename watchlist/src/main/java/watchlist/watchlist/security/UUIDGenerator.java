package watchlist.watchlist.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * This class contains static methods to generate UUIDs.
 *
 * @author Joel Holzer
 */
public class UUIDGenerator {
	
	private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	/**
	 * This method generates a UUID (unique key) using Message Digest and Type 4
	 * UUID.
	 *
	 * @return                              String Generated UUID
	 * @throws UnsupportedEncodingException If SHA-256 is not supported
	 * @throws NoSuchAlgorithmException     If UTF-8 is not supported
	 */
	public static String generateUUID() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// Generates a version 4 UUID
		UUID uuid = UUID.randomUUID();
		
		// Generate a unique key using SHA-256 to reduce the chance of collisions
		MessageDigest salt = MessageDigest.getInstance("SHA-256");
		salt.update(uuid.toString().getBytes("UTF-8"));
		String digest = bytesToHex(salt.digest());
		
		return digest;
	}
	
	/**
	 * This method converts a byte-Array to a hex-String.
	 *
	 * @param  bytes byte[] Array to convert
	 * @return       String Given byte-Array as String
	 */
	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
