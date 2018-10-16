package com.ibtikar.app.dutchmart.utils;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public class RxBus {
    //this how to create our bus
    private static final BehaviorSubject<Object> behaviorSubject
            = BehaviorSubject.create();


    public static Disposable subscribe(@NonNull Consumer<Object> action) {
        return behaviorSubject.subscribe(action);
    }
    //use this method to send data
    public static void publish(@NonNull Object message) {
        behaviorSubject.onNext(message);
    }
}
