
package com.mx.server.scalar;


import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ScalarDate extends GraphQLScalarType {
    public ScalarDate() {
        //第一个参数的值必须和 main.graphql 文件中 scalar 定义的相同，第二个可以随意起名
        super("Date", "日期", new Coercing() {

/**
             * 当后端向前端发送 Date 类型数据时调用的方法，将数据转换为 String 型
             * o 可以强制转型为 LocalDateTime
             * 将 LocalDateTime 型的数据转换为 String 型再传给前端
             * @param o
             * @return 返回给前端的数据
             */

            @Override
            public String serialize(Object o) throws CoercingSerializeException {
                Timestamp timestamp = (Timestamp) o;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("serialize-->"+ formatter.format(timestamp));
                return formatter.format(timestamp);
            }

            @Override
            public Timestamp parseValue(Object o) throws CoercingParseValueException {
                String value = o.toString();
                System.out.println("parseLiteral-->"+value);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = null;
                try {
                    parse = formatter.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Timestamp timestamp = new Timestamp(parse.getTime());
                return timestamp;
            }


/**
             * 当前端向后端传输 Date 类型数据时调用的方法，将数据转换为 LocalDateTime 型
             * 此时，o 不能强制转型为 LocalDateTime，只能转为 StringValue 型
             * @param o 前端传入的数据
             * @return 后端接受的数据
             */

            @Override
            public Timestamp parseLiteral(Object o) throws CoercingParseLiteralException {
                if (o instanceof Timestamp) {
                    return (Timestamp) o;
                }
                String value = o.toString();
                System.out.println("parseLiteral-->"+value);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = null;
                try {
                    parse = formatter.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Timestamp timestamp = new Timestamp(parse.getTime());
                return timestamp;
            }
        });
    }
}
