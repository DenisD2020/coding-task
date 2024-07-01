package leetcode.array;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-browser-history/
 *
 * <p>
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * <p>
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 */
public class DesignBrowserHistory {

    private static LinkedList<String> browser = null;
    int currentPosition = 0;
    int size = 0;

    public static void main(String[] args) {
        DesignBrowserHistory history = new DesignBrowserHistory("leetcode.com");
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        System.out.println(history.back(1));
        System.out.println(history.back(1));
        System.out.println(history.forward(1));
        history.visit("linkedin.com");
        System.out.println(history.forward(2));
        System.out.println(history.back(2));
        System.out.println(history.back(7));
    }

    public DesignBrowserHistory(String homepage) {
        browser.clear();
        browser.add(homepage);
        size++;
    }

    public void visit(String url) {
        if (size == currentPosition) {
            currentPosition++;
            size++;
        } else {
            size = ++currentPosition;
        }
        browser.add(size++, url);
    }

    public String back(int steps) {
        if (currentPosition - steps > 0) {
            currentPosition = currentPosition - steps;
        } else {
            currentPosition = 0;
        }
        return browser.get(currentPosition);
    }

    public String forward(int steps) {
        if (currentPosition + steps < size) {
            currentPosition = currentPosition + steps;
        } else {
            currentPosition = size - 1;
        }
        return browser.get(currentPosition);
    }
}
