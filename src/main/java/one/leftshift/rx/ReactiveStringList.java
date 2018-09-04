package one.leftshift.rx;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * A subject is an observer and observable at the same time
 *
 * @author benjamin.krenn@leftshift.one - 9/4/18.
 * @since 1.0.0
 */
public class ReactiveStringList {

    private final List<String> delegate = new ArrayList<>();
    private final PublishSubject<String> subject = PublishSubject.create();


    public void add(String toAdd) {
        this.delegate.add(toAdd);
        this.subject.onNext(toAdd);
    }

    public Observable<String> observable() {
        return this.subject;
    }

    // could implement List<T> and generified...
}
