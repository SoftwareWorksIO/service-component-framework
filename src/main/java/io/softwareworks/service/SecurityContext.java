package io.softwareworks.service;

/**
 * The specification of the Security Context component.
 *
 * @author Topbit Du
 * @since v1.0
 */
public interface SecurityContext
{
    public static final String BEAN_ID = "SecurityContext";

    public String getRequestId();

    public void setRequestId(String requestId);

    public String getVisitorId();

    public void setVisitorId(String visitorId);

    public String getVisitorType();

    public void setVisitorType(String visitorType);

    public String getSessionId();

    public void setSessionId(String sessionId);
}
