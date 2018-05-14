package io.softwareworks.service;

/**
 * The specification of the Result Meta Data component.
 *
 * @param <Criteria> the generic type of the criteria instance
 *
 * @author Topbit Du
 * @since v1.0
 */
public interface ResultMeta<Criteria>
{
    public static final String BEAN_ID = "ResultMeta";

    /**
     * Returns the ID of the request. It should be identical to {@link SecurityContext#getRequestId()}.
     * This field is used for debugging.
     *
     * @return the ID of the request.
     */
    public String getRequestId();

    public void setRequestId(String requestId);

    /**
     * Returns the current milliseconds from 1970-01-01 00:00:00 UTC.
     *
     * @return the current milliseconds from 1970-01-01 00:00:00 UTC.
     */
    public long getTimestamp();

    public void setTimestamp(long timestamp);

    /**
     * Returns the parameters of the request.
     * The following content should be excluded:
     *   - big binary content: uploaded file
     *   - credentials: password
     *
     * @return the parameters of the request.
     */
    public Criteria getCriteria();

    public void setCriteria(Criteria criteria);

    /**
     * Returns the Pagination component with full information.
     *
     * @return the Pagination component with full information.
     */
    public Pagination getPagination();

    public void setPagination(Pagination pagination);
}
