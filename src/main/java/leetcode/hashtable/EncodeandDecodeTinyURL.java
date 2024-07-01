package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 *
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeandDecodeTinyURL {

    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        EncodeandDecodeTinyURL tinyURL = new EncodeandDecodeTinyURL();
        String encode = tinyURL.encode("url");
        System.out.println(encode);
        System.out.println(tinyURL.decode(encode));
    }


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = String.valueOf(longUrl.hashCode());
        map.put(longUrl, encoded);
        map.put(encoded, longUrl);
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
