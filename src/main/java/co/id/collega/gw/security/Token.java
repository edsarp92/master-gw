package co.id.collega.gw.security;

/**
 * Created by edsarp on 10/30/16.
 */
public class Token {
    String token;
    long expires;

    public Token(String token, long expires){
        this.token = token;
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public long getExpires() {
        return expires;
    }
}
