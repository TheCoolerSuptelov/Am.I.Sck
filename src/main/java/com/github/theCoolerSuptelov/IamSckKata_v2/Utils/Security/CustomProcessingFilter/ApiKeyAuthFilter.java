package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security.CustomProcessingFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private static String principalRequestHeader_Secret = "100PercentSecure";
    private static String principalRequestValue_Secret = "StaticSecretKey";
    private static String principalRequestHeader = "100PercentSecure";
    private static String principalRequestValue = "StaticSecretKey";

    public static String getPrincipalRequestHeader() {
        return principalRequestHeader_Secret;
    }

    public static String getPrincipalRequestValue() {
        return principalRequestValue_Secret;
    }



    public void APIKeyAuthFilter(String principalRequestHeader) {
        this.principalRequestHeader = principalRequestHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(principalRequestHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }

}