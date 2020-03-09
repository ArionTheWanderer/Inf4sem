package homework3;

public class Browser {
    public String getCurrentPage() {
        return currentPage;
    }

    private String currentPage;

    Browser() {
        currentPage = PageStructure.getInstance().getStartPage();
        System.out.println("Browser has been created! Current page is " + currentPage);
    }

    public Snapshot makeSnapshot() {
        return new Snapshot(currentPage);
    }

    public void restore(Snapshot snapshot) {
        currentPage = snapshot.getState();
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    class Snapshot {
        private String page;

        private Snapshot(String page) {
            this.page = page;
        }

        private String getState() {
            return page;
        }
    }
}
