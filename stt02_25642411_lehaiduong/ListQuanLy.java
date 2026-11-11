package stt02_25642411_lehaiduong;

import java.util.*;
import java.util.function.Predicate;

class ListQuanLy<T> {
    private final List<T> ds = new ArrayList<>();

    public void them(T t) {
        ds.add(t);
    }

    @SafeVarargs
    public final void themNhieu(T... items) {
        ds.addAll(Arrays.asList(items));
    }

    public long dem(Predicate<T> dieuKien) {
        return ds.stream().filter(dieuKien).count();
    }

    public List<T> getDs() {
        return ds;
    }
}
