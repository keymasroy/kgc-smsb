package kr.co.kgc.smsb.common.base.config.authentication;

import com.gsitm.ustra.java.security.authentication.properties.UstraAuthenticationProperties;
import com.gsitm.ustra.java.security.authentication.request.UstraAuthenticationRequestTokenChecker;
import com.gsitm.ustra.java.security.authentication.request.token.AnonymousUserRequestToken;
import com.gsitm.ustra.java.security.authentication.request.token.UserNamePasswordAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.exception.UstraSecurityResponseCode;
import org.apache.commons.lang3.StringUtils;

public class SmsbFoRequestTokenChecker implements UstraAuthenticationRequestTokenChecker {

    // 유효성 체크 실패 시 Exception을 발생시킨다.
    public void check(UstraAuthenticationProperties properties, UstraAuthenticationRequestToken authenticationRequestToken) {

        if (authenticationRequestToken == null) {
            throw UstraSecurityResponseCode.INVALID_AUTHENTICATION_REQUEST.exception();
        }

        if (authenticationRequestToken instanceof AnonymousUserRequestToken && !properties.isAllowAnoymousAuthentication()) {
            throw UstraSecurityResponseCode.CANNOT_ANONYMOUS_ACCESS.exception();
        }

        if (authenticationRequestToken instanceof UserNamePasswordAuthenticationRequestToken) {
            if (StringUtils.isEmpty(authenticationRequestToken.getUserName())) {
                throw UstraSecurityResponseCode.CANNOT_ANONYMOUS_ACCESS.exception();
            }

            if (StringUtils.isEmpty(((UserNamePasswordAuthenticationRequestToken) authenticationRequestToken).getPassword())) {
                throw UstraSecurityResponseCode.NOT_ALLOWD_EMPTY_PASSWORD.exception();
            }
        }

        if (!(authenticationRequestToken instanceof AnonymousUserRequestToken)) {
            // username 이 없으므로 체크안함
//            if (StringUtils.isEmpty(authenticationRequestToken.getUserName())) {
//                throw UstraSecurityResponseCode.CANNOT_ANONYMOUS_ACCESS.exception();
//            }
        }

    };
}
