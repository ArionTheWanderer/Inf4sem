package homework3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {
    private Browser originator;
    private Deque<Browser.Snapshot> backStack;
    private Deque<Browser.Snapshot> forwardStack;

    Caretaker(Browser originator) {
        this.originator = originator;
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
    }

    private void addSnapshotToBackStack() {
        Browser.Snapshot snapshot = originator.makeSnapshot();
        backStack.addFirst(snapshot);
    }

    private void addSnapshotToForwardStack() {
        Browser.Snapshot snapshot = originator.makeSnapshot();
        forwardStack.addFirst(snapshot);
    }

    public String go_to(String link) {
        if (PageStructure.getInstance().isPage(link)) {
            addSnapshotToBackStack();
            originator.setCurrentPage(link);
            forwardStack.clear();
            return link;
        } else
            return originator.getCurrentPage();
    }

    public String link(String link) {
        if (PageStructure.getInstance().isLink(originator.getCurrentPage(), link)) {
            addSnapshotToBackStack();
            originator.setCurrentPage(link);
            forwardStack.clear();
            return link;
        } else
            return originator.getCurrentPage();
    }

    public String back() {
        if (!backStack.isEmpty()){
            addSnapshotToForwardStack();
            Browser.Snapshot snapshot = backStack.removeFirst();
            originator.restore(snapshot);
            return originator.getCurrentPage();
        } else
            return originator.getCurrentPage();
    }

    public String forward() {
        if (!forwardStack.isEmpty()) {
            addSnapshotToBackStack();
            Browser.Snapshot snapshot = forwardStack.removeFirst();
            originator.restore(snapshot);
            return originator.getCurrentPage();
        } else
            return originator.getCurrentPage();
    }
}
