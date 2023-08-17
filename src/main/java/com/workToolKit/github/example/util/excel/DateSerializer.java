package com.workToolKit.github.example.util.excel;

import java.util.Date;

import com.workToolKit.github.example.util.DateUtil;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年8月23日 下午1:47:03<br/>
 */
public class DateSerializer<T> extends FieldTypeSerializer<T, Date> {
    public DateSerializer() {
		super(Date.class);
	}
    @Override
    public String serialize(T bean, Date object) {
        if(object == null){
            return "";
        }
        return DateUtil.format(object, DateUtil.FORMAT_YMDHMS);
    }
}