package io.softwareworks.service;

/**
 * The Pagination specification defines the interface of the pagination information component.
 *
 * @author Topbit Du
 * @since v1.0
 */
public interface Pagination
{
    String BEAN_ID = "Pagination";

    /**
     * The major method of the Pagination component.
     * It calculates the full pagination information per the total items, the items per page, and the current page number.
     *
     * @param totalItems the total count of all the items.
     * @param perPage the item count per page.
     * @param currentPage the current page number. It starts from 1 instead of 0.
     */
    void paginate(long totalItems, long perPage, long currentPage);

    long getTotalItems();

    long getPerPage();

    long getCurrentPage();

    long getTotalPages();

    long getMinItemOnCurrentPage();

    long getMaxItemOnCurrentPage();

    long getItemsOnCurrentPage();
}
