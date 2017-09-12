package com.vo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: DomainPage
 * @Author: lin.shi
 * @CreateTime: 2017-07-25 16:14
 */
public class DomainPage<T extends Object> implements  java.io.Serializable {

    private static final long serialVersionUID = 6786042125926490613L;

    private long pageSize;
    private long pageIndex;
    private long pageCount;
    private long totalCount;
    private List<T> domains = new ArrayList<T>();

    /**
     * 缺省构造函数（json反序列化需要用）
     */
    public DomainPage() {
    }

    public DomainPage(long pageSize, long pageIndex, long totalCount) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        if (pageSize < 1) {
            pageSize = 1;
        }
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalCount = totalCount;
        if (totalCount % pageSize > 0) {
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setDomains(List<T> domains) {
        this.domains = domains;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public long getPageCount() {
        return pageCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public List<T> getDomains() {
        return domains;
    }
}
