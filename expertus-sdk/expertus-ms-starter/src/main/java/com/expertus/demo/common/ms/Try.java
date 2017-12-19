package com.expertus.demo.common.ms;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import com.netflix.client.ClientException;
import java.util.function.Supplier;

/**
 *
 *  @author reda
 *
 * @param <T>
 */
public interface Try<T> {


    static <T> Try<T> of(Supplier<? extends T> supplier) {
        Assert.notNull(supplier, "You better execute something not null");

        try {
            return new Success<>(supplier.get());
        } catch (Throwable t) {
            return new Failure<>(t);
        }
    }


    T get();

    int getStatus();

    Throwable getThrowable();

    boolean isFailure();

    boolean isSuccess();

    default T orElseGet(Supplier<T> supplier){
        if (isFailure())
            return supplier.get();
        return get();
    }

    default T orElse(T other){
        if(isFailure())
            return other;
        return get();
    }


    @Data
    final class Success<T> implements Try<T> {

        private final T value;

        public Success(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return this.value;
        }

        @Override
        public int getStatus() {
            return 200;
        }

        @Override
        public boolean isFailure() {
            return false;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public Throwable getThrowable() {
            return new UnsupportedOperationException("No throwable on success ,sorry for that :)");
        }
    }

    @Slf4j
    @Data
    final class Failure<T> implements Try<T> {

        private Throwable cause;


        public Failure(Throwable cause) {
            log.error("feign error",cause);
            this.cause = cause;
        }

        @Override
        public T get() {
            return null;
        }

        @Override
        public int getStatus() {
            if( getThrowable().getCause() instanceof ClientException){
                return 500;
            }
            return 404;
        }

        @Override
        public Throwable getThrowable() {
            return cause;
        }

        @Override
        public boolean isFailure() {
            return true;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }


    }


}
