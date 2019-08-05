package com.pl.spring;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;

@Data
public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        id = getRandom();
        this.date = date;
        this.df = df;
    }

    private int getRandom() {
        SecureRandom sr = new SecureRandom();
        return sr.nextInt(Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("message", msg)
                .append("date", df.format(date))
                .toString().concat(System.lineSeparator());
    }
}
