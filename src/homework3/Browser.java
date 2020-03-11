package homework3;

public class Browser {
    private Page page;

    public Page getCurrentPage() {
        return page;
    }

    public String goToAdv() {
        page.goToAdv();
        return page.getPage();
    }

    Browser() {
        page = Site.getInstance().getStartPage();
        System.out.println("Browser has been created! Current page is " + page.getPage());
    }

    public Snapshot makeSnapshot() {
        return new Snapshot(page);
    }

    public void restore(Snapshot snapshot) {
        page = snapshot.getState();
    }

    public void setCurrentPage(Page page) {
        this.page = page;
    }

    class Snapshot {
        private Page page;

        private Snapshot(Page page) {
            this.page = page;
        }

        private Page getState() {
            return page;
        }
    }
}
