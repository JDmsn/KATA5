package kata5;

import java.util.ArrayList;

public class MailHistogramBuilder {
    public static Histogram<String> build (ArrayList<String> mlList) {
        Histogram<String> hm = new Histogram<>();
        for(String ml : mlList) {
            hm.increment(new Mail(ml).getDomain());
        }
        return hm;
    }
}
