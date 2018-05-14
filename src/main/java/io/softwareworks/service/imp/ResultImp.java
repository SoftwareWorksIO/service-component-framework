package io.softwareworks.service.imp;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import io.softwareworks.service.Result;
import io.softwareworks.service.ResultMeta;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation class of the {@link Result} component specification.
 *
 * @param <Entity> the generic type of the Entity component instance
 * @param <Criteria> the generic type of the Criteria instance
 *
 * @author Topbit Du
 * @since v1.0
 */
@Component(Result.BEAN_ID)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class ResultImp<Entity, Criteria> implements Result<Entity, Criteria>
{
    public ResultImp()
    {
        collection = new ArrayList<Entity>();
        errors = new HashMap<String, String[]>();
    }

    private boolean success;

    private String code;

    private String message;

    private long size;

    private List<Entity> collection;

    @Resource(name = ResultMeta.BEAN_ID)
    private ResultMeta<Criteria> meta;

    private Map<String, String[]> errors;
}
