package io.softwareworks.service.imp;

import io.softwareworks.service.Pagination;
import io.softwareworks.service.ResultMeta;
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * The implementation class of the {@link ResultMeta} component specification.
 *
 * @param <Criteria> the generic type of the Criteria instance
 *
 * @author Topbit Du
 * @since v1.0
 */
@Component(ResultMeta.BEAN_ID)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class ResultMetaImp<Criteria> implements ResultMeta<Criteria>
{
    public ResultMetaImp()
    {
        timestamp = System.currentTimeMillis();
    }

    private String requestId;

    private long timestamp;

    private Criteria criteria;

    @Resource(name = Pagination.BEAN_ID)
    private Pagination pagination;
}
