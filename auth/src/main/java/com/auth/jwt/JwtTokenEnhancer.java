package com.auth.jwt;

import org.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 拓展jwt 认证信息
 */
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        // 给/oauth/token接口加属性roles,author
        String roles = "";
        if (authentication.getAuthorities().size() > 0) {
            JSONObject jsonObject = new JSONObject(authentication.getPrincipal());
            List<Object> authorities = jsonObject.getJSONArray("authorities").toList();
            StringBuilder stringBuilder = new StringBuilder();
            for (Object authority : authorities) {
                Map map = (Map) authority;
                stringBuilder.append(map.get("authority"));
                stringBuilder.append(",");
            }
            roles = stringBuilder.toString();
        }
        if (StringUtils.isNotBlank(roles)) {
            additionalInfo.put("roles", roles.substring(0, roles.length() - 1));
        }
        additionalInfo.put("author", "example");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        additionalInfo.put("createTime", df.format(LocalDateTime.now()));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
