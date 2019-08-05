package com.pl.spring;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class Client {

    private String id;
    private String fullName;
    
    public Client(String id, String name) {
        this.id = id;
        this.fullName = name;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("name", fullName)
                .toString();
    }
}
