package io.softwareworks.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * The base implementation of the {@link BusinessService}.
 *
 * @param <BusinessContext> The generic type of the Business Context component instance
 * @param <Entity> The generic type of the Entity component instance
 * @param <Criteria> The generic type of the Criteria instance
 *
 * @author Topbit Du
 * @since v1.0
 */
@Getter
@Setter
public abstract class AbstractBusinessService<BusinessContext, Entity, Criteria> implements BusinessService<BusinessContext, Entity, Criteria>
{
    private SecurityContext securityContext;

    private Result<Entity, Criteria> result;

    @Lookup(SecurityContext.BEAN_ID)
    public SecurityContext newSecurityContext()
    {
        return securityContext;
    }

    @Lookup(Result.BEAN_ID)
    public Result<Entity, Criteria> newResult()
    {
        return result;
    }
}
