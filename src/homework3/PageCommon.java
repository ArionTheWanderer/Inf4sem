package homework3;

public class PageCommon implements Page {
    private String page;
    private int position;

    PageCommon(String page) {
        this.page = page;
        position = 0;
    }

    @Override
    public String getPage() {
        return page;
    }

    @Override
    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void goToAdv() {
        System.out.println("There is not any advertising");
    }
}
