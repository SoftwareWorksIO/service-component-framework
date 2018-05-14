package io.softwareworks.service.imp;

import io.softwareworks.service.DefaultPagination;
import io.softwareworks.service.Pagination;
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * The implementation class of the {@link Pagination} component specification.
 *
 * @author Topbit Du
 * @since v1.0
 */
@Component(Pagination.BEAN_ID)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class PaginationImp implements DefaultPagination
{
    public PaginationImp()
    {
        super();
        totalItems = 0L;
        perPage = 10L;
        currentPage = 1L;
    }

    private long totalItems;
    private long perPage;
    private long currentPage;
    private long totalPages;
    private long minItemOnCurrentPage;
    private long maxItemOnCurrentPage;
    private long itemsOnCurrentPage;
}
