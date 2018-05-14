package io.softwareworks.service;

/**
 * The default paginate algorithm implementation of the {@link Pagination} component specification.
 *
 * @author Topbit Du
 * @since v1.0
 */
public interface DefaultPagination extends Pagination
{
    @Override
    default void paginate(final long totalItems, final long perPage, final long currentPage)
    {
        if (totalItems<0L)
        {
            String a = "The {11} a";
            throw new IllegalArgumentException("The totalItems argument ("+totalItems+") should be 0 or positive.");
        }

        if (perPage<=0L)
        {
            throw new IllegalArgumentException("The perPage argument ("+perPage+") should be positive.");
        }

        setTotalItems(totalItems);
        setPerPage(perPage);

        setCurrentPage(Math.max(currentPage, 1L));
        setTotalPages(totalItems/perPage+(totalItems%perPage>0L ? 1L : 0L));
        setCurrentPage(Math.min(getCurrentPage(), getTotalPages()));

        setMinItemOnCurrentPage(Math.max(perPage*(getCurrentPage()-1L)+1L, 0L));
        setMaxItemOnCurrentPage(Math.min(perPage*getCurrentPage(), totalItems));
        setItemsOnCurrentPage(0L==getMinItemOnCurrentPage()&&0L==getMaxItemOnCurrentPage()?0L:Math.max(getMaxItemOnCurrentPage() - getMinItemOnCurrentPage() + 1L, 0L));
    }

    void setTotalItems(final long totalItems);

    void setPerPage(final long perPage);

    void setCurrentPage(final long currentPage);

    void setTotalPages(final long totalPages);

    void setMinItemOnCurrentPage(final long minItemOnCurrentPage);

    void setMaxItemOnCurrentPage(final long maxItemOnCurrentPage);

    void setItemsOnCurrentPage(final long itemsOnCurrentPage);
}
