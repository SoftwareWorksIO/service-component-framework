package io.softwareworks.service;

import java.util.List;
import java.util.Map;

/**
 * The specification of the Result component.
 *
 * @param <Entity> the generic type of the Entity instance
 * @param <Criteria> the generic type of the Criteria instance
 *
 * @author Topbit Du
 * @since v1.0
 */
public interface Result<Entity, Criteria>
{
    public static final String BEAN_ID = "Result";

    /**
     * The default code for success.
     */
    String CODE_SUCCESS = "success";

    /**
     * The default code for failure.
     */
    String CODE_FAILURE = "failure";
    String CODE_FAILURE_BAD_PARAMETER = "failure-bad-parameter";

    /**
     * Determines whether the service handled successfully.
     *
     * @return whether the service handled successfully.
     */
    public boolean isSuccess();

    public void setSuccess(boolean success);

    /**
     * Returns the error code. A pre-defined system of error code is preferred.
     *
     * @return the error code. The CODE_SUCCESS is returned if success.
     *         The code should be a machine-friendly code, so the front-end program can handle it.
     */
    public String getCode();

    public void setCode(String code);

    /**
     * Returns the human-friendly message for the final user.
     *
     * @return the human-friendly message for the final user.
     */
    public String getMessage();

    public void setMessage(String message);

    /**
     * Returns the size of the collection.
     *
     * @return the size of the collection.
     */
    public long getSize();

    public void setSize(long size);

    /**
     * Returns the list of the entities.
     * If the request is to create or update, only 1 entity should be inside this collection.
     * If the request is query, 0, 1 or many entities could be placed inside this collection.
     *
     * @return the list of the entities.
     */
    public List<Entity> getCollection();

    public void setCollection(List<Entity> collection);

    /**
     * Returns the meta data of the collection.
     *
     * @return the meta data of the collection.
     */
    public ResultMeta<Criteria> getMeta();

    public void setMeta(ResultMeta<Criteria> meta);

    /**
     * Returns the errors.
     * The keys must be the field name in the request.
     * The values are the arrays, consists of human-friendly message.
     *
     * @return the errors.
     */
    public Map<String, String[]> getErrors();

    public void setErrors(Map<String, String[]> errors);
}
