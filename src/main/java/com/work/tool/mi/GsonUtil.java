package com.work.tool.mi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


public class GsonUtil {
    private static final ThreadLocal<Gson> THREAD_LOCAL_GSON = ThreadLocal.withInitial(GsonUtil::newGson);
    private static final ThreadLocal<Gson> THREAD_LOCAL_STRING_GSON = ThreadLocal.withInitial(GsonUtil::newStringGson);

    public static final Type TOKEN_LIST_INT = new TypeToken<List<Integer>>() {
    }.getType();

    public static final Type TOKEN_LIST_LONG = new TypeToken<List<Long>>() {
    }.getType();

    public static final Type TOKEN_LIST_STRING = new TypeToken<List<String>>() {
    }.getType();

    public static String toJson(Object obj) {
        return obj == null ? null : gson().toJson(obj);
    }

    public static String toJson(Object obj, boolean prettyFormat) {
        return obj == null ? null : (prettyFormat ? stringGson().toJson(obj) : toJson(obj));
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return fromJson(json, (Type) clazz);
    }

    public static <T> T json2Bean(String json, Class<T> clazz) {
        Type type = new TypeToken<T>() {
        }.getType();
        return fromJson(json, type);
    }

    public static <T> T json2List(String json, Class<T> clazz) {
        Type type = new TypeToken<List<T>>() {
        }.getType();
        return fromJson(json, type);
    }

    public static <T> T json2Set(String json, Class<T> clazz) {
        Type type = new TypeToken<Set<T>>() {
        }.getType();
        return fromJson(json, type);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson().fromJson(json, typeOfT);
    }

    public static Gson gson() {
        return THREAD_LOCAL_GSON.get();
    }

    public static Gson stringGson() {
        return THREAD_LOCAL_STRING_GSON.get();
    }

    /*
     * 准确的说，不建议使用这个方法来暴力new一个对象
     * */
    public static Gson newGson() {
        return new GsonBuilder()
                .registerTypeAdapter(AtomicInteger.class, ADAPTER_ATOMIC_INTEGER)
                .registerTypeAdapter(AtomicLong.class, ADAPTER_ATOMIC_LONG)
                .create();
    }

    public static Gson newStringGson() {
        return new GsonBuilder()
                .registerTypeAdapter(AtomicInteger.class, ADAPTER_ATOMIC_INTEGER)
                .registerTypeAdapter(AtomicLong.class, ADAPTER_ATOMIC_LONG)
                .setPrettyPrinting()
                .create();
    }

    static final TypeAdapter<AtomicInteger> ADAPTER_ATOMIC_INTEGER = new TypeAdapter<AtomicInteger>() {
        @Override
        public AtomicInteger read(JsonReader in) throws IOException {
            try {
                return new AtomicInteger(in.nextInt());
            } catch (IllegalStateException e) {
                //try to explain as origin object
                in.beginObject();
                in.nextName();
                in.peek();
                int value = in.nextInt();
                in.endObject();
                return new AtomicInteger(value);
            }
        }

        @Override
        public void write(JsonWriter out, AtomicInteger value) throws IOException {
            out.value(value.get());
        }
    }.nullSafe();

    static final TypeAdapter<AtomicLong> ADAPTER_ATOMIC_LONG = new TypeAdapter<AtomicLong>() {
        @Override
        public AtomicLong read(JsonReader in) throws IOException {
            try {
                return new AtomicLong(in.nextInt());
            } catch (IllegalStateException e) {
                //try to explain as origin object
                in.beginObject();
                in.nextName();
                in.peek();
                long value = in.nextLong();
                in.endObject();
                return new AtomicLong(value);
            }
        }

        @Override
        public void write(JsonWriter out, AtomicLong value) throws IOException {
            out.value(value.get());
        }
    }.nullSafe();


    public static List<Long> getLongListFromJson(String json) {
        if (StringUtils.isEmpty(json)) {
            return new ArrayList<>();
        }

        return fromJson(json, TOKEN_LIST_LONG);
    }

    public static List<String> getStringListFromJson(String json) {
        if (StringUtils.isEmpty(json)) {
            return new ArrayList<>();
        }

        return fromJson(json, TOKEN_LIST_STRING);
    }
}
