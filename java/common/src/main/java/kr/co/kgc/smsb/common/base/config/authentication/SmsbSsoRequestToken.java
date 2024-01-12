package kr.co.kgc.smsb.common.base.config.authentication;

import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SmsbSsoRequestToken extends UstraAuthenticationRequestToken{
    private String ssoKey;
}
