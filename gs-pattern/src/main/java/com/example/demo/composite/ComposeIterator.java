package com.example.demo.composite;


import java.util.Iterator;
import java.util.Stack;

/**
 * 场景类负责树状结构的建立，并可以通过递归方式遍历整个树
 *
 * @author TomLuo
 * @date 2019/10/20
 */
public class ComposeIterator implements Iterator<MenuComponent> {
    private Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public ComposeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }
        Iterator peek = stack.peek();
        if (!peek.hasNext()) {
            stack.pop();
            return hasNext();
        } else {
            return true;
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> peek = stack.peek();
            MenuComponent next = peek.next();
            stack.push(next.getIterator());
            return next;
        }
        return null;
    }
}
