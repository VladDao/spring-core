package com.pl.spring;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class Client {

    private String id;
    private String fullName;
    private String gr;

    public Client(String id, String name) {
        this.id = id;
        this.fullName = name;
    }

    public Client() {
    }

    public void setGreeting(String gr) {
        this.gr = gr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("name", fullName)
                .append("Greeting", gr)
                .toString();
    }
}
