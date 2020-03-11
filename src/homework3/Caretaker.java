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
        if (Site.getInstance().isPage(link)) {
            addSnapshotToBackStack();
            originator.setCurrentPage(Site.getInstance().createPage(link));
            forwardStack.clear();
            return link;
        } else
            return originator.getCurrentPage().getPage();
    }

    public String link(String link) {
        if (Site.getInstance().isLink(originator.getCurrentPage().getPage(), link)) {
            addSnapshotToBackStack();
            originator.setCurrentPage(Site.getInstance().createPage(link));
            forwardStack.clear();
            return link;
        } else
            return originator.getCurrentPage().getPage();
    }

    public String back() {
        if (!backStack.isEmpty()){
            addSnapshotToForwardStack();
            Browser.Snapshot snapshot = backStack.removeFirst();
            originator.restore(snapshot);
            return originator.getCurrentPage().getPage();
        } else
            return originator.getCurrentPage().getPage();
    }

    public String forward() {
        if (!forwardStack.isEmpty()) {
            addSnapshotToBackStack();
            Browser.Snapshot snapshot = forwardStack.removeFirst();
            originator.restore(snapshot);
            return originator.getCurrentPage().getPage();
        } else
            return originator.getCurrentPage().getPage();
    }

    public int goToPosition(int position) {
        if (position >= 0 && position <= 100) {
            originator.getCurrentPage().setPosition(position);
            return position;
        }
        else return originator.getCurrentPage().getPosition();
    }

    public String getPage() {
        return originator.getCurrentPage().getPage();
    }

    public int getPosition() {
        return originator.getCurrentPage().getPosition();
    }

    public String goToAdv() {
        if (Site.getInstance().getTextOnPosition(originator.getCurrentPage().getPage(), originator.getCurrentPage().getPosition()) != null) {
            addSnapshotToBackStack();
        }
        return originator.goToAdv();
    }
}
