package com.util.json;

import com.github.pagehelper.Page;
import com.vo.util.DomainPage;

/**
 * @Description: Response
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 11:44
 */
public class Response implements java.io.Serializable {

    private String code = "2000";

    private Object data;

    public Response() {
    }

    public Response(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        if(data instanceof Page){
            Page page = (Page) data;
            DomainPage domainPage = new DomainPage(page.getPageSize(), page.getPageNum(), page.getTotal());
            domainPage.setDomains(page);
            this.data = domainPage;
        }else {
            this.data = data;
        }
    }
}
