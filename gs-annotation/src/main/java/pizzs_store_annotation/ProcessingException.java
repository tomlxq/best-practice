package pizzs_store_annotation;

import javax.lang.model.element.Element;

/**
 * Created by tom on 2016/6/6.
 */
public class ProcessingException extends Exception {

    Element element;

    public ProcessingException(Element element, String msg, Object... args) {
        super(String.format(msg, args));
        this.element = element;
    }

    public Element getElement() {
        return element;
    }
}