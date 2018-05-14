package io.softwareworks.service.imp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaginationImpTest {

    private PaginationImp pagination;

    @BeforeEach
    public void setUp() {
        pagination = new PaginationImp();
    }

    @AfterEach
    public void tearDown() {
        pagination = null;
    }

    @ParameterizedTest(name = "{index}: paginate total {0} items, {1} items per page, on page {2}, get total {3} pages, {6} items are shown from {4} to {5}")
    @MethodSource("paginateSuccessProvider")
    @DisplayName("paginate should be success")
    public void testPaginate(final long totalItems, final long perPage, final long currentPage, final long totalPages, final long minItemOnCurrentPage, final long maxItemOnCurrentPage, final long itemsOnCurrentPage)
    {
        pagination.paginate(totalItems, perPage, currentPage);

        Assertions.assertEquals(totalPages, pagination.getTotalPages());
        Assertions.assertEquals(minItemOnCurrentPage, pagination.getMinItemOnCurrentPage());
        Assertions.assertEquals(maxItemOnCurrentPage, pagination.getMaxItemOnCurrentPage());
        Assertions.assertEquals(itemsOnCurrentPage, pagination.getItemsOnCurrentPage());
    }

    static Stream<Arguments> paginateSuccessProvider() {
        return Stream.of(
                Arguments.of(0L, 10L, 1L, 0L, 0L, 0L, 0L),
                Arguments.of(1L, 10L, 1L, 1L, 1L, 1L, 1L),
                Arguments.of(9L, 10L, 1L, 1L, 1L, 9L, 9L),
                Arguments.of(10L, 10L, 1L, 1L, 1L, 10L, 10L),
                Arguments.of(11L, 10L, 1L, 2L, 1L, 10L, 10L),
                Arguments.of(11L, 10L, 2L, 2L, 11L, 11L, 1L),
                Arguments.of(11L, 10L, 0L, 2L, 1L, 10L, 10L),
                Arguments.of(11L, 10L, 3L, 2L, 11L, 11L, 1L),
                Arguments.of(11L, 10L, 0L, 2L, 1L, 10L, 10L),
                Arguments.of(11L, 10L, -1L, 2L, 1L, 10L, 10L)
        );
    }

    @ParameterizedTest(name = "{index}: paginate total {0} items, {1} items per page, on page {2} should raise illegal argument exception")
    @MethodSource("paginateIllegalArgumentProvider")
    @DisplayName("paginate should raise illegal argument exception")
    public void testPaginateWithIllegalArguments(final long totalItems, final long perPage, final long currentPage)
    {
        Throwable illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            pagination.paginate(totalItems, perPage, currentPage);
        });
        assertNotNull(illegalArgumentException);
    }

    static Stream<Arguments> paginateIllegalArgumentProvider() {
        return Stream.of(
                Arguments.of(-1L, 10L, 1L),
                Arguments.of(-2L, 10L, 1L),
                Arguments.of(-Long.MAX_VALUE, 10L, 1L),
                Arguments.of(11L, 0L, 1L),
                Arguments.of(11L, -1L, 1L),
                Arguments.of(11L, -2L, 1L),
                Arguments.of(11L, -Long.MAX_VALUE, 1L),
                Arguments.of(-1L, -1L, 1L)
        );
    }
}
