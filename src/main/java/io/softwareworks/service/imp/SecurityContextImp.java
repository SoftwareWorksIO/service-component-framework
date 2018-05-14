package io.softwareworks.service.imp;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import io.softwareworks.service.SecurityContext;

/**
 * The implementation class of the {@link SecurityContext} component specification.
 *
 * @author Topbit Du
 * @since v1.0
 */
@Component(SecurityContext.BEAN_ID)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class SecurityContextImp implements SecurityContext
{
    private String requestId;
    private String visitorId;
    private String sessionId;
    private String visitorType;
}
