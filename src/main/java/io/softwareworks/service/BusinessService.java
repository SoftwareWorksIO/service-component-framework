package io.softwareworks.service;

/**
 * The Business Service is the specification for all the service components.
 * <p>
 * The major method is the execute method.
 * The newSecurityContext method is a Spring lookup method.
 *
 * @param <BusinessContext> The generic type of the Business Context component instance
 * @param <Entity> the generic type of the Entity component instance
 * @param <Criteria> the generic type of the Criteria instance
 *
 * @author Topbit Du
 * @since v1.0
 */
public interface BusinessService<BusinessContext, Entity, Criteria>
{
    /**
     * This method returns a new Security Context component instance per Spring lookup method.
     *
     * @return a new Security Context component instance per Spring lookup method.
     */
    public SecurityContext newSecurityContext();

    /**
     * The major method of a service component. This method execute the main business logics.
     *
     * @param securityContext An instance of the Security Context component.
     * @param businessContext An instance of a business context.
     * @return An instance of the Result component.
     */
    public Result<Entity, Criteria> execute(SecurityContext securityContext, BusinessContext businessContext);
}
