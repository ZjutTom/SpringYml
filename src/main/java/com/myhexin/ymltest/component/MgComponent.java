package com.myhexin.ymltest.component;

import com.myhexin.ymltest.model.U;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "data")
public class MgComponent {
    private List<U> lists;

    public List<U> getLists() {
        return lists;
    }

    public void setLists(List<U> lists) {
        this.lists = lists;
    }
}
